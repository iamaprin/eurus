package io.vilya.eurus.core.common.json;

import javax.ws.rs.core.Response.Status;

/**
 * @author iamaprin
 * @time 2017年6月13日 下午10:48:39
 */
public enum ResultCode {
    
    FAIL(-1, Status.INTERNAL_SERVER_ERROR),
    
    SUCC(0, Status.OK),
    
    ERROR(1000, Status.INTERNAL_SERVER_ERROR),
    
    RECORD_NOT_FOUND(1101, Status.NOT_FOUND),
    
    PARAM_ERROR(1201, Status.BAD_REQUEST);
    
    private int value;
    private Status httpStatusCode;
    
    ResultCode(int value, Status httpStatusCode) {
        this.value = value;
        this.httpStatusCode = httpStatusCode;
    }
 
    public int value() {
        return value;
    }
    
    public Status getHttpStatusCode() {
        return httpStatusCode;
    }
    
    public String getHttpReason() {
        return httpStatusCode.getReasonPhrase();
    }
    
    public int getHttpCode() {
        return httpStatusCode.getStatusCode();
    }
}
