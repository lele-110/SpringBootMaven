package com.service.user;

import com.mapper.user.UserMapper;
import com.model.user.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hefule on 2016/7/31.
 */
@Service("userService")
public class UserService {

    private Logger logger = LogManager.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    public User findUserInfo() throws Exception {
        return userMapper.findUserInfo();
    }
}
