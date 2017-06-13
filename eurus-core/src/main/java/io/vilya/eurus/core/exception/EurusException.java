package io.vilya.eurus.core.exception;

import io.vilya.eurus.core.common.json.ResultCode;

/**
 * @author iamaprin
 * @time 2017年6月13日 下午11:10:51
 */
@SuppressWarnings("serial")
public class EurusException extends RuntimeException {
    
    private final ResultCode code;
    
    public EurusException() {
        this(ResultCode.ERROR);
    }
    
    public EurusException(final ResultCode code) {
        super(code.getHttpReason());
        this.code = code;
    }
    
    public EurusException(final ResultCode code, final String message) {
        super(message);
        this.code = code;
    }

    /**
     * @return the code
     */
    public ResultCode getCode() {
        return code;
    }    
}
