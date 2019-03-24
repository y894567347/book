package com.bookpro.book.service.Impl;

import com.bookpro.book.dataobject.ProductCategory;
import com.bookpro.book.enums.ExceptionEnum;
import com.bookpro.book.exception.BookException;
import com.bookpro.book.repository.ProductCategoryRepository;
import com.bookpro.book.service.ProductCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/11 15:57
 * @Description:
 */
@Service
@Slf4j
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategory findOne(Integer id) {

        return productCategoryRepository.findById(id).get();
    }

    @Override
    public ProductCategory findByCategoryType(Integer categoryType) {

        return productCategoryRepository.findByCategoryType(categoryType);
    }

    @Override
    public List<ProductCategory> findAll() {

        return productCategoryRepository.findAll();
    }

    @Override
    public List<ProductCategory> findAllByCategoryType(Integer categoryType) {

        return productCategoryRepository.findAllByCategoryType(categoryType);
    }

    @Override
    public Page<ProductCategory> findAllPage(Pageable pageable) {

        return productCategoryRepository.findAll(pageable);

    }


    @Override
    public ProductCategory update(ProductCategory productCategory) {


        return productCategoryRepository.save(productCategory);
    }

    @Override
    public ProductCategory add(ProductCategory productCategory) {
        if(productCategoryRepository.findByCategoryType(productCategory.getCategoryType())!=null){

            log.error("【类目更新】 已存在相同类型的类目");
            throw new BookException(ExceptionEnum.CATEGORY_EXIST_ERROR);
        }

        return productCategoryRepository.save(productCategory);
    }
}
