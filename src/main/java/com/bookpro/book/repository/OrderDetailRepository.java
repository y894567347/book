package com.bookpro.book.repository;

import com.bookpro.book.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/10 17:23
 * @Description:
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {

    List<OrderDetail> findAllByOrderId(String id);


}
