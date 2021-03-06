package com.model.base;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础类bean
 * Created by hefule on 2016/8/6 15:55.
 */
public class BaseBean implements Serializable {
    private final static long serialVersionUID = 1L;

    /**
     *  公用id
     *  @author hefule
     *  @date 2016/8/6 16:03
     *
     */
    protected Long id;
    /**
     * 公用名称name
     *  @author hefule
     *  @date 2016/8/6 16:03
     *
     */
    protected String name;
    /**
     *  公用时间参数time
     *  @author hefule
     *  @date 2016/8/6 16:04
     *
     */
    protected Date ctime;
    /**
     * 公用是否起禁用参数isok(0启用1禁用)
     *  @author hefule
     *  @date 2016/8/6 16:04
     *
     */
    protected Integer isok;
    /**
     * 公用参数cuser 创建用户id
     *  @author hefule
     *  @date 2016/8/6 16:05
     *
     */
    protected Long cuser;
    /**
     *  公用参数cusername 创建用户名称
     *  @author hefule
     *  @date 2016/8/6 16:06
     *
     */
    protected String cusername;
    /**
     *  开始行数
     *  @author hefule
     *  @date 2016/8/6 16:53
     *
     */
    protected Long start;
    /**
     *  结束行数
     *  @author hefule
     *  @date 2016/8/6 16:54
     *
     */
     protected Long num;

    /**
     *  公用分页sql
     *  @author hefule
     *  @date 2016/8/17 15:56
     *
     */
     protected StringBuilder stringBuilder = new StringBuilder();

    /**
     * 公用sql参数,即最终执行的参数
     *  @author hefule
     *  @date 2016/8/18 0:02
     *
     */
     protected String sql;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Integer getIsok() {
        return isok;
    }

    public void setIsok(Integer isok) {
        this.isok = isok;
    }

    public Long getCuser() {
        return cuser;
    }

    public void setCuser(Long cuser) {
        this.cuser = cuser;
    }

    public String getCusername() {
        return cusername;
    }

    public void setCusername(String cusername) {
        this.cusername = cusername;
    }

    public Long getStart() {
        return start;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
    /**
     *  根据分页数和总数设置开始行数和结束行数
     *  @author hefule
     *  @date 2016/8/6 16:57
     *  @param pageNum 分页数默认为 1
     *  @param num 每页条数默认为 10
     */
    public void setStart(Long pageNum,Long num)  {
        if(pageNum==null || pageNum<=1)
            pageNum=1L;
        if(num==null || num<=0)
            num=10L;
        this.start = (pageNum-1)*num;
        this.num = num;
    }

    /**
     *  分页字符串
     *  @author hefule
     *  @date 2016/8/18 0:15
     *  @param isPage
     *
     */
    public StringBuilder getStringBuilder(Boolean isPage) {
        if(isPage) this.stringBuilder.append("select * from ( ");
        return stringBuilder;
    }

    /**
     *  分页字符串
     *  @author hefule
     *  @date 2016/8/18 0:15
     *  @param isPage
     *
     */
    public void setStringBuilder(StringBuilder stringBuilder,Boolean isPage) {
        if(isPage)
            this.stringBuilder =  getStringBuilder(isPage).append(stringBuilder).append(" )lele limit ").append(getStart()).append(",").append(getNum());
        else
            this.stringBuilder = stringBuilder;
    }

    private int nowPosition = 0;
    /**
     *  增加属性即为使用带有?的sql语句添加值
     *  @author hefule
     *  @date 2016/8/18 2:06
     *  @param obj 数值
     */
    public void addParam(Object... obj){
        for(Object o : obj){
            String _lin = o.toString();
            for(int i=nowPosition;i<getSql().length();i++){
                char c = getSql().charAt(i);
                if(c=='?'){
                    setSql(getSql().replaceFirst("\\?","'"+_lin+"'"));
                    nowPosition = i+_lin.length()+1;
                    break;
                }
            }
        }
    }
}
