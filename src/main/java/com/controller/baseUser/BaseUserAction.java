package com.controller.baseUser;

import com.model.baseUser.BaseUserBean;
import com.service.baseuser.BaseUserService;
import com.untils.framework.LoggerInfo;
import com.untils.object.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *  基础用户控制类
 * Created by hefule on 2016/8/6 17:53.
 */
@RestController
@RequestMapping("/baseUser")
public class BaseUserAction extends LoggerInfo<BaseUserAction> {

    @Autowired
    private BaseUserService baseUserService;

    /**
     *  增加用户
     *  @author hefule
     *  @date 2016/8/6 18:03
     *
     */
    @RequestMapping("/addModeForOne")
    public String addModeForOne(){
        BaseUserBean baseUserBean = new BaseUserBean();
        try {
            baseUserService.addModeForOne(baseUserBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ObjectUtils.objToJson(baseUserBean);
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
            e.printStackTrace();
        }
        return ObjectUtils.objToJson(t);
    }
}
