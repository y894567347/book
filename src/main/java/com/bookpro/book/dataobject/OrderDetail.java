package com.bookpro.book.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/10 14:53
 * @Description: 订单详情类
 */
@Entity
@Data
public class OrderDetail {

    @Id
    private String detailId;

    private String orderId;

    /**书Id.*/
    private String productId;

    /**书名.*/
    private String productName;

    /**书单价.*/
    private BigDecimal productPrice;

    /**书数量.*/
    private Integer productQuantity;

}
