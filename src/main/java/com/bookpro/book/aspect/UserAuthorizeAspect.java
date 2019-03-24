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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/20 17:20
 * @Description:  AOP实现身份认证 组织用户跨域访问
 */
@Aspect
@Component
@Slf4j
public class UserAuthorizeAspect {

    @Autowired
    UserService userService;

   @Pointcut("execution(public * com.bookpro.book.controller.Buyer*.*(..))"+
   "|| execution(public * com.bookpro.book.controller.PageController.*(..))"+
   "&& ! execution(public * com.bookpro.book.controller.PageController.login(..))")
    public void verify(){}

    @Before("verify()")
public void doVerify(){

        ServletRequestAttributes attributes  = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request  = attributes.getRequest();

       Cookie cookie  = CookieUtil.get(request,"username");
       if(cookie == null){
           log.warn("【登陆校验】 cookie中没有username");
            throw new UserAuthorException(ExceptionEnum.LOGIN_ERROR);
       }

       User user = userService.findOne(cookie.getValue());
       if(user==null){
        log.warn("【登陆校验】 数据库中没有该用户");
        throw new UserAuthorException(ExceptionEnum.LOGIN_ERROR);
       }


    }
}
