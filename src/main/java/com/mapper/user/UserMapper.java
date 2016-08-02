package com.mapper.user;

import com.model.user.User;

/**
 * Created by hefule on 2016/7/31.
 */
public interface UserMapper {
    User findUserInfo() throws Exception;
}
