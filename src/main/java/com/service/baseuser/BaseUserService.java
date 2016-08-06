package com.service.baseuser;

import com.mapper.baseUser.BaseUserMapper;
import com.model.baseUser.BaseUserBean;
import com.untils.framework.LoggerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 基础用户server
 * Created by hefule on 2016/8/6 16:45.
 */
@Service("baseUserService")
public class BaseUserService extends LoggerInfo<BaseUserService> {

    @Autowired
    private BaseUserMapper baseUserMapper;

    /**
     *  获取所有基础用户
     *  @author hefule
     *  @date 2016/8/6 17:44
     *  @param t 基础用户实体
     */
    public List<BaseUserBean> loadModeForAll(BaseUserBean t) throws Exception{
        return this.baseUserMapper.loadModeForAll(t);
    }
    
    /**
     *  新增基础用户
     *  @author hefule
     *  @date 2016/8/6 17:47
     *  @param t 基础用户实体
     */
    public void  addModeForOne(BaseUserBean t) throws Exception{
         this.baseUserMapper.addModeForOne(t);
    }
}
