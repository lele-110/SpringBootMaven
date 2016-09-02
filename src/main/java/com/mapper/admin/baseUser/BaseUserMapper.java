package com.mapper.admin.baseUser;

import com.mapper.base.BaseMapper;
import com.model.admin.baseUser.BaseUserBean;
import com.untils.framework.LoggerInfo;
import com.untils.object.TimeUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 基础用户类
 * Created by hefule on 2016/7/31.
 */
@Repository("baseUseMapper")
public class BaseUserMapper extends LoggerInfo<BaseUserMapper,Serializable> {

    @Resource(name = "baseMapper")
    private BaseMapper<BaseUserBean> baseMapper;
    /**
     *  获取用户所有参数
     *  @author hefule
     *  @date 2016/8/17 16:16
     *
     */
    public List<BaseUserBean> loadModeForAll(BaseUserBean baseUserBean) throws Exception {
          baseUserBean.setSql("select * from base_user");
          return baseMapper.loadModeForAll(baseUserBean);
    }

    public Long addModeForOne(BaseUserBean baseUserBean) throws Exception {
          baseUserBean.setSql("insert into base_user(name,code,password,ctime,isok)(select ?,?,?,?,? from dual where not exists (select 1 from base_user where code=?));");
          baseUserBean.addParam("何富乐");
          baseUserBean.addParam("admin","123456",TimeUtils.DateToString(new Date()),0,"admin");
          return baseMapper.addModeForOne(baseUserBean);
    }

    public Long deleteForOne(BaseUserBean baseUserBean) throws Exception {
         baseUserBean.setSql("delete from base_user where id=?");
         baseUserBean.addParam(baseUserBean.getId());
         return baseMapper.delModeForOne(baseUserBean);
    }
}
