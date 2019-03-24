package com.bookpro.book.exception;

import com.bookpro.book.enums.ExceptionEnum;
import lombok.Getter;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/20 20:04
 * @Description:
 */
@Getter
public class UserAuthorException extends RuntimeException {

    private Integer code;

    public UserAuthorException(ExceptionEnum e){
        super(e.getMsg());
        this.code = e.getCode();
    }


}
