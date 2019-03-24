package com.bookpro.book.handler;

import com.bookpro.book.VO.ResultVO;
import com.bookpro.book.enums.ExceptionEnum;
import com.bookpro.book.exception.BookException;
import com.bookpro.book.exception.UserAuthorException;
import com.bookpro.book.utils.ResultUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/20 20:09
 * @Description:
 */
@ControllerAdvice
public class UserAuthorExceptionHandler {

@ExceptionHandler(value = UserAuthorException.class)
//@ResponseStatus(HttpStatus.FORBIDDEN) //返回一个错误页面 403
//http://localhost:8080/book/login
public ModelAndView handAuthorException(UserAuthorException e){
//     map.put("msg",e.getMessage());
//     map.put("url","common/login");

     System.out.println(e.getMessage());
     Map<String,Object> map = new HashMap<>();
     if(e.getCode().equals(ExceptionEnum.LOGIN_ERROR.getCode())) {
          map.put("msg", e.getMessage());
          map.put("url", "/book/login");
          return new ModelAndView("common/error", map);
     }

     if(e.getCode().equals(ExceptionEnum.GRANT_ERROR.getCode())){
          map.put("msg",e.getMessage());
          map.put("url","/book/buyer/booklist");
          return new ModelAndView("common/error",map);
     }
return null;
}

@ExceptionHandler(value = BookException.class)
@ResponseBody
     public ResultVO handlerBookException(BookException e){

     return ResultUtil.error(e.getCode(),e.getMessage());
}
}
