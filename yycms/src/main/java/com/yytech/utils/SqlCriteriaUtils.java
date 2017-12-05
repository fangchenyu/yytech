package com.yytech.utils;

import com.yytech.entity.Sqlcriteria;

import java.lang.reflect.Field;

/**
 * created by wangwang on 2017/11/29 0029
 */
public class SqlCriteriaUtils {

    public static <T extends Object> Sqlcriteria objToCriteria(T t) throws IllegalAccessException {
        Sqlcriteria sqlcriteria = Sqlcriteria.create();
        if (t != null) {
            Class clazz = t.getClass();
            Field[] fields = clazz.getDeclaredFields();
            if (fields != null && fields.length > 0) {
                for (Field field : fields) {
                    String key = field.getName();
                    field.setAccessible(true);
                    Object value = field.get(t);
                    sqlcriteria.add(key, value);
                }
            }
        }
        return sqlcriteria;
    }
}
