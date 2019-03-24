package com.bookpro.book.exception;

import com.bookpro.book.enums.ExceptionEnum;
import lombok.Getter;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/10 20:47
 * @Description:
 */
@Getter
public class BookException extends RuntimeException {

    private Integer code;

    public BookException(ExceptionEnum exceptionEnum){

        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }




}
