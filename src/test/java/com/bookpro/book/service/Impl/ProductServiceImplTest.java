package com.bookpro.book.service.Impl;

import com.bookpro.book.VO.ProductVO;
import com.bookpro.book.dataobject.ProductInfo;
import com.bookpro.book.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/12 19:06
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @Test
    public void findOnSale() {

        Pageable pageable = PageRequest.of(1,3);
        Page<ProductInfo> productInfoList = productService.findOnSale(pageable);
        Assert.assertNotNull(productInfoList);

    }

    @Test
    public void findall(){
        Pageable pageable = PageRequest.of(0,3);
        Page<ProductInfo> productInfoPage = productService.findAll(pageable);
        Assert.assertNotNull(productInfoPage);
    }

    @Test
    public void onandoff(){

        ProductInfo result = productService.offSale("1552225035601832968096");
        Assert.assertNotNull(result);
    }
}