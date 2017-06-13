package io.vilya.eurus.core.exception;

/**
 * @author iamaprin
 * @time 2017年6月13日 下午10:19:52
 */
@SuppressWarnings("serial")
public class BeanCopyException extends RuntimeException {
    
    public BeanCopyException(Exception e) {
        super(e);
    }
    
}
