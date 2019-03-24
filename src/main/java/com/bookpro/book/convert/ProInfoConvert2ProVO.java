package com.bookpro.book.convert;

import com.bookpro.book.VO.ProductVO;
import com.bookpro.book.dataobject.ProductInfo;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/10 21:58
 * @Description:
 */
public class ProInfoConvert2ProVO {

    public static ProductVO convert(ProductInfo productInfo){

        ProductVO productVO = new ProductVO();
        BeanUtils.copyProperties(productInfo,productVO);
        return productVO;
    }

    public static List<ProductVO> convert(List<ProductInfo> productInfoList){

        return productInfoList.stream().map( e -> convert(e)).collect(Collectors.toList());
    }
}
