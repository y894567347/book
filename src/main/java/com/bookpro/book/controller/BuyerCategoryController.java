package com.bookpro.book.controller;

import com.bookpro.book.VO.ResultVO;
import com.bookpro.book.dataobject.ProductCategory;
import com.bookpro.book.service.ProductCategoryService;
import com.bookpro.book.service.ProductService;
import com.bookpro.book.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/11 20:22
 * @Description:
 */

@RestController
@RequestMapping("/buyer/category")
public class BuyerCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;
//查询所有类目
    @GetMapping("/all")
    public ResultVO all(){

        List<ProductCategory> productCategoryList = productCategoryService.findAll();
        return ResultUtil.success(productCategoryList,productCategoryList.size());

    }
}
