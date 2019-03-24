package com.bookpro.book.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/22 18:51
 * @Description:
 */
@Data
public class CategoryForm {

    @NotNull(message = "类目Id必须填写")
    private Integer categoryId;

    @NotEmpty(message = "类目名字必须填写")
    private String categoryName;

    @NotNull(message = "类目类型必须填写")
    private Integer categoryType;
}
