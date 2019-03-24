package com.bookpro.book.enums;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/16 14:36
 * @Description:
 */
@Getter
public enum OrderStatusEnum {

    NEW(0,"新订单"),
    FINISHED(1,"已完成"),
    CANCEL(2,"已取消");

    private Integer code;

    private String msg;

    OrderStatusEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
