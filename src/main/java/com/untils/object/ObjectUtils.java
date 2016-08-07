package com.untils.object;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;

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

    /**
     *  获取项目路径(包含端口)
     *  @author hefule
     *  @date 2016/8/7 20:47
     *  @param request
     *  @param isPort 是否包含項目之前的路徑
     */
    public static String basePath(HttpServletRequest request,boolean isPort) throws Exception{
        StringBuffer basePath = new StringBuffer();
        if(isPort){
            basePath.append(request.getScheme());
            basePath.append("://");
            basePath.append(request.getServerName());
            basePath.append(":");
            basePath.append(request.getServerPort());
        }
        basePath.append(request.getContextPath());
        basePath.append("/");
        return basePath.toString();
    }


}
