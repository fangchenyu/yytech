package com.yytech.controller;

import com.yytech.config.ThreadConfig;
import com.yytech.service.IDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/ctrl")
public class DemoController extends BaseController {
    @Autowired
    IDemoService demoService;

    @RequestMapping("/test")
    @ResponseBody
    public String testConfig() {
        ThreadConfig.getContext().addObject("test", "test-value");
        demoService.test();
        return "ok";
    }
}
