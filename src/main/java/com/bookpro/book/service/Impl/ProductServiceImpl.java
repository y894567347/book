package com.bookpro.book.service.Impl;

import com.bookpro.book.VO.ProductVO;
import com.bookpro.book.convert.ProInfoConvert2ProVO;
import com.bookpro.book.dataobject.ProductInfo;
import com.bookpro.book.enums.ExceptionEnum;
import com.bookpro.book.enums.ProductStatusEnum;
import com.bookpro.book.exception.BookException;
import com.bookpro.book.repository.ProductRepository;
import com.bookpro.book.service.ProductService;
import com.bookpro.book.utils.ListConvertPageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/10 19:58
 * @Description:
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductInfo addOne(ProductInfo productInfo) {
        productInfo.setProductStatus(ProductStatusEnum.ON_SALE.getCode());
        return productRepository.save(productInfo);
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {

        return productRepository.findAll(pageable);

    }


    @Override
    public Page<ProductInfo> findOnSale(Pageable pageable) {

       List<ProductInfo> productInfoList = productRepository.findAllByProductStatus(0);
       Page<ProductInfo> productInfoPage = ListConvertPageUtil.listConvertToPage(productInfoList,pageable);

       return productInfoPage;
    }

    @Override
    public Page<ProductInfo> findByCategoryType(Pageable pageable,Integer categoryType,Integer productStatus) {

        List<ProductInfo> productInfoList = productRepository.findByCategoryTypeAndProductStatus(categoryType,productStatus);
        Page<ProductInfo> productInfoPage = ListConvertPageUtil.listConvertToPage(productInfoList,pageable);
        return productInfoPage;
    }

    @Override
    public ProductInfo findOneById(String id) {

        return productRepository.findById(id).get();
    }

    @Override
    @Transactional
    public ProductInfo decreaseStock(String productId, Integer productQuantity) {

        ProductInfo productInfo = this.findOneById(productId);
        if(productInfo==null){
            throw new BookException(ExceptionEnum.PRODUCT_EXIST_ERROR);
        }

        productInfo.setProductStock(productInfo.getProductStock()-productQuantity);
        if(productInfo.getProductStock()<=0){
            productInfo.setProductStatus(ProductStatusEnum.OFF_SALE.getCode());
        }
        productRepository.save(productInfo);
        return productInfo;
    }

    @Override
    @Transactional
    public ProductInfo increaseStock(String productId, Integer productQuantity) {
        ProductInfo productInfo = this.findOneById(productId);
        if(productInfo==null){
            throw new BookException(ExceptionEnum.PRODUCT_EXIST_ERROR);
        }
        productInfo.setProductStock(productInfo.getProductStock()+productQuantity);
        productRepository.save(productInfo);
        return productInfo;
    }

    @Override
    public ProductInfo onSale(String id) {

        ProductInfo productInfo = this.findOneById(id);
        if(productInfo ==null)
        {
            throw new BookException(ExceptionEnum.PRODUCT_EXIST_ERROR);
        }
        if(productInfo.getProductStatus()==0){

            log.error("【上架错误】  已经上架的书不能再上架");
            throw  new BookException(ExceptionEnum.ON_OFF_ERROR);

        }
        productInfo.setProductStatus(0);
       return  productRepository.save(productInfo);

    }

    @Override
    public ProductInfo offSale(String id) {
        ProductInfo productInfo = this.findOneById(id);
        if(productInfo ==null)
        {
            throw new BookException(ExceptionEnum.PRODUCT_EXIST_ERROR);
        }
        if(productInfo.getProductStatus()==1){

            log.error("【下架错误】  已经下架的书不能再下架");
            throw  new BookException(ExceptionEnum.ON_OFF_ERROR);

        }
        productInfo.setProductStatus(1);
        return  productRepository.save(productInfo);
    }

    @Override
    public ProductInfo update(ProductInfo productInfo) {

        return productRepository.save(productInfo);
    }
}
