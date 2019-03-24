package com.bookpro.book.service.Impl;

import com.bookpro.book.dataobject.ProductInfo;
import com.bookpro.book.dto.CartDTO;
import com.bookpro.book.service.CartService;
import com.bookpro.book.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/14 14:01
 * @Description:
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    ProductService productService;

    @Override
    public List<CartDTO> getCartList(Map<String, Integer> cartMap) {

        //将购物车的Map 转化为CartDTO列表
        List<CartDTO> cartDTOList = new ArrayList<>();
        for(Map.Entry<String,Integer> entry :cartMap.entrySet()){
            ProductInfo productInfo = productService.findOneById(entry.getKey());
            cartDTOList.add(new CartDTO(entry.getKey(),productInfo.getProductName(),productInfo.getProductPrice().doubleValue(),entry.getValue()));
        }
        return cartDTOList;
    }
}
