package io.vilya.eurus.core.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vilya.eurus.common.utils.PackageScanner;

/**
 * @author iamaprin
 * @time 2017年6月9日 下午10:36:14
 */
public enum Managers implements IManager {
    
    INSTANCE;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Managers.class);
    
    private static final String MANAGER_PACKAGE = "io.vilya.eurus.core.manager";
    
    private Map<Class<?>, IManager> instances;
    
    Managers() {
        instances = new HashMap<>();
    }
    
    @Override
    public void startup() {
        List<Class<?>> managers = PackageScanner.scan(Thread.currentThread().getContextClassLoader(), 
                MANAGER_PACKAGE, new ManagerClassFilter());
        
        IManager instance;
        for (Class<?> manager : managers) {
            if (!IManager.class.isAssignableFrom(manager)) {
                LOGGER.warn("{} is not a implement of IManager", manager.getSimpleName());
                continue;
            }
            
            try {
                instance = (IManager) manager.newInstance();
                instance.startup();
                instances.put(manager, instance);
                LOGGER.info("manager {} startup.", manager.getSimpleName());
            } catch (InstantiationException | IllegalAccessException e) {
                LOGGER.error("failed to create the instance of {}.", manager.getSimpleName());
            }
        }
    }
    
    public void shutdown() {
        for (Entry<Class<?>, IManager> entry : instances.entrySet()) {
            try {
                entry.getValue().shutdown();
                LOGGER.info("manager {} shutdown.", entry.getKey().getSimpleName());
            } catch (Exception e) {
                LOGGER.info("failed to shutdown manager {}.", entry.getKey().getSimpleName());
            }
        }
    };
    
    public IManager getInstance(Class<?> clazz) {
        return instances.get(clazz);
    }
}
