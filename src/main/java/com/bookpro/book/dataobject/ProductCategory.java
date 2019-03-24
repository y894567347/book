package com.bookpro.book.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/10 14:44
 * @Description: 书籍类目表
 */
@Data
@Entity
@DynamicUpdate
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer categoryId;

    /**类目名称.*/
    private String categoryName;

    /**书类型.*/
    private Integer categoryType;



}
