package com.service.baseuser;

import com.mapper.baseUser.BaseUserMapper;
import com.model.baseUser.BaseUserBean;
import com.untils.framework.LoggerInfo;
import com.untils.object.ResultMsBean;
import com.untils.object.TimeUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 基础用户server
 * Created by hefule on 2016/8/6 16:45.
 */
@Service("baseUserService")
public class BaseUserService extends LoggerInfo<BaseUserService> {

    @Resource(name = "baseUseMapper")
    private BaseUserMapper baseUserMapper;

    /**
     *  获取所有基础用户
     *  @author hefule
     *  @date 2016/8/6 17:44
     *  @param t 基础用户实体
     */
    public List<BaseUserBean> loadModeForAll(BaseUserBean t) throws Exception{
        return this.baseUserMapper.loadModeForAll();
    }
    
    /**
     *  新增基础用户
     *  @author hefule
     *  @date 2016/8/6 17:47
     *  @param t 基础用户实体
     */
    public ResultMsBean addModeForOne(BaseUserBean t) throws Exception{
        ResultMsBean resultMsBean = new ResultMsBean();
        try{
            t.setName("何富乐");
            t.setCode("admin");
            t.setPassword("123456");
            t.setCtime(TimeUtils.DateToString(new Date()));
            t.setIsok(0);
            //this.baseUserMapper.addModeForOne();
            if(t.getId()==null){
                resultMsBean.setSuccess(false);
                resultMsBean.setMessage("该账号已经存在");
            }
        }catch (Exception e){
            resultMsBean.setExMessage(e.getMessage());
        }
        return  resultMsBean;
    }
}
