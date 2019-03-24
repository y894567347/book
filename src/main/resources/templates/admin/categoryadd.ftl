<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#include "../common/nav.ftl" >
    <div id="wrapper" class="toggled">
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-6 column">
                    <form class="form-horizontal" action="/book/admin/category/add" method="post" role="form" style="margin-top: 100px">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">类目ID</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="categoryId"  />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">类目类型</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="categoryType"  />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">类目名称</label>
                            <div class="col-sm-10">
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
                <div class="col-md-6 column">
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>