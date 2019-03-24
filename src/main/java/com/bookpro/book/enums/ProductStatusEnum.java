package com.bookpro.book.enums;

import lombok.Getter;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/12 14:10
 * @Description:
 */
@Getter
public enum ProductStatusEnum {

    ON_SALE(0,"在售"),
    OFF_SALE(1,"下架");

    private Integer code;
    private String msg;

    ProductStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
