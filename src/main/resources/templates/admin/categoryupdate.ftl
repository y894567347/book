<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#include "../common/nav.ftl" >
    <div id="wrapper" class="toggled">
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-6 column">
                    <form class="form-horizontal" action="/book/admin/category/doupdate?categoryId=${productCategory.getCategoryId()}" method="post" role="form" style="margin-top: 100px">
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">类目ID</label>
                            <label class="col-sm-2 control-label">${productCategory.getCategoryId()}</label>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">类目类型</label>
                            <label class="col-sm-2 control-label">${productCategory.getCategoryType()}</label>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">类目名称</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" name="categoryName"  />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default">提交</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>