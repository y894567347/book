package com.bookpro.book.enums;

import lombok.Getter;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/16 17:01
 * @Description:
 */
@Getter
public enum UserRoleEnum {

    ROLE_ADMIN(1,"管理员"),
    ROLE_USER(0,"普通用户");

    private  Integer code;

    private String msg;
    UserRoleEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
