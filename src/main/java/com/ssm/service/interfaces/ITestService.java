package com.ssm.service.interfaces;



import com.ssm.model.User;

import java.util.Map;

/**
 * Created by pwj  on 2016/12/15 0015.
 * 测试用的service接口
 */
public interface ITestService {
    Map<String, Object> getUserPaging();

   User getUser(int id);

}
