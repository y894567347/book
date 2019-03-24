<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#include "../common/nav.ftl" >
        <div class="container-fluid" style="margin-top: 60px">
            <div class="col-md-12 column">
                <table class="table table-bordered table-condensed">

                    <thead>
                    <tr>
                        <th>书籍编号</th>
                        <th>书名</th>
                        <th>作者</th>
                        <th>类别</th>
                        <th>租金</th>
                        <th>库存</th>
                        <th>描述</th>
                        <th>创建时间</th>
                        <th>修改时间</th>
                        <th colspan="2">操作</th>
                    </tr>
                    </thead>
                <tbody>
                <#list productPage.getContent() as book>
                    <tr>
                        <td>${book.getProductId()}</td>
                        <td>${book.getProductName()}</td>
                        <td>${book.getBookAuthor()}</td>
                        <td>${book.getCategoryType()}</td>
                        <td>${book.getProductPrice()}</td>
                        <td>${book.getProductStock()}</td>
                        <td>${book.getProductDescription()}</td>
                        <td>${book.getCreateTime()}</td>
                        <td>${book.getUpdateTime()}</td>
                        <td>
                            <#if book.getProductStatus() == 0>
                                <a href="/book/admin/book/offsale?productId=${book.getProductId()}">下架</a>
                                <#else>
                                    <a href="/book/admin/book/onsale?productId=${book.getProductId()}">上架</a>
                            </#if>
                        </td>
                        <td>
                            <a href="/book/admin/book/update?productId=${book.getProductId()}">修改</a>
                        </td>
                    </tr>
                </#list>

                </tbody>

            </table>
        </div>
            <#--分页-->
            <div class="col-md-12 column">
                <ul class="pagination pull-right">
                    <#if currentPage lte 1>
                        <li class="disabled"><a href="#">上一页</a></li>
                    <#else>
                        <li ><a href="/book/admin/book/booklist?page=${currentPage-1}&size=${size}">上一页</a></li>
                    </#if>
                    <#list 1..productPage.getTotalPages() as index>
                        <#if currentPage == index>
                            <li class="disabled"><a href="#">${index}</a></li>
                            <#else>
                            <li><a href="/book/admin/book/booklist?page=${index}&size=${size}">${index}</a></li>
                        </#if>
                    </#list>
                    <#if currentPage gte productPage.getTotalPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                        <#else>
                        <li><a href="/book/admin/book/booklist?page=${currentPage+1}&size=${size}">下一页</a></li>
                    </#if>
                </ul>
            </div>
</div>
</body>
</html>