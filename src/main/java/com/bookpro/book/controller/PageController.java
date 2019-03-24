package com.bookpro.book.controller;

import com.bookpro.book.dataobject.ProductCategory;
import com.bookpro.book.service.ProductCategoryService;
import com.bookpro.book.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/12 12:12
 * @Description:
 */

@Controller
@RequestMapping("/")
public class PageController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("buyer/booklist")
    public ModelAndView booklist(Map<String,Object> map){
        List<ProductCategory> productCategoryList = productCategoryService.findAll();
        map.put("productCategoryList",productCategoryList);
        return new ModelAndView("buyer/booklist",map);

    }
    @GetMapping("buyer/cart")
    public String cart(){

        return "/buyer/cartlist";
    }


    @GetMapping("buyer/pay")
    public String pay(){

        return "buyer/pay";
    }

    @GetMapping("login")
    public String login(){
        return "/common/login";
    }

    @GetMapping("buyer/order")
    public String order(){
        return "/buyer/order";
    }

    @GetMapping("loginout")
    public ModelAndView loginout(HttpServletRequest request, HttpServletResponse response) {

        Cookie cookie1  = CookieUtil.get(request,"userid");
        Cookie cookie2  = CookieUtil.get(request,"username");
        if(cookie1!=null&&cookie2!=null){
            CookieUtil.set(response,"userid",null,0);
            CookieUtil.set(response,"username",null,0);
        }
        return new ModelAndView("redirect:login");
    }

    @GetMapping("admin/index")
    public String index(){

        return "add";
    }

}
