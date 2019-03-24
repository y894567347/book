package com.bookpro.book.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.CollationKey;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/18 20:05
 * @Description:
 */
public class CookieUtil {

    public  static void set(HttpServletResponse response,
                      String name,
                      String value,
                      int maxAge){

        Cookie cookie = new Cookie(name,value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    /**
     * 把Cookie封装成Map 方便查找
     * @param response
     * @return
     */
    private  static  Map<String,Cookie> readToMap(HttpServletRequest request){

        Map<String,Cookie> cookieMap  = new HashMap<>();
        Cookie[]  cookies = request.getCookies();
        if(cookies!=null){
            for(Cookie cookie : cookies){
                cookieMap.put(cookie.getName(),cookie);
            }
        }
        return cookieMap;
    }

    public static Cookie get(HttpServletRequest request,
                             String name){

        Map<String,Cookie> cookieMap = readToMap(request);

        if(cookieMap.containsKey(name)){
            return cookieMap.get(name);
        }
        else {
            return null;
        }
    }
}
