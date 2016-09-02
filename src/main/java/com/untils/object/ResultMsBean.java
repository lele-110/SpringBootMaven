package com.untils.object;

import com.untils.framework.LoggerInfo;

import java.io.Serializable;

/**
 * 结果返回类
 * Created by hefule on 2016/8/7 15:41.
 */
public final class ResultMsBean<T> extends LoggerInfo<ResultMsBean,Serializable>{
    private Boolean success;
    private String message;
    private String exMessage;
    private T object;
    public ResultMsBean(){
        setSuccess(true);
        setMessage("操作成功！");
    }
    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getExMessage() {
        return exMessage;
    }

    public void setExMessage(String exMessage) {
        this.exMessage = exMessage;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
