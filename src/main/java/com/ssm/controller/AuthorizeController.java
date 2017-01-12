package com.ssm.controller;

import com.sun.org.apache.xml.internal.utils.Constants;
import org.apache.oltu.oauth2.as.request.OAuthAuthzRequest;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.error.OAuthError;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by panweiji on 2017/1/12 0012.
 * OAuth2授权控制权AuthorizeController
 */
@Controller
public class AuthorizeController {
    /**
     * 请求授权方法
     *
     * @param request
     * @return 授权auth code
     */
    @RequestMapping("/authorize")
    @ResponseBody
    public Object authorize(HttpServletRequest request) throws OAuthProblemException, OAuthSystemException {
        System.out.printf("===========");
        //构建OAuth授权请求
        OAuthAuthzRequest oAuthRequest=new OAuthAuthzRequest(request);
        //检查传入的客户端id是否正确
        if(true){

            OAuthResponse response = OAuthASResponse
                    .errorResponse(HttpServletResponse.SC_BAD_REQUEST)
                    .setError(OAuthError.TokenResponse.INVALID_CLIENT)
                    .buildJSONMessage();
            return response.getBody();

        }
      return  "授权成功";
    }
}
