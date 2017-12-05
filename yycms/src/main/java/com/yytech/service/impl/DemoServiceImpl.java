package com.yytech.service.impl;

import com.yytech.config.ThreadConfig;
import com.yytech.service.IDemoService;
import org.springframework.stereotype.Service;

/**
 * Created by Wangwang on 2017/7/30.
 */
@Service
public class DemoServiceImpl implements IDemoService {
    @Override
    public void test() {
        Object test = ThreadConfig.getContext().getObject("test");
        System.out.println(String.valueOf(test));
    }
}
