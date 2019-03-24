package com.bookpro.book.controller;

import com.bookpro.book.VO.ResultVO;
import com.bookpro.book.dto.CartDTO;
import com.bookpro.book.service.CartService;
import com.bookpro.book.service.ProductService;
import com.bookpro.book.utils.ResultUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/13 20:39
 * @Description:
 */
@RestController
@RequestMapping("/buyer/cart")

public class BuyerCartController {

    @Autowired
    private CartService cartService;

    //点击加入购物车
    @GetMapping("/add")
    public void productInfoDetail(@RequestParam("productId") String productId,
                                         @RequestParam("productQuantity")Integer productQuantity,
                                         HttpServletRequest request) {

        HttpSession session = request.getSession();
        Map<String,Integer> cart = (Map) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
            session.setAttribute("cart", cart);
            cart.put(productId,productQuantity);
        }
            cart.put(productId,productQuantity);

        }

        //渲染购物车table的异步数据接口
    @GetMapping("/view")
    public ResultVO view(HttpServletRequest request){

        HttpSession session = request.getSession();
        List<CartDTO> cartDTOList = new ArrayList<>();
        Map<String,Integer> cart = (Map) session.getAttribute("cart");
        if(cart==null)
        {
            return ResultUtil.error(1,"还没有加入任何书籍哦",cartDTOList);
        }
        cartDTOList = cartService.getCartList(cart);

        return ResultUtil.success(cartDTOList,cartDTOList.size());

    }

    @GetMapping("/del")
        public void del(@RequestParam("productId") String productId,
                        HttpServletRequest request){
        HttpSession session = request.getSession();
        Map<String,Integer> cart = (Map) session.getAttribute("cart");
        cart.remove(productId);
        }
}
