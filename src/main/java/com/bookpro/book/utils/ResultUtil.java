package com.bookpro.book.utils;

import com.bookpro.book.VO.ResultVO;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/10 21:11
 * @Description:
 */
public class ResultUtil {

    public static ResultVO success(Object object,long count){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setCount(count);
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO error(Integer code,String msg,Object object){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        resultVO.setData(object);
        return resultVO;

    }
    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        resultVO.setData(null);
        return resultVO;

    }
}
