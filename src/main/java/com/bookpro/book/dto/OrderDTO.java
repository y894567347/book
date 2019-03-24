package com.bookpro.book.dto;

import com.bookpro.book.dataobject.OrderDetail;
import com.bookpro.book.utils.Date2LongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/15 21:44
 * @Description:
 */
@Data
public class OrderDTO {

    private  String orderId;

    private String buyerName;

    private String userId;

    private String buyerPhone;

    private String buyerAddress;

    private BigDecimal orderAmount;

    private Integer orderStatus;

    private List<OrderDetail> orderDetailList;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

}
