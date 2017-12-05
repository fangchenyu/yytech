package com.yytech.config;

import java.util.HashMap;

/**
 * created by wangwang on 2017/12/5 0005
 */
public class ThreadConfig {
    private static final ThreadLocal<ThreadConfig> ThreadConfig = new ThreadLocal<ThreadConfig>();
    private final HashMap<String, Object> values = new HashMap<String, Object>();

    public static ThreadConfig getContext() {
        ThreadConfig context = ThreadConfig.get();
        if (context == null) {
            context = new ThreadConfig();
            ThreadConfig.set(context);
        }
        return context;
    }

    public void clear() {
        ThreadConfig context = ThreadConfig.get();
        if (context != null) {
            context.values.clear();
        }
        context = null;
    }

    public void addObject(String key, Object value) {
        values.put(key, value);
    }

    public Object getObject(String key) {
        return values.get(key);
    }
}
