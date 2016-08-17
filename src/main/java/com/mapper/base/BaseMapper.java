package com.mapper.base;

import com.untils.framework.LoggerInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 基础dao工具类实现类
 * Created by hefule on 2016/8/17 15:10.
 */
@Repository("baseMapper")
public class BaseMapper<T> extends LoggerInfo<BaseMapper> {

    @Resource(name = "sqlSessionFactoryBean")
    private SqlSessionFactory sqlSessionFactoryBean;
    private  SqlSession sqlSession(){
        return sqlSessionFactoryBean.openSession();
    }
    /**
     *  查询全部公用类
     *  @author hefule
     *  @date 2016/8/6 16:14
     *  @param t sql语句
     */
    public List<T> loadModeForAll(String t) throws Exception {
        return sqlSession().selectList(BaseMapper.class.getName()+".loadModeForAll", new HashMap<String,Object>(){{put("sql",t);}});
    }

    /**
     *  分页查询公用类
     *  @author hefule
     *  @date 2016/8/6 16:17
     *  @param t sql语句
     */
    public List<T> loadModeForList(String t) throws Exception {
        return sqlSession().selectList(BaseMapper.class.getName()+".loadModeForList", new HashMap<String,Object>(){{put("sql",t);}});
    }

    /**
     *  分页查询总数类
     *  @author hefule
     *  @date 2016/8/6 16:23
     *  @param t sql语句
     */
    public Long loadModeForCount(String t) throws Exception {
        return sqlSession().selectOne(BaseMapper.class.getName()+".loadModeForCount", new HashMap<String,Object>(){{put("sql",t);}});
    }

    /**
     *  查询单个类
     *  @author hefule
     *  @date 2016/8/6 16:15
     *  @param t sql语句
     */
    public T loadModeForOne(String t) throws Exception {
        return sqlSession().selectOne(BaseMapper.class.getName()+".loadModeForOne", new HashMap<String,Object>(){{put("sql",t);}});
    }

    /**
     *  增加单个类
     *  @author hefule
     *  @date 2016/8/6 16:16
     *  @param t sql语句
     */
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor = Exception.class)
    public Long addModeForOne(String t) throws Exception {
        return Long.valueOf(sqlSession().insert(BaseMapper.class.getName()+".addModeForOne", new HashMap<String,Object>(){{put("sql",t);}}));
    }

    /**
     *  增加批量类
     *  @author hefule
     *  @date 2016/8/6 16:16
     *  @param t sql语句
     */
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor = Exception.class)
    public Long addModeForBatch(List<String> t) throws Exception {
        return Long.valueOf(sqlSession().insert(BaseMapper.class.getName()+".addModeForBatch", t));
    }


    /**
     *  删除单个类
     *  @author hefule
     *  @date 2016/8/6 16:34
     *  @param t sql语句
     */
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor = Exception.class)
    public Long delModeForOne(String t) throws Exception {
        return Long.valueOf(sqlSession().delete(BaseMapper.class.getName()+".delModeForOne", new HashMap<String,Object>(){{put("sql",t);}}));
    }

    /**
     *  删除批量类
     *  @author hefule
     *  @date 2016/8/6 16:34
     *  @param t sql语句
     */
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor = Exception.class)
    public Long delModeForBatch(List<String> t) throws Exception {
        return Long.valueOf(sqlSession().delete(BaseMapper.class.getName()+".delModeForBatch",t));
    }

    /**
     *  修改单个类
     *  @author hefule
     *  @date 2016/8/6 16:38
     *  @param t sql语句
     */
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor = Exception.class)
    public Long updateModeForOne(String t) throws Exception {
        return Long.valueOf(sqlSession().update(BaseMapper.class.getName()+".updateModeForOne", new HashMap<String,Object>(){{put("sql",t);}}));
    }

    /**
     *  修改批量类
     *  @author hefule
     *  @date 2016/8/6 16:38
     *  @param t sql语句
     */
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor = Exception.class)
    public Long updateModeForBatch(List<String> t) throws Exception {
        return Long.valueOf(sqlSession().update(BaseMapper.class.getName()+".updateModeForBatch",t));
    }
}
