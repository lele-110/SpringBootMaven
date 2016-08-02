package com.untils.object;

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
}
