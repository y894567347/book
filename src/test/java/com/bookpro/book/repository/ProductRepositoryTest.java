package com.bookpro.book.repository;

import com.bookpro.book.dataobject.ProductInfo;
import com.bookpro.book.enums.ProductStatusEnum;
import com.bookpro.book.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/10 17:08
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void findOne(){

        ProductInfo productInfo = productRepository.findById("asdasd").get();
        Assert.assertNotNull(productInfo);
    }

    @Test
    public void save(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId(KeyUtil.productIdUtils());
        productInfo.setCategoryType(2);
        productInfo.setProductStatus(ProductStatusEnum.ON_SALE.getCode());
        productInfo.setProductDescription("巨好看");
        productInfo.setProductIcon("http://xxx.com");
        productInfo.setProductName("水浒传");
        productInfo.setProductPrice(new BigDecimal("10.2"));
        productInfo.setProductStock(10);
        ProductInfo productInfo1 = productRepository.save(productInfo);
        Assert.assertNotNull(productInfo1);
    }

    @Test
    public void findall(){




    }
}