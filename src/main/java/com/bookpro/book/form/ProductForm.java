package com.bookpro.book.form;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/10 20:27
 * @Description:  前端上传书信息表单类
 */
@Data
public class ProductForm {

    @NotEmpty(message = "书名必填")
    private String productName;


    @NotEmpty(message = "作者必填")
    private String bookAuthor;

    @NotNull
    private BigDecimal productPrice;

    @NotNull(message = "类型必填")
    @Min(value = 1,message = "租金必须大于一元")
    private Integer CategoryType;

    @NotNull (message = "数量必填")
    @Min(value = 1,message = "库存必须大于1")
    private Integer productStock;

    private String productDescription;

    private String productIcon;
}
