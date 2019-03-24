package com.bookpro.book.convert;



import com.bookpro.book.dataobject.OrderDetail;
import com.bookpro.book.dto.CartDTO;
import com.bookpro.book.dto.OrderDTO;
import com.bookpro.book.form.BuyerInfoForm;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/16 10:58
 * @Description:
 */
public class Convert2OrderDTO {

    public static OrderDTO convert(BuyerInfoForm buyerInfoForm, List<CartDTO> cartDTOList, BigDecimal orderAmount){

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderAmount(orderAmount);
        BeanUtils.copyProperties(buyerInfoForm,orderDTO);
        List<OrderDetail> orderDetailList = new ArrayList<>();
        for(CartDTO cartDTO : cartDTOList){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setProductId(cartDTO.getProductId());
            orderDetail.setProductName(cartDTO.getProductName());
            orderDetail.setProductPrice(new BigDecimal(cartDTO.getProductPrice()));
            orderDetail.setProductQuantity(cartDTO.getProductQuantity());
            orderDetailList.add(orderDetail);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
