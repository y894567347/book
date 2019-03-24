package com.bookpro.book.controller;

import com.bookpro.book.VO.ResultVO;
import com.bookpro.book.convert.Convert2OrderDTO;
import com.bookpro.book.dataobject.User;
import com.bookpro.book.dto.CartDTO;
import com.bookpro.book.dto.OrderDTO;
import com.bookpro.book.form.BuyerInfoForm;
import com.bookpro.book.service.CartService;
import com.bookpro.book.service.OrderService;
import com.bookpro.book.utils.CookieUtil;
import com.bookpro.book.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/15 20:01
 * @Description:
 */
@RestController
@RequestMapping("/buyer/order")
public class BuyerOrderController {

    @Autowired
    private CartService cartService;
    @Autowired
    private OrderService orderService;

    @RequestMapping("/create")
    public void create(@RequestParam("totalPrice") Double totalPrice,
                               @Valid BuyerInfoForm buyerInfoForm, HttpServletRequest request,
                       HttpServletResponse response){
        HttpSession session = request.getSession();
        Map<String,Integer> cart = (Map)session.getAttribute("cart");
        String userid = CookieUtil.get(request,"userid").getValue();
        List<CartDTO> cartDTOList = cartService.getCartList(cart);
        OrderDTO orderDTO = Convert2OrderDTO.convert(buyerInfoForm,cartDTOList,new BigDecimal(totalPrice));
        orderDTO.setUserId(userid);
        session.removeAttribute("cart");
        orderService.create(orderDTO);

    }

    @GetMapping("/orderlist")
    public ResultVO showorder(@RequestParam("page")Integer page,
                              @RequestParam("limit")Integer limit,
                              HttpServletRequest request, HttpServletResponse response){
        PageRequest pageRequest = PageRequest.of(page-1,limit);
        HttpSession session = request.getSession();
        String userid = CookieUtil.get(request,"userid").getValue();
        Page<OrderDTO> orderDTOPage = orderService.findAllById(userid,pageRequest);
        return ResultUtil.success(orderDTOPage.getContent(),orderDTOPage.getTotalElements());
    }
}
