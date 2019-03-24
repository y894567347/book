package com.bookpro.book.service.Impl;

import com.bookpro.book.convert.OrderMasterConvert2OrderDTO;
import com.bookpro.book.dataobject.OrderDetail;
import com.bookpro.book.dataobject.OrderMaster;
import com.bookpro.book.dto.OrderDTO;
import com.bookpro.book.enums.OrderStatusEnum;
import com.bookpro.book.repository.OrderDetailRepository;
import com.bookpro.book.repository.OrderMasterRepository;
import com.bookpro.book.service.OrderService;
import com.bookpro.book.service.ProductService;
import com.bookpro.book.utils.KeyUtil;
import com.bookpro.book.utils.ListConvertPageUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/15 21:57
 * @Description:
 */
@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private ProductService productService;


      @Override
    public Page<OrderDTO> findAllById(String id, Pageable pageable) {

        List<OrderMaster> orderMasterList = orderMasterRepository.findAllByUserId(id);
          List<OrderDTO> orderDTOList = OrderMasterConvert2OrderDTO.convert(orderMasterList);
          for(OrderDTO  orderDTO: orderDTOList){
              List<OrderDetail> orderDetailList = orderDetailRepository.findAllByOrderId(orderDTO.getOrderId());
              orderDTO.setOrderDetailList(orderDetailList);
          }
          Page<OrderDTO>  orderDTOPage = ListConvertPageUtil.listConvertToPage(orderDTOList,pageable);
          return orderDTOPage;
    }

    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        String orderId = KeyUtil.genUniqueKey();
        orderDTO.setOrderId(orderId);
        orderDTO.setOrderStatus(OrderStatusEnum.NEW.getCode());
        //订单详情入库
        for(OrderDetail orderDetail : orderDTO.getOrderDetailList()){

            System.out.println(orderDetail.getProductId());
            orderDetail.setOrderId(orderId);
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            productService.decreaseStock(orderDetail.getProductId(),orderDetail.getProductQuantity());
            orderDetailRepository.save(orderDetail);
        }

        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMasterRepository.save(orderMaster);
        return orderDTO;



    }
}
