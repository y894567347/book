package com.bookpro.book.service.Impl;

import com.bookpro.book.convert.Convert2OrderDTO;
import com.bookpro.book.dto.CartDTO;
import com.bookpro.book.dto.OrderDTO;
import com.bookpro.book.form.BuyerInfoForm;
import com.bookpro.book.service.OrderService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/16 14:20
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceImplTest {

    @Autowired
     private  OrderService orderService;

    @Test
    public void create() {

        BuyerInfoForm buyerInfoForm = new BuyerInfoForm();
        List<CartDTO> cartDTOList = new ArrayList<>();
        buyerInfoForm.setBuyerName("yjj");
        buyerInfoForm.setBuyerAddress("行四A119");
        buyerInfoForm.setBuyerPhone("13142264905");
        CartDTO cartDTO = new CartDTO("123123","阿瑟东",12.3,4);
        cartDTOList.add(cartDTO);
        OrderDTO orderDTO = Convert2OrderDTO.convert(buyerInfoForm,cartDTOList,new BigDecimal(100.4));
        OrderDTO result = orderService.create(orderDTO);
        Assert.assertNotNull(result);
    }

    @Test
    public void test2(){

        PageRequest request  = PageRequest.of(0,1);
        Page<OrderDTO>  orderDTOPage=    orderService.findAllById("0002",request);
     Assert.assertNotNull(orderDTOPage);
    }
}