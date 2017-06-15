package io.vilya.eurus.core.common.utils;

import io.vilya.eurus.core.common.json.ResultCode;
import io.vilya.eurus.core.exception.EurusException;

/**
 * @author iamaprin
 * @time 2017年6月15日 下午10:42:33
 */
public abstract class AssertUtils {
    
    public static void notNull(Object object) {
        if (object == null) {
            throw new EurusException(ResultCode.PARAM_ERROR);
        }
    }
    
}
