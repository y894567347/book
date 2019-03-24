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
                    <td>类目ID</td>
                    <td>类目描述</td>
                    <td>类目类型</td>
                    <td>操作</td>
                </tr>
                <#list productCategoryPage.getContent() as list>
                    <tr>
                        <td>${list.getCategoryId()}</td>
                        <td>${list.getCategoryName()}</td>
                        <td>${list.getCategoryType()}</td>
                        <td><a href="update?categoryId=${list.getCategoryId()}">修改</a></td>
                    </tr>
                </#list>
                </thead>
            </table>

            <#--分页-->
            <div class="col-md-12 column">
                <ul class="pagination pull-right">
                    <#if currentPage lte 1>
                        <li class="disabled"><a href="#">上一页</a></li>
                    <#else>
                        <li ><a href="/book/admin/category/list?page=${currentPage-1}&size=${size}">上一页</a></li>
                    </#if>
                    <#list 1..productCategoryPage.getTotalPages() as index>
                        <#if currentPage == index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else>
                            <li><a href="/book/admin/category/list?page=${index}&size=${size}">${index}</a></li>
                        </#if>
                    </#list>
                    <#if currentPage  gte productCategoryPage.getTotalPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/book/admin/category/list?page=${currentPage+1}&size=${size}">下一页</a></li>
                    </#if>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>