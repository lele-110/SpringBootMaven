package com.mapper.baseUser;

import com.mapper.base.BaseMapper;
import com.untils.framework.LoggerInfo;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 基础用户类
 * Created by hefule on 2016/7/31.
 */
@Repository("baseUseMapper")
public class BaseUserMapper extends LoggerInfo<BaseUserMapper> {

    @Resource(name = "baseMapper")
    private BaseMapper<BaseUserMapper> baseMapper;
    /**
     *  获取用户所有参数
     *  @author hefule
     *  @date 2016/8/17 16:16
     *
     */
    public List loadModeForAll() throws Exception {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("select * from base_user");
          return baseMapper.loadModeForAll(stringBuilder.toString());
    }
}
