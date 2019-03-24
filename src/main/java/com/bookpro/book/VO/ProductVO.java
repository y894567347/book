package com.bookpro.book.VO;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/10 20:22
 * @Description:
 */
@Data
public class ProductVO {
    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;
}
