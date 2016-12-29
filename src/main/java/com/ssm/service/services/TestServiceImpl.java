package com.ssm.service.services;


import com.ssm.dao.BaseMapper;
import com.ssm.dao.UserMapper;
import com.ssm.model.User;
import com.ssm.service.interfaces.ITestService;
import com.ssm.util.CommonUtil;
import com.ssm.util.SysConstants;
import com.ssm.util.datasource.DataSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * created by pwj  on 2016/12/15 0015.
 * 测试用service
 */
@Service
//@Transactional事务处理  propagation事务传播机制  REQUIRED是保证在事务中的代码只有在当前事务中运行，防止创建多个事务
/*@Transactional(propagation = Propagation.REQUIRED)*/
//注解式数据源，用来进行数据源切换
/*@DataSource(name = DataSource.DEFAULT_DATASOURCE)*/
public class TestServiceImpl implements ITestService {
    @Resource
    BaseMapper baseMapper;
    @Resource
    UserMapper userMapper;

    @Override
    public Map<String, Object> getUserPaging() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("tableName", " user ");
        paramMap.put("fields", " * ");
        paramMap.put("pageNow", SysConstants.PAGENOW);
        paramMap.put("pageSize", SysConstants.PAGESIZE);
/*      paramMap.put("wherecase",null);
        paramMap.put("orderField", null);*/
        paramMap.put("orderFlag", 1);
        this.baseMapper.getPaging(paramMap);
        paramMap.put("pagingList", this.baseMapper.getPaging(paramMap));
        return CommonUtil.removePaingMap(paramMap);
    }

    @Override
    public User getUser(int id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }


}
