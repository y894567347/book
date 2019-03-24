package com.bookpro.book.controller;

import com.bookpro.book.dataobject.ProductCategory;
import com.bookpro.book.exception.BookException;
import com.bookpro.book.form.CategoryForm;
import com.bookpro.book.service.ProductCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/21 20:03
 * @Description:
 */
@Controller
@RequestMapping("/admin/category")
@Slf4j
public class AdminCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                             @RequestParam(value="size",defaultValue = "10") Integer size,
                             Map<String,Object> map){

        PageRequest pageRequest = PageRequest.of(page-1,size);
        Page<ProductCategory> productCategoryPage  = productCategoryService.findAllPage(pageRequest);
        map.put("productCategoryPage",productCategoryPage);
        map.put("currentPage",page);
        map.put("size",size);
        return new ModelAndView("admin/categorylist",map);
    }

    @GetMapping("/addindex")
    public ModelAndView addindex(){

        return new ModelAndView("admin/categoryadd");
    }
    @PostMapping("/add")
    public ModelAndView add(@Valid CategoryForm categoryForm, BindingResult bindingResult,
                            Map<String,Object> map){

        if(bindingResult.hasErrors()){
            log.error("【添加类目】 表单参数错误");
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","list");
            return new ModelAndView("common/error");
        }
        ProductCategory productCategory = new ProductCategory();
        BeanUtils.copyProperties(categoryForm,productCategory);

        try {
            productCategoryService.add(productCategory);
        }
        catch (BookException e){
            map.put("msg",e.getMessage());
        }
        map.put("msg","添加类目成功");
        map.put("url","list");
        return new ModelAndView("common/success");
    }

    @GetMapping("/update")
    public ModelAndView update(@RequestParam("categoryId")Integer categoryId,
                               Map<String,Object> map){

        ProductCategory productCategory = productCategoryService.findOne(categoryId);
        map.put("productCategory",productCategory);
        return new ModelAndView("admin/categoryupdate",map);
    }

    //只允许修改类目名字
    @PostMapping("/doupdate")
    public ModelAndView  doupdate(@RequestParam("categoryId") Integer categoryId,
                                  @RequestParam("categoryName") String categoryName,
                                  Map<String,Object> map){

        ProductCategory productCategory = productCategoryService.findOne(categoryId);
        productCategory.setCategoryName(categoryName);

            productCategoryService.update(productCategory);


        map.put("msg","修改类目成功");
        map.put("url","list");

        return new ModelAndView("common/success",map);
    }
}
