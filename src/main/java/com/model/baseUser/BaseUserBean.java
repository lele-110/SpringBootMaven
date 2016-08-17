package com.model.baseUser;

import com.model.base.BaseBean;

/**
 * 基本用户类
 * Created by hefule on 2016/8/6 16:08.
 */
public class BaseUserBean extends BaseBean{

    /**
     *  账户名
     *  @author hefule
     *  @date 2016/8/6 16:10
     *
     */
    private String code;
    /**
     *  密码
     *  @author hefule
     *  @date 2016/8/6 16:10
     *
     */
    private String password;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
