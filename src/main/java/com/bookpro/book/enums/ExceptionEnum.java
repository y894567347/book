package com.bookpro.book.enums;

import lombok.Getter;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/10 20:49
 * @Description:
 */
@Getter
public enum ExceptionEnum {

    PARAM_ERROR(1,"参数格式不正确"),
    PRODUCT_EXIST_ERROR(2,"该书不存在"),
    ON_OFF_ERROR(3,"上下架状态错误"),
    CATEGORY_EXIST_ERROR(4,"类目已存在"),
    LOGIN_ERROR(5,"请先登录"),
    GRANT_ERROR(6,"没有权限");



    private Integer code;
    private String msg;

    ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
