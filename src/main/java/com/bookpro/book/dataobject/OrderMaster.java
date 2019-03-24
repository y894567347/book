package com.bookpro.book.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/10 14:46
 * @Description: 订单类
 */

@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    @Id
    private String orderId;

    /**买家名字.*/
    private String userId;

    /**买家名字.*/
    private String buyerName;

    /**买家电话.*/
    private String buyerPhone;

    /**买家地址.*/
    private String buyerAddress;

    /**订单总额.*/
    private BigDecimal orderAmount;

    /**订单状态.*/
    private Integer orderStatus;


    /**订单创建时间.*/
    private Date createTime;

    /**订单更新时间.*/
    private Date updateTime;

}
