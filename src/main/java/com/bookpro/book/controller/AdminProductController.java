package com.bookpro.book.controller;

import com.bookpro.book.VO.ResultVO;
import com.bookpro.book.convert.ProFormConvert2ProInfo;
import com.bookpro.book.dataobject.ProductCategory;
import com.bookpro.book.dataobject.ProductInfo;
import com.bookpro.book.enums.ExceptionEnum;
import com.bookpro.book.exception.BookException;
import com.bookpro.book.form.ProductForm;
import com.bookpro.book.service.Impl.ProductServiceImpl;
import com.bookpro.book.service.ProductCategoryService;
import com.bookpro.book.service.ProductService;
import com.bookpro.book.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/10 20:15
 * @Description:
 */
@Controller
@RequestMapping("/admin/book")
@Slf4j
public class AdminProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/addindex")
    public ModelAndView index(Map<String,Object> map){

        List<ProductCategory> productCategoryList = productCategoryService.findAll();
        map.put("categoryList",productCategoryList);
      return new ModelAndView("admin/add",map);
    }

    @PostMapping("/addbook")
    public ModelAndView add(@Valid ProductForm productForm, BindingResult bindingResult, Map<String,Object> map){

        //查找当前所有类目

        if(bindingResult.hasErrors()){
            log.error("【新加书籍】表单参数错误");
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/book/admin/book/addindex");
            return new ModelAndView("common/error",map);
        }
            ProductInfo productInfo = ProFormConvert2ProInfo.convert(productForm);
            ProductInfo result = productService.addOne(productInfo);
            if (result == null) {
                log.error("【新加书籍】 加入书籍失败 ");
                map.put("msg", ExceptionEnum.PRODUCT_EXIST_ERROR.getMsg());
                map.put("url", "/book/admin/book/addindex");
                return new ModelAndView("common/error", map);
            }


        map.put("url","/book/admin/book/addindex");
        map.put("msg","添加书籍成功");
        return new ModelAndView("common/success",map);

    }

    @GetMapping("/booklist")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "8") Integer size,
                             Map<String,Object> map){

        PageRequest request = PageRequest.of(page-1,size);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
        map.put("productPage",productInfoPage);
        map.put("currentPage",page);
        map.put("size",size);
    return new ModelAndView("admin/upandoff",map);

    }

    @GetMapping("/onsale")
    public ModelAndView onsale(@RequestParam("productId") String productId,
                               Map<String,Object> map){

        try {
            productService.onSale(productId);
        } catch (BookException e) {
            map.put("msg",e.getMessage());
            map.put("url","/book/admin/book/booklist");
            return new ModelAndView("common/error",map);
        }

        map.put("url","/book/admin/book/booklist");
        map.put("msg","上架成功");
         return new ModelAndView("common/success",map);
    }


    @GetMapping("/offsale")
    public ModelAndView offsale(@RequestParam("productId") String productId,
                               Map<String,Object> map){

        try {
            productService.offSale(productId);
        } catch (BookException e) {

            map.put("msg",e.getMessage());
            map.put("url","/book/admin/book/booklist");
            return new ModelAndView("common/error",map);
        }

        map.put("url","/book/admin/book/booklist");
        map.put("msg","下架成功");
        return new ModelAndView("common/success",map);
    }

    @GetMapping("/update")
    public ModelAndView update(@RequestParam("productId") String productId,
                               Map<String,Object> map){

        ProductInfo productInfo = productService.findOneById(productId);
        List<ProductCategory> productCategoryList =  productCategoryService.findAll();
        String categoryName = productCategoryService.findByCategoryType(productInfo.getCategoryType()).getCategoryName();
        map.put("product",productInfo);
        map.put("categoryList",productCategoryList);
        map.put("categoryName",categoryName);
        return new ModelAndView("admin/productupdate");
    }

    @PostMapping("/doupdate")
    public ModelAndView doupdate(@RequestParam("productId") String productId,
                                 @Valid ProductForm productForm,
                                 BindingResult bindingResult,
                                 Map<String,Object> map){

        ProductInfo productInfo = new ProductInfo();
        BeanUtils.copyProperties(productForm,productInfo);
        productInfo.setProductId(productId);
        productService.update(productInfo);
        map.put("url","booklist");
        return new ModelAndView("common/success");
    }
}
