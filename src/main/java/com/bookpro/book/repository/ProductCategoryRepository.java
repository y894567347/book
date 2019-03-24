package com.bookpro.book.repository;

import com.bookpro.book.dataobject.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/10 16:56
 * @Description:
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    List<ProductCategory> findAllByCategoryType(Integer categoryType);

    Page<ProductCategory> findAll(Pageable pageable);

    ProductCategory findByCategoryType(Integer categotyType);

    ProductCategory findByCategoryId(Integer categoryId);
}
