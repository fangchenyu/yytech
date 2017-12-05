package com.yytech.entity;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * created by wangwang on 2017/11/29 0029
 */
public class Sqlcriteria {
    private Map<String, Object> criteria = new HashMap<String, Object>();


    public static Sqlcriteria create() {
        return new Sqlcriteria();
    }

    public Sqlcriteria add(String key, Object value) {
        if (StringUtils.isNotBlank(key) && value != null) {
            this.criteria.put(key, value);
        }
        return this;
    }

    public Map getCriteria() {
        return this.criteria;
    }

}
