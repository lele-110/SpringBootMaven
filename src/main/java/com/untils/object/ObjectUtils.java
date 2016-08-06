package com.untils.object;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by hefule on 2016/8/2.
 */
public final class ObjectUtils {

    /**
     *  判断Object是否为空
     *  @author hefule
     *  @date 2016/8/2 16:08
     *
     */
    public static boolean isNotEmpty(Object object){
          if(object==null)
              return false;
          else return !(object instanceof String && object.toString().length() == 0);
    }

    /**
     *  object转json
     *  @author hefule
     *  @date 2016/8/6 17:59
     *
     */
    public static String objToJson(Object o){
         if(o==null || o.equals(""))
             return "对象为空";
         return JSONObject.toJSONString(o);
    }
}
