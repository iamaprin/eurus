package io.vilya.eurus.core.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vilya.eurus.core.filter.EurusRequestFilter;
import io.vilya.eurus.core.filter.EurusResponseFilter;
import io.vilya.eurus.core.interceptor.EurusWriterInterceptor;

/**
 * @author iamaprin
 * @time 2017年6月8日 下午10:28:24
 */
@ApplicationPath("api")
public class EurusConfig extends ResourceConfig {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(EurusConfig.class);
    
    public EurusConfig() {
        packages("io.vilya.eurus.core.api");
        
        registerFilter();
        registerInterceptor();
        
        LOGGER.info("jersey started.");
    }
    
    private void registerFilter() {
        register(EurusRequestFilter.class);
        register(EurusResponseFilter.class);
    }
    
    private void registerInterceptor() {
        register(EurusWriterInterceptor.class);
    }
    
}
