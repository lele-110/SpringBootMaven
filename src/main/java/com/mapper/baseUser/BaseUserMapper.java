package com.mapper.baseUser;

import com.mapper.BaseMapper;
import com.model.baseUser.BaseUserBean;
import org.springframework.stereotype.Repository;

/**
 * 基础用户类
 * Created by hefule on 2016/7/31.
 */
@Repository("baseUserMapper")
public interface BaseUserMapper extends BaseMapper<BaseUserBean> {}
