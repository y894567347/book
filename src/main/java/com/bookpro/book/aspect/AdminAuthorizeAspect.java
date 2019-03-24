package com.bookpro.book.aspect;

import com.bookpro.book.dataobject.User;
import com.bookpro.book.enums.ExceptionEnum;
import com.bookpro.book.enums.UserRoleEnum;
import com.bookpro.book.exception.UserAuthorException;
import com.bookpro.book.service.UserService;
import com.bookpro.book.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/23 10:45
 * @Description: 在访问管理员界面时要验证用户是否为管理员
 */
@Aspect
@Component
@Slf4j
public class AdminAuthorizeAspect {

    @Autowired
    private UserService userService;

    @Pointcut("execution(public * com.bookpro.book.controller.Admin*.*(..))")
    public void verify(){ }

    @Before("verify()")
    public void dovorify(){

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        Cookie cookie = CookieUtil.get(request,"username");
        if(cookie==null){

            log.error("【管理员验证】  没有登陆");
            throw new UserAuthorException(ExceptionEnum.LOGIN_ERROR);
        }

        User user = userService.findOne(cookie.getValue());
        if(user==null){
            log.error("【登陆校验】 数据库中没有该用户");
            throw new UserAuthorException(ExceptionEnum.LOGIN_ERROR);
        }

        if(!user.getUserRole().equals(UserRoleEnum.ROLE_ADMIN.getCode())){

            log.error("【登陆校验】 非管理员用户越权访问");
            throw new UserAuthorException(ExceptionEnum.GRANT_ERROR);
        }

    }
}
