package com.bookpro.book.service;

import com.bookpro.book.dataobject.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.PropertyPermission;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/11 15:57
 * @Description:
 */
public interface ProductCategoryService {

    ProductCategory findOne(Integer id);

    ProductCategory findByCategoryType(Integer categoryType);

    List<ProductCategory> findAll();

    List<ProductCategory> findAllByCategoryType(Integer categoryType);

    Page<ProductCategory> findAllPage(Pageable pageable);

    ProductCategory update(ProductCategory productCategory);

    ProductCategory add(ProductCategory productCategory);
}
