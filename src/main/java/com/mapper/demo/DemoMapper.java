package com.mapper.demo;

import com.mapper.BaseMapper;
import com.model.demo.Demo;
import org.springframework.stereotype.Repository;

/**
 * 示例接口
 * Created by hefule on 2016/7/31.
 */
@Repository("demoMapper")
public interface DemoMapper extends BaseMapper<Demo>{

}
