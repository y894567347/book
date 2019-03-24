package com.bookpro.book.service.Impl;

import com.bookpro.book.dataobject.ProductCategory;
import com.bookpro.book.enums.ExceptionEnum;
import com.bookpro.book.exception.BookException;
import com.bookpro.book.service.ProductCategoryService;
import com.bookpro.book.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/11 15:59
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductCategoryServiceImplTest {

    @Autowired
    ProductCategoryService productCategoryService;

    @Test
    public void findAll() {

        PageRequest pageRequest = PageRequest.of(0,2);
        Page<ProductCategory> productCategories = productCategoryService.findAllPage(pageRequest);
        Assert.assertNotEquals(productCategories.getTotalElements(),0);
    }

    @Test
    public void save(){


            ProductCategory productCategory = new ProductCategory();
            productCategory.setCategoryId(4);
            productCategory.setCategoryName("教辅");
            productCategory.setCategoryType(5);

        try {
            ProductCategory result = productCategoryService.update(productCategory);
        } catch (BookException e) {
            e.printStackTrace();
        }


    }
}