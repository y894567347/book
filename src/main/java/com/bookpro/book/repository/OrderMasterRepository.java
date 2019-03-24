package com.bookpro.book.repository;

import com.bookpro.book.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/10 17:22
 * @Description:
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {

  List<OrderMaster> findAllByUserId(String userId);
}