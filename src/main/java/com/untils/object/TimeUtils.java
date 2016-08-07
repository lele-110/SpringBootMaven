package com.untils.object;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 * Created by hefule on 2016/8/7 9:42.
 */
public final class TimeUtils {

    /**
     *  格式化时间
     *  @author hefule
     *  @date 2016/8/7 9:43
     *  @param date 时间
     */
    public static Date DateToString(Date date) throws Exception{
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time =  sim.format(date);
        return sim.parse(time);
    }
}
