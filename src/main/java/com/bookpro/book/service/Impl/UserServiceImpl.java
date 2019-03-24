package com.bookpro.book.service.Impl;

import com.bookpro.book.dataobject.User;
import com.bookpro.book.repository.UserRespository;
import com.bookpro.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/16 21:06
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRespository userRespository;

    @Override
    public User findOne(String username) {

        return userRespository.findByusername(username);
    }


}
