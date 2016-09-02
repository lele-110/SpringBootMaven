package com.mapper.base;

import com.untils.framework.LoggerInfo;
import com.untils.framework.MapTOBean;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 基础dao工具类实现类
 * Created by hefule on 2016/8/17 15:10.
 */
@Repository("baseMapper")
public class BaseMapper<T> extends LoggerInfo<BaseMapper,Serializable> {

    @Resource(name = "sqlSessionFactoryBean")
    private SqlSessionFactory sqlSessionFactoryBean;
    private  SqlSession sqlSession(){
        return sqlSessionFactoryBean.openSession();
    }

    /**
     *  查询全部公用类
     *  @author hefule
     *  @date 2016/8/6 16:14
     *  @param t 实体类
     */
    public List<T> loadModeForAll(T t) throws Exception {
        List<Map<String,Object>> _list = sqlSession().selectList(BaseMapper.class.getName()+".loadModeForAll",t);
        return new MapTOBean<T>().mapToT(_list,t);
    }

    /**
     *  查询全部公用类
     *  @author hefule
     *  @date 2016/8/6 16:14
     *  @param t 实体类
     */
    public List<Map<String,Object>> loadModeForAllMap(T t) throws Exception {
        return sqlSession().selectList(BaseMapper.class.getName()+".loadModeForAll",t);
    }

    /**
     *  分页查询公用类
     *  @author hefule
     *  @date 2016/8/6 16:17
     *  @param t 实体类
     */
    public List<T> loadModeForList(T t) throws Exception {
        List<Map<String,Object>> _list = sqlSession().selectList(BaseMapper.class.getName()+".loadModeForList",t);
        return new MapTOBean<T>().mapToT(_list,t);
    }

    /**
     *  分页查询公用类
     *  @author hefule
     *  @date 2016/8/6 16:17
     *  @param t 实体类
     */
    public List<Map<String,Object>> loadModeForListMap(T t) throws Exception {
       return sqlSession().selectList(BaseMapper.class.getName()+".loadModeForList",t);
    }

    /**
     *  分页查询总数类
     *  @author hefule
     *  @date 2016/8/6 16:23
     *  @param t 实体类
     */
    public Long loadModeForCount(T t) throws Exception {
        return sqlSession().selectOne(BaseMapper.class.getName()+".loadModeForCount",t);
    }

    /**
     *  查询单个类
     *  @author hefule
     *  @date 2016/8/6 16:15
     *  @param t 实体类
     */
    public T loadModeForOne(T t) throws Exception {
        Map<String,Object> _para  = sqlSession().selectOne(BaseMapper.class.getName()+".loadModeForOne", t);
        return new MapTOBean<T>(_para,t).getT();
    }

    /**
     *  查询单个类
     *  @author hefule
     *  @date 2016/8/6 16:15
     *  @param t 实体类
     */
    public Map<String,Object> loadModeForOneMap(T t) throws Exception {
       return sqlSession().selectOne(BaseMapper.class.getName()+".loadModeForOne", t);
    }

    /**
     *  增加单个类
     *  @author hefule
     *  @date 2016/8/6 16:16
     *  @param t 实体类
     */
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor = Exception.class)
    public Long addModeForOne(T t) throws Exception {
        return Long.valueOf(sqlSession().insert(BaseMapper.class.getName()+".addModeForOne",t));
    }

    /**
     *  增加批量类
     *  @author hefule
     *  @date 2016/8/6 16:16
     *  @param t 实体类
     */
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor = Exception.class)
    public Long addModeForBatch(T t) throws Exception {
        return Long.valueOf(sqlSession().insert(BaseMapper.class.getName()+".addModeForBatch", t));
    }


    /**
     *  删除单个类
     *  @author hefule
     *  @date 2016/8/6 16:34
     *  @param t 实体类
     */
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor = Exception.class)
    public Long delModeForOne(T t) throws Exception {
        return Long.valueOf(sqlSession().delete(BaseMapper.class.getName()+".delModeForOne",t));
    }

    /**
     *  删除批量类
     *  @author hefule
     *  @date 2016/8/6 16:34
     *  @param t 实体类
     */
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor = Exception.class)
    public Long delModeForBatch(T t) throws Exception {
        return Long.valueOf(sqlSession().delete(BaseMapper.class.getName()+".delModeForBatch",t));
    }

    /**
     *  修改单个类
     *  @author hefule
     *  @date 2016/8/6 16:38
     *  @param t 实体类
     */
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor = Exception.class)
    public Long updateModeForOne(T t) throws Exception {
        return Long.valueOf(sqlSession().update(BaseMapper.class.getName()+".updateModeForOne", t));
    }

    /**
     *  修改批量类
     *  @author hefule
     *  @date 2016/8/6 16:38
     *  @param t 实体类
     */
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor = Exception.class)
    public Long updateModeForBatch(T t) throws Exception {
        return Long.valueOf(sqlSession().update(BaseMapper.class.getName()+".updateModeForBatch",t));
    }
}
