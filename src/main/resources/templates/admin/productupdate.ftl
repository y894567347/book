<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#include "../common/nav.ftl" >
    <div id="wrapper" class="toggled">
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-6 column">
                    <form class="form-horizontal" action="/book/admin/book/doupdate?productId=${product.getProductId()}" method="post" role="form" style="margin-top: 100px">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">书名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="productName" value="${product.getProductName()}"  />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">作者</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="bookAuthor" value="${product.getBookAuthor()}" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">预想价格</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="productPrice" value="${product.getProductPrice()}" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">数量</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="productStock" value="${product.getProductStock()}" />
                            </div>
                        </div>
                        <div class="form-group ">
                            <label for="inputEmail3" class="col-sm-2 control-label">类别</label>
                            <div class="col-xs-4">
                                <select class="col-xs-4 form-control" name="categoryType">
                                    <option selected="selected" value=${product.getCategoryType()}>${categoryName}</option>
                                    <#list categoryList as list>
                                        <option value=${list.getCategoryType()}>${list.getCategoryName()}</option>
                                    </#list>
                                </select>
                            </div>

                        </div>

                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">书籍描述</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="productDescription" value="${product.getProductDescription()}"  />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">书籍图片链接</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="productIcon"  value="${product.getProductIcon()} " />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default">修改</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-md-6 column">
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>