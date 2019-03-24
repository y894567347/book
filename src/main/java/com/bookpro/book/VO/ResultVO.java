package com.bookpro.book.VO;

import lombok.Data;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/10 20:44
 * @Description:
 */

@Data
public class ResultVO<T>{

    private Integer code;

    private String msg;

    private long count;

    private T data;
}
