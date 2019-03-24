package com.bookpro.book.service;

import com.bookpro.book.dto.CartDTO;

import java.util.List;
import java.util.Map;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/14 14:00
 * @Description:
 */
public interface CartService {

    List<CartDTO> getCartList(Map<String,Integer> cartMap);
}
