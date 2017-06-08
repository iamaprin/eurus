package io.vilya.eurus.core.filter;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author iamaprin
 * @time 2017年6月8日 下午10:51:19
 */
public class EurusRequestFilter implements ContainerRequestFilter {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(EurusRequestFilter.class);
    // 访问日志打印格式
    private static final String ACCESS_LOG_FORMAT = "{} {}";
        
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        printAccessInfo(requestContext);
    }
    
    /**
     * 打印访问信息
     * @param request
     */
    private void printAccessInfo(ContainerRequestContext request) {
        String method = request.getMethod();
        String path = request.getUriInfo().getRequestUri().getPath();
        
        LOGGER.info(ACCESS_LOG_FORMAT, method, path);
    }
}
