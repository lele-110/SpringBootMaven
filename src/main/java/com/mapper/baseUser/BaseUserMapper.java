package com.mapper.baseUser;

import com.mapper.base.BaseMapper;
import com.model.baseUser.BaseUserBean;
import com.untils.framework.LoggerInfo;
import com.untils.object.TimeUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 基础用户类
 * Created by hefule on 2016/7/31.
 */
@Repository("baseUseMapper")
public class BaseUserMapper extends LoggerInfo<BaseUserMapper> {

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
          StringBuilder builder = baseUserBean.getStringBuilder(false);
          builder.append("insert into base_user(name,code,password,ctime,isok)");
          builder.append("select '何富乐',");
          builder.append("'admin',");
          builder.append("'123456',");
          builder.append("'"+TimeUtils.DateToString(new Date())+"',");
          builder.append("'0' from dual where not exists (select 1 from base_user where code='admin')");
         /* List<String> list = new ArrayList<String>();
          list.add(builder.toString());
          list.add(builder.toString());*/
          baseUserBean.setSql(builder.toString());
          return baseMapper.addModeForOne(baseUserBean);
    }

    public Long deleteForOne(BaseUserBean baseUserBean) throws Exception {
         baseUserBean.setSql("delete from base_user where id="+baseUserBean.getId());
         return baseMapper.delModeForOne(baseUserBean);
    }
}
