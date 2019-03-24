package com.bookpro.book.utils;

import java.util.Random;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/10 19:43
 * @Description: 生成随机ID
 */
public class KeyUtil {

    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer key = random.nextInt()*900000+100000;
        return System.currentTimeMillis()+String.valueOf(key);
    }

    public static synchronized String productIdUtils(){
        Random random = new Random();
        Integer key = random.nextInt()*900+100;
        return System.currentTimeMillis()+String.valueOf(key);
    }
}
