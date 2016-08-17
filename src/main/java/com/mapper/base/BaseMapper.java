package com.mapper.base;

import com.untils.framework.LoggerInfo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 基础dao工具类实现类
 * Created by hefule on 2016/8/17 15:10.
 */
@Repository("baseMapper")
public class BaseMapper<T> extends LoggerInfo<BaseMapper> {

    @Resource(name = "SqlSessionBean")
    private SqlSession sqlSession;

    /**
     *  查询全部公用接口类
     *  @author hefule
     *  @date 2016/8/6 16:14
     *  @param t sql语句
     */
    public List<T> loadModeForAll(String t) throws Exception {
        return sqlSession.selectList(t);
    }

    /**
     *  分页查询公用接口类
     *  @author hefule
     *  @date 2016/8/6 16:17
     *  @param t sql语句
     */
    public List<T> loadModeForList(String t) throws Exception {
        return sqlSession.selectList(t);
    }

    /**
     *  分页查询总数接口类
     *  @author hefule
     *  @date 2016/8/6 16:23
     *  @param t sql语句
     */
    public Long loadModeForCount(String t) throws Exception {
        return sqlSession.selectOne(t);
    }

    /**
     *  查询单个接口类
     *  @author hefule
     *  @date 2016/8/6 16:15
     *  @param t sql语句
     */
    public T loadModeForOne(String t) throws Exception {
        return sqlSession.selectOne(t);
    }

    /**
     *  增加单个接口类
     *  @author hefule
     *  @date 2016/8/6 16:16
     *  @param t sql语句
     */
    public Long addModeForOne(String t) throws Exception {
        return Long.valueOf(sqlSession.insert(t));
    }


    /**
     *  删除单个接口类
     *  @author hefule
     *  @date 2016/8/6 16:34
     *  @param t sql语句
     */
    public Long delModeForOne(String t) throws Exception {
        return Long.valueOf(sqlSession.delete(t));
    }

    /**
     *  修改单个接口类
     *  @author hefule
     *  @date 2016/8/6 16:38
     *  @param t sql语句
     */
    public Long updateModeForOne(String t) throws Exception {
        return Long.valueOf(sqlSession.update(t));
    }


}
