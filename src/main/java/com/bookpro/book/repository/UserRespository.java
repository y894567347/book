package com.bookpro.book.repository;

import com.bookpro.book.dataobject.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/16 21:02
 * @Description:
 */
public interface UserRespository extends JpaRepository<User,String > {

    User findByusername(String username);
}
