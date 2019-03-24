<#include "../layuicommon/layuiheader.ftl">
<body class="layui-layout-body">
<#include "../layuicommon/nav.ftl">
<!--工具条-->
<script type="text/html" id="booklistBar">
    <a class="layui-btn layui-btn-warm layui-btn-sm" lay-event="addCart">购买</a>
    <a class="layui-btn layui-btn-sm" lay-event="detail">查看图片</a>
</script>
<!-- 你的HTML代码 -->
<div class="layui-body"  style="margin-top: 60px">
    <div id="selectCategory" style="margin-left: 50px">
    <form class="layui-form" style="margin-top: 20px" action="">
        <div class="layui-form-item">
            <label class="layui-form-label">选择类别</label>
            <div class="layui-input-inline">
                <select name="city" id="categorySelect" lay-verify="required" lay-filter="categoryFilter">
                    <option value=0>全部</option>
                    <#list productCategoryList as list>
                        <option value=${list.getCategoryType()}>${list.getCategoryName()}</option>
                    </#list>
                </select>
            </div>
        </div>
    </form>
    </div>
    <div id="table_div" style="margin-left: 100px">
    <table id="productTable" class="layui-table" lay-data="{id: 'productList'}"  lay-filter="productListFilter" >
    </table>
    </div>
    <p style="margin-left: 90px">拖动滑块或者输入数量</p>
    <div style=" margin-top:10px;margin-left:90px;width: 500px" class="slide " id="productQuantity">

    </div>
    <button  id = "addCart" style="position: absolute;top:400px;right: 400px" class="layui-btn layui-btn-lg layui-btn-radius layui-btn-normal ">加入购物车</button>
    <button  id = "cartView" style="position: absolute;top:400px;right: 200px" class="layui-btn layui-btn-lg layui-btn-radius layui-btn layui-btn-danger ">查看购物车</button>

</div>

</body>

<script src="/book/js/productlist.js"></script>
<script src="/book/js/nav.js"></script>
</html>