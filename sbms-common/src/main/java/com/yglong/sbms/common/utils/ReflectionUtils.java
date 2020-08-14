package com.yglong.sbms.common.utils;

import java.lang.reflect.Method;

public class ReflectionUtils {
    public static Object invoke(Object object, String method, Object... args) {
        Object result = null;
        Class<? extends Object> clazz = object.getClass();
        Method queryMethod = getMethod(clazz, method, args);
        if (queryMethod != null) {
            try {
                result = queryMethod.invoke(object, args);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                throw new NoSuchMethodException(clazz.getName() + "类中没有找到" + method + "方法。");
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static Method getMethod(Class<? extends Object> clazz, String name, Object[] args) {
        Method method = null;
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            if (m.getName().equals(name)) {
                Class<?>[] parameterTypes = m.getParameterTypes();
                if (parameterTypes.length == args.length) {
                    boolean isSameMethod = true;
                    for (int i = 0; i < parameterTypes.length; i++) {
                        Object arg = args[i];
                        if (arg == null) {
                            arg = "";
                        }
                        if (!parameterTypes[i].equals(args[i].getClass())) {
                            isSameMethod = false;
                        }
                    }
                    if (isSameMethod) {
                        method = m;
                        break;
                    }
                }
            }
        }
        return method;
    }
}
