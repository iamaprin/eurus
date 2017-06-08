package io.vilya.eurus.core.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;

/**
 * @author iamaprin
 * @time 2017年6月9日 上午12:02:55
 */
public class EurusResponseFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
            throws IOException {
        addPoweredBy(responseContext);
    }
    
    private void addPoweredBy(ContainerResponseContext responseContext) {
        addResponseHeader(responseContext, "X-Powered-By", "Jersey");
    }
    
    private void addResponseHeader(ContainerResponseContext responseContext, String key, String value) {
        MultivaluedMap<String, Object> headers = responseContext.getHeaders();
        headers.add(key, value);
    }
}
