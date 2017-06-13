package io.vilya.eurus.core.common.utils;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import io.vilya.eurus.core.exception.BeanCopyException;

/**
 * @author iamaprin
 * @time 2017年6月13日 下午10:24:33
 */
public class BeanUtilsWrapper {
    
    public static void copyProperties(final Object dest, final Object orig) {
        try {
            BeanUtils.copyProperties(dest, orig);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new BeanCopyException(e);
        }
    }
    
}
