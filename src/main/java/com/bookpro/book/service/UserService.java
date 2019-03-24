package com.bookpro.book.service;

import com.bookpro.book.dataobject.User;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/16 21:04
 * @Description:
 */
public interface UserService {

    User findOne(String username);

}
