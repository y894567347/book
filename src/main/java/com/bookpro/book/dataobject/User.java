package com.bookpro.book.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/10 15:15
 * @Description:
 */
@Data
@Entity
public class User {

    @Id
    private String userId;

    private String username;

    private String password;

    private Integer userRole;

}
