package com.bookpro.book.convert;

import com.bookpro.book.dataobject.OrderMaster;
import com.bookpro.book.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/17 15:23
 * @Description:
 */
public class OrderMasterConvert2OrderDTO {

    public static OrderDTO convert(OrderMaster orderMaster){

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){

        return orderMasterList.stream().map(e ->convert(e)).collect(Collectors.toList());
    }
}
