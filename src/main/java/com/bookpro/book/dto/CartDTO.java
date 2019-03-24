package com.bookpro.book.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/13 20:29
 * @Description: 购物车类
 */
@Data
public class CartDTO {
    /**商品ID.*/
    private String productId;

    /**书名.*/
    private String productName;

    /**商品数量.*/
    private Double productPrice;

    /**商品数量.*/
    private Integer productQuantity;

    public CartDTO(String productId, String productName,Double productPrice,Integer productQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }
}
