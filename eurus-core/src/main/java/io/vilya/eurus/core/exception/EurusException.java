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
    
    public EurusException(final Throwable e) {
        this(ResultCode.ERROR, e);
    }
    
    public EurusException(final ResultCode code) {
        this(code, null);
    }
    
    public EurusException(final ResultCode code, final Throwable e) {
        super(e);
        this.code = code;
    }
    
    public EurusException(final ResultCode code, final String message, final Throwable e) {
        super(message, e);
        this.code = code;
    }

    /**
     * @return the code
     */
    public ResultCode getCode() {
        return code;
    }    
}
