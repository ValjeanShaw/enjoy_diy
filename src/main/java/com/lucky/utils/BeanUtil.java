package com.lucky.utils;

import static org.springframework.beans.BeanUtils.copyProperties;
import static org.springframework.beans.BeanUtils.instantiate;

/**
 * @author 600006
 * @version 1.0
 */
public class BeanUtil{
    /**
     * 将来源对象的值，赋给目标类的对象，返回该类的对象
     *
     * @param source      属性复制的源对象
     * @param targetClazz 属性复制的目标对象
     * @return targetClazz对应的对象。任意参数为空都会返回null
     */
    public static <T> T beanCopy(Object source, Class<T> targetClazz) {
        if (source == null || targetClazz == null) {
            return null;
        }
        T target = instantiate(targetClazz);
        copyProperties(source, target);
        return target;
    }
}
