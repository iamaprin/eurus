package io.vilya.eurus.core.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;


/**
 * @author iamaprin
 * @time 2017年6月12日 下午10:50:59
 */
@Retention(RUNTIME)
@Target(TYPE)
public @interface Service {
    
    String value() default "";
    
}
