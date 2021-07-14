package com.ims.owen.javathecode;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ContainerService {
    public static <T> T getObject(Class<T> classType) {
        T newInstance = getNewInstance(classType);
        Arrays.stream(classType.getDeclaredFields()).forEach(field -> {
            if (field.getAnnotation(Inject.class) != null) {
                Object fieldInstance = getNewInstance(field.getType());
                field.setAccessible(true);
                try {
                    field.set(newInstance, fieldInstance);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        return newInstance;
    }

    private static <T> T getNewInstance(Class<T> classType) {
        try {
            return classType.getConstructor(null).newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
