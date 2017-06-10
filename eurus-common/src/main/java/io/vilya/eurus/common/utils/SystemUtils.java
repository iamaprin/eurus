package io.vilya.eurus.common.utils;

/**
 * @author iamaprin
 * @time 2017年6月10日 下午10:17:44
 */
public abstract class SystemUtils {
    
    private static final String OS_NAME = "os.name";
    
    private static final String PREFIX_WINDOWS = "Windows";
    
    public static boolean isWindow() {
        return getOsName().indexOf(PREFIX_WINDOWS) != -1;
    }
    
    private static String getOsName() {
        return System.getProperty(OS_NAME);
    }
    
}
