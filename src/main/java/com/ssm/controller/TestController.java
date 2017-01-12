package com.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.ssm.service.interfaces.ITestService;
import com.ssm.util.CommonUtil;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/28 0028.
 * 测试用Controller
 */
@RestController // @RestController是@Controller和@ResponseBody的结合体，两个标注合并起来的作用
@RequestMapping("/test")
public class TestController {
    //日志类
    private static Logger logger = Logger.getLogger(TestController.class);
    @Resource
    ITestService testService;


    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public String test() {
        return "你好啊SSM框架";
    }


    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public Map<String, Object> test1() {
        logger.info("TestController=======================" + JSON.toJSONString(testService.getUserPaging()));
        return CommonUtil.resultJSON("200", "执行成功", testService.getUserPaging());
    }

/*    客户端流程：如果需要登录首先跳到oauth2服务端进行登录授权，
    成功后服务端返回auth code，然后客户端使用auth code去服务器端换取access token，
    最好根据access token获取用户信息进行客户端的登录绑定*/
}
