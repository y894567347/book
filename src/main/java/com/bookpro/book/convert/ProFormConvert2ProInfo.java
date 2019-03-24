package com.bookpro.book.convert;

import com.bookpro.book.dataobject.ProductInfo;
import com.bookpro.book.form.ProductForm;
import com.bookpro.book.utils.KeyUtil;

/**
 * @Auther: 杨俊杰
 * @Date: 2019/3/10 20:33
 * @Description:
 */
public class ProFormConvert2ProInfo {

    public static ProductInfo convert(ProductForm productForm){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductPrice(productForm.getProductPrice());
        productInfo.setBookAuthor(productForm.getBookAuthor());
        productInfo.setProductId(KeyUtil.genUniqueKey());
        productInfo.setProductStock(productForm.getProductStock());
        productInfo.setProductIcon(productForm.getProductIcon());
        productInfo.setProductDescription(productForm.getProductDescription());
        productInfo.setCategoryType(productForm.getCategoryType());
        productInfo.setProductName(productForm.getProductName());
        return productInfo;
    }
}
