package com.bookpro.book.repository;

import com.bookpro.book.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/10 17:01
 * @Description:
 */
public interface ProductRepository extends JpaRepository<ProductInfo,String> {

    List<ProductInfo> findByCategoryTypeAndProductStatus(Integer categoryType,Integer productStatus);

    Page<ProductInfo> findAll(Pageable pageable);

    List<ProductInfo> findAllByProductStatus(Integer status);


}
