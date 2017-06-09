package io.vilya.eurus.core.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vilya.eurus.core.manager.Managers;

/**
 * @author iamaprin
 * @time 2017年6月9日 下午10:09:41
 */
@WebListener
public class EurusServletContextListener implements ServletContextListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(EurusServletContextListener.class);
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Managers.INSTANCE.startup();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Managers.INSTANCE.shutdown();
    }

}
