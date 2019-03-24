package com.bookpro.book.service;

import com.bookpro.book.dto.CartDTO;
import com.bookpro.book.dto.OrderDTO;
import com.bookpro.book.form.BuyerInfoForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/15 21:54
 * @Description:
 */
public interface OrderService {

    OrderDTO create(OrderDTO orderDTO);


    Page<OrderDTO> findAllById(String id, Pageable pageable);



}
