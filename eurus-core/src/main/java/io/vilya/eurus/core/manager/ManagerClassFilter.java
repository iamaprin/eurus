package io.vilya.eurus.core.manager;

import io.vilya.eurus.common.utils.ClassFilter;
import io.vilya.eurus.core.common.annotation.Manager;

/**
 * @author iamaprin
 * @time 2017年6月10日 下午9:34:29
 */
public class ManagerClassFilter implements ClassFilter {

    @Override
    public boolean accept(Class<?> clazz) {
        return clazz.isAnnotationPresent(Manager.class);
    }

}
