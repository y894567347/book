package com.bookpro.book.controller;

import com.bookpro.book.VO.LoginResult;
import com.bookpro.book.dataobject.User;
import com.bookpro.book.enums.UserRoleEnum;
import com.bookpro.book.form.UserForm;
import com.bookpro.book.service.UserService;
import com.bookpro.book.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.CollationKey;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/16 17:21
 * @Description:
 */
@RestController
public class UserController {

    @Autowired
    private  UserService userService;
    @PostMapping("/islogin")
    public LoginResult login(@Valid UserForm userForm,
                             HttpServletResponse response){

        User user = userService.findOne(userForm.getUsername());
        if(user == null){
            return new LoginResult(100,"用户不存在");
        }

        if(!userForm.getPassword().equals(user.getPassword())){
            return new LoginResult(110,"用户名或者密码不正确");
        }

         if(user.getUserRole() == UserRoleEnum.ROLE_USER.getCode()) {
             CookieUtil.set(response,"userid",user.getUserId(),7200);
             CookieUtil.set(response,"username",user.getUsername(),7200);
            return new LoginResult(200, "用户成功登陆");
        }
         else if(user.getUserRole() == UserRoleEnum.ROLE_ADMIN.getCode()){
             CookieUtil.set(response,"userid",user.getUserId(),7200);
             CookieUtil.set(response,"username",user.getUsername(),7200);
             return new LoginResult(300,"管理员成功登陆");
         }
         return null;
    }


    @GetMapping("/getuserid")
    public String getUserid(HttpServletRequest request,
                            HttpServletResponse response){

        String userid = CookieUtil.get(request,"userid").getValue();
        return userid;
    }

    @GetMapping("/getusername")
    public String getusername(HttpServletRequest request,
                              HttpServletResponse response){

        String username = CookieUtil.get(request,"username").getValue();
        return username;
    }
}
