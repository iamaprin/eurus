package io.vilya.eurus.core.common.config;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vilya.eurus.core.common.constant.EurusConstants;
import io.vilya.eurus.core.common.json.APIRespJson;
import io.vilya.eurus.core.common.json.ResultCode;
import io.vilya.eurus.core.exception.EurusException;

/**
 * @author iamaprin
 * @time 2017年6月13日 下午11:39:37
 */
public class EurusExceptionMapper implements ExceptionMapper<EurusException> {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(EurusExceptionMapper.class);
    
    @Override
    public Response toResponse(EurusException exception) {
        LOGGER.error(EurusConstants.EMPTY_STRING, exception);
        
        ResultCode code = exception.getCode();
        APIRespJson entity = new APIRespJson(code);
        
        return Response.status(code.getHttpCode())
                .entity(entity)
                .build();
    }

}
