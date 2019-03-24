package com.bookpro.book.dataobject;

import com.bookpro.book.enums.ProductStatusEnum;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/10 11:40
 * @Description: 书籍详细信息
 */
@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;

    /**书名.*/
    private String productName;

    /**书作者.*/

    private String bookAuthor;

    /**书单价.*/
    private BigDecimal productPrice;

    /**书库存.*/

    private Integer productStock;

    /**书状态.*/
    private Integer productStatus=0;

    /**书详情描述.*/
    private String productDescription="暂无描述";

    /**书的图片.*/
    private String productIcon;

    /**书的类型.*/
    private Integer categoryType;


    private Date createTime;


    private Date updateTime;

}
