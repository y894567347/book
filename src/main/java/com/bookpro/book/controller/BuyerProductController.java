package com.bookpro.book.controller;

import com.bookpro.book.VO.ProductVO;
import com.bookpro.book.VO.ResultVO;
import com.bookpro.book.convert.ProInfoConvert2ProVO;
import com.bookpro.book.dataobject.ProductInfo;
import com.bookpro.book.dto.CartDTO;
import com.bookpro.book.enums.ExceptionEnum;
import com.bookpro.book.enums.ProductStatusEnum;
import com.bookpro.book.exception.BookException;
import com.bookpro.book.service.ProductService;
import com.bookpro.book.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/10 21:41
 * @Description:
 */
@RestController
@RequestMapping("/buyer")
@Slf4j
public class BuyerProductController {
    @Autowired
    private ProductService productService;



    //查询所有上架书籍
    @GetMapping("/productlist")
    public ResultVO productList(@RequestParam("page") Integer page,
                                @RequestParam("limit") Integer limit){

       Pageable pageable = PageRequest.of(page-1,limit);
       Page<ProductInfo> productInfoPage = productService.findOnSale(pageable);
       return ResultUtil.success(productInfoPage.getContent(),productInfoPage.getTotalElements());

    }
  //根据类目查询书籍
    @GetMapping("/bycategoty")
    public ResultVO productList(@RequestParam("categoryType") Integer categoryType,
                                @RequestParam("page") Integer page,
                                @RequestParam("limit") Integer limit){

        Pageable pageable = PageRequest.of(page-1,limit);
        if(categoryType==0){

            Page<ProductInfo> productInfoPage = productService.findOnSale(pageable);
            return ResultUtil.success(productInfoPage.getContent(),productInfoPage.getTotalElements());
        }
       Page<ProductInfo> productInfoPage = productService.findByCategoryType(pageable,categoryType, ProductStatusEnum.ON_SALE.getCode());
       return ResultUtil.success(productInfoPage.getContent(),productInfoPage.getTotalElements());

    }

    }
