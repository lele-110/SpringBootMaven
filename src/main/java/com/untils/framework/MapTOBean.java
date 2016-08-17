package com.untils.framework;


import com.untils.object.ObjectUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hefule on 2016/2/24.
 */
public final class MapTOBean<T> {

    private T t;
    private Map<String,Object> result;

    public MapTOBean(){}

    /**
     * map转bean
     * @param para
     * @param t
     * @return
     * @throws Exception
     */
    public MapTOBean(Map<String,Object> para,T t){
        super();
        this.t = mapToBean(para,t);
    }
    /**
     * bean转map
     * @param
     * @param t
     * @return
     * @throws Exception
     */
    public MapTOBean(T t){
        super();
        this.result = beanToMap(t);
    }

    private T mapToBean(Map<String,Object> para,T t) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(t.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                if (para.containsKey(key)||para.containsKey(key.toLowerCase())||para.containsKey(key.toUpperCase())) {
                    Object value = para.get(key);
                    if(value==null) value = para.get(key.toLowerCase());
                    if(value==null) value = para.get(key.toUpperCase());
                    Method getter = property.getReadMethod();
                    // 得到property对应的setter方法
                    Method setter = property.getWriteMethod();
                    setter.invoke(t, resultChangeType(getter.getReturnType(),value));
                }

            }
        } catch (Exception e) {
            e.getMessage();
        }
        return t;
    }


    private Map<String,Object> beanToMap(T t) {
        if(t == null){
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(t.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                // 过滤class属性
                if (!key.equals("class") && !key.equals("serialVersionUID")) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(t);
                    map.put(key, value);
                }
            }
        }catch (Exception e){
            e.getMessage();
        }
        return map;
    }

    private Object resultChangeType(Class<?> c,Object o){
        if(ObjectUtils.isNotEmpty(o)){
            if(c == Integer.class){
                o = Integer.valueOf(o.toString());
            }else if(c == String.class ){
                o = o.toString();
            }else if(c == Short.class){
                o = Short.valueOf(o.toString());
            }else if(o == Long.class){
                o = Long.valueOf(o.toString());
            }
            return  o;
        }else{
            return null;
        }
    }

    public List<T> mapToT(List<Map<String,Object>> _list, T t) throws IllegalAccessException, InstantiationException {
        List<T> list = new ArrayList<T>(_list.size());
        for(Map<String,Object> para : _list) {
            T _t = (T) t.getClass().newInstance();
            list.add(mapToBean(para,_t));
        }
        return list;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public Map<String, Object> getResult() {
        return result;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }
}
