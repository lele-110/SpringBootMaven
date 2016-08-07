package com.mapper;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hefule on 2016/8/6 16:13.
 */
@Repository
public interface BaseMapper<T> {

    /**
     *  查询全部公用接口类
     *  @author hefule
     *  @date 2016/8/6 16:14
     *  @param t 实体类
     */
    List<T> loadModeForAll(T t) throws Exception;
    
    /**
     *  分页查询公用接口类
     *  @author hefule
     *  @date 2016/8/6 16:17
     *  @param t 实体类
     */
     List<T> loadModeForList(T t) throws Exception;

     /**
      *  分页查询总数接口类
      *  @author hefule
      *  @date 2016/8/6 16:23
      *
      */
     Long loadModeForCount(T t) throws Exception;

     /**
      *  查询单个接口类
      *  @author hefule
      *  @date 2016/8/6 16:15
      *  @param t 实体类
      */
     T loadModeForOne(T t) throws Exception;

    /**
     *  增加单个接口类
     *  @author hefule
     *  @date 2016/8/6 16:16
     *  @param t 实体类
     */
     void addModeForOne(T t) throws Exception;

     /**
      *  批量增加接口类
      *  @author hefule
      *  @date 2016/8/6 16:27
      *  @param t 列表实体类
      */
     @Transactional(propagation= Propagation.REQUIRED,rollbackFor=Exception.class)
     void addModeForBatch(List<T> t) throws Exception;
    
     /**
      *  删除单个接口类
      *  @author hefule
      *  @date 2016/8/6 16:34
      *  @param t 实体类
      */
      void delModeForOne(T t) throws Exception;

    /**
     *  批量删除接口类
     *  @author hefule
     *  @date 2016/8/6 16:27
     *  @param t 列表实体类
     */
     @Transactional(propagation= Propagation.REQUIRED,rollbackFor=Exception.class)
     void delModeForBatch(List<T> t) throws Exception;
     
     /**
      *  修改单个接口类
      *  @author hefule
      *  @date 2016/8/6 16:38
      *  @param t 实体类
      */
      void updateModeForOne(T t) throws Exception;

      /**
        *  批量更新接口类
        *  @author hefule
        *  @date 2016/8/6 16:27
        *  @param t 列表实体类
        */
       @Transactional(propagation= Propagation.REQUIRED,rollbackFor=Exception.class)
       void updateModeForBatch(List<T> t) throws Exception;
}
