package com.bookpro.book.utils;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/16 16:14
 * @Description:  把list转化为Pageable  解决pageIml的构造无效的问题
 */
public class ListConvertPageUtil {

    public static <T> Page<T> listConvertToPage(List<T> list, Pageable pageable) {
        int start = (int) pageable.getOffset();
        int end = (start + pageable.getPageSize()) > list.size() ? list.size() : (start + pageable.getPageSize());
        return new PageImpl<T>(list.subList(start, end), pageable, list.size());
    }
}
