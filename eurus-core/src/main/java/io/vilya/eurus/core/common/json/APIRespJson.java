package io.vilya.eurus.core.common.json;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author iamaprin
 * @time 2017年6月13日 下午10:47:14
 */
@SuppressWarnings("serial")
public class APIRespJson implements Serializable {
    
    private int code;
    
    private String message;
    
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date systemTime;
        
    public APIRespJson() {
        this(ResultCode.SUCC);
    }
    
    public APIRespJson(ResultCode code) {
        this.code = code.value();
        this.message = code.getHttpReason();
        this.systemTime = new Date();
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the systemTime
     */
    public Date getSystemTime() {
        return systemTime;
    }

    /**
     * @param systemTime the systemTime to set
     */
    public void setSystemTime(Date systemTime) {
        this.systemTime = systemTime;
    }
    
    
}
