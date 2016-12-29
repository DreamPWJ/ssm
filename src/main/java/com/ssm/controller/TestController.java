package com.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.ssm.model.User;
import com.ssm.service.interfaces.ITestService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/28 0028.
 * 测试用Controller
 */
@Controller
@RequestMapping("/test")
public class TestController {
    //日志类
    private static Logger logger = Logger.getLogger(TestController.class);
    @Resource
    ITestService testService;

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public String test() {
        return "你好啊SSM框架";
    }

    @ResponseBody
    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public Map<String,Object> test1() {
        logger.info("TestController=======================" + JSON.toJSONString(testService.getUserPaging()));
        return testService.getUserPaging();
    }
}
