package com.controller.admin.baseUser;

import com.model.admin.baseUser.BaseUserBean;
import com.service.admin.baseUser.BaseUserService;
import com.untils.framework.LoggerInfo;
import com.untils.object.ObjectUtils;
import com.untils.object.ResultMsBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 *  基础用户控制类
 * Created by hefule on 2016/8/6 17:53.
 */
@RestController
@RequestMapping("/admin/baseUser")
public class BaseUserAction extends LoggerInfo<BaseUserAction,Serializable> {

    @Resource(name="baseUserService")
    private BaseUserService baseUserService;

    /**
     *  增加用户
     *  @author hefule
     *  @date 2016/8/6 18:03
     *
     */
    @RequestMapping("/addModeForOne")
    public String addModeForOne(){
        ResultMsBean resultMsBean =null;
        try {
             resultMsBean = baseUserService.addModeForOne(new BaseUserBean());
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return ObjectUtils.objToJson(resultMsBean);
    }

    /**
     *  查询用户
     *  @author hefule
     *  @date 2016/8/6 18:03
     *
     */
    @RequestMapping("loadModeForAll")
    public String loadModeForAll(){
        List<BaseUserBean> t =null;
        try {
            t= baseUserService.loadModeForAll(new BaseUserBean());
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return ObjectUtils.objToJson(t);
    }
}
