package io.vilya.eurus.core.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import io.vilya.eurus.core.filter.EurusRequestFilter;
import io.vilya.eurus.core.filter.EurusResponseFilter;
import io.vilya.eurus.core.interceptor.EurusWriterInterceptor;

/**
 * @author iamaprin
 * @time 2017年6月8日 下午10:28:24
 */
@ApplicationPath("api")
public class EurusConfig extends ResourceConfig {
    
    public EurusConfig() {
        packages("io.vilya.eurus.core.api");
        
        registerFilter();
        registerInterceptor();
    }
    
    private void registerFilter() {
        register(EurusRequestFilter.class);
        register(EurusResponseFilter.class);
    }
    
    private void registerInterceptor() {
        register(EurusWriterInterceptor.class);
    }
    
}
