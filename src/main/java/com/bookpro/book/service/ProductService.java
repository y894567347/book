package com.bookpro.book.service;

import com.bookpro.book.VO.ProductVO;
import com.bookpro.book.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/10 19:47
 * @Description:
 */
public interface ProductService {

    //添加一本书

    ProductInfo addOne(ProductInfo productInfo);

    Page<ProductInfo> findAll(Pageable pageable);


    Page<ProductInfo> findOnSale(Pageable pageable);

    ProductInfo findOneById(String id);

    Page<ProductInfo> findByCategoryType(Pageable pageable,Integer categoryType,Integer productStatus);

    //生成订单后减少库存
    ProductInfo decreaseStock(String productId,Integer productQuantity);

    ProductInfo increaseStock(String productId,Integer productQuantity);

    ProductInfo onSale(String id);

    ProductInfo offSale(String id);

    ProductInfo update(ProductInfo productInfo);


}
