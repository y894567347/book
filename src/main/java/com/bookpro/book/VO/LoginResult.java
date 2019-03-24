package com.bookpro.book.VO;

import lombok.Getter;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/16 20:56
 * @Description:
 */

@Getter
public class LoginResult {

    private Integer code;

    private String msg;

   public  LoginResult(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

}
