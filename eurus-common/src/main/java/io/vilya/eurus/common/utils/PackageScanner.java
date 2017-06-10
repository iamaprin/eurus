package io.vilya.eurus.common.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 包扫描器
 * @author iamaprin
 * @time 2017年6月10日 下午6:57:18
 */
public abstract class PackageScanner {
    
    private static final String CLASS_SUFFIX = ".class";
    
    private static final String EMPTY_STRING = "";
    
    private static final ClassFilter DEFAULT_CLASS_FILTER = new DefaultClassFilter();
    
    private static ClassFilter _classFilter;
    
    private static ClassLoader _classLoader;
    
    private static String classPath;
    
    private static List<Class<?>> classes;
    
    public static synchronized List<Class<?>> scan(ClassLoader classLoader, String packageName, ClassFilter classFilter) {
        classes = new ArrayList<>();
        
        _classLoader = classLoader;
        _classFilter = classFilter;
        classPath = getClassPath();
        
        URL resource = classLoader.getResource(toPath(packageName));
        if (resource == null) {
            return Collections.emptyList();
        }
        
        File file = new File(resource.getFile());
        list(file);
        return classes;
    }
    
    public static synchronized List<Class<?>> scan(String packageName, ClassFilter classFilter) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return scan(classLoader, packageName, classFilter);
    }
    
    public static synchronized List<Class<?>> scan(String packageName) {
        return scan(packageName, DEFAULT_CLASS_FILTER);
    }
    
    private static void list(File file) {
        if (file.isDirectory()) {
            File[] children = file.listFiles();
            for (File child : children) {
                list(child);
            }
        } else {
            resolve(file);
        }
    }
    
    private static void resolve(File file) {
        String absolutePath = file.getAbsolutePath();
        if (!absolutePath.endsWith(CLASS_SUFFIX)) {
            return;
        }
        
        Class<?> clazz = null;
        try {
            clazz = _classLoader.loadClass(prepare(absolutePath));
        } catch (ClassNotFoundException e) {
            // nothing
        }
        
        if (clazz == null) {
            return;
        }
        
        if (_classFilter.accept(clazz)) {
            classes.add(clazz);
        }
    }
    
    private static String getClassPath() {
        String classPath = _classLoader.getResource(EMPTY_STRING).getPath();
        return SystemUtils.isWindow() ? classPath.substring(1) : classPath;
    }
    
    private static String prepare(String path) {
        String formated = path.replaceAll("\\\\", "/")
                .replace(classPath, EMPTY_STRING)
                .replaceAll("/", "\\.");
        
        return trimSuffix(formated);
    }

    private static String trimSuffix(String path) {
        int index = path.lastIndexOf(CLASS_SUFFIX);
        if (index == -1) {
            return path;
        } else {
            return path.substring(0, index);
        }
    }
    
    private static String toPath(String packageName) {
        return packageName.replaceAll("\\.", "/");
    }
    
    private static class DefaultClassFilter implements ClassFilter {
        @Override
        public boolean accept(Class<?> clazz) {
            return true;
        }
    }    
}
