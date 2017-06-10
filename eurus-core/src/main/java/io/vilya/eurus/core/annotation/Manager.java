package io.vilya.eurus.core.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.sun.jdi.Value;

@Retention(RUNTIME)
@Target(TYPE)
/**
 * @author iamaprin
 * @time 2017年6月10日 下午9:32:14
 */
public @interface Manager {
    
    String value() default "";
    
}
