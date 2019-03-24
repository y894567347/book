<#include "../layuicommon/layuiheader.ftl">
<script type="text/html" id="orderListBar">
    <a class="layui-btn layui-btn layui-btn-sm" lay-event="orderDetail">查看详情</a>
</script>
<body class="layui-layout-body">
<#include "../layuicommon/nav.ftl">
<div class="layui-body"  style="margin-top: 40px">
<div id="table_div" style="margin-left: 100px;margin-top: 60px;">
    <table id="orderTable" class="layui-table" lay-data="{id: 'productList'}"  lay-filter="orderListFilter" >
    </table>
</div>
</div>
<script src="/book/js/order.js"></script>
<script src="/book/js/nav.js"></script>
</body>