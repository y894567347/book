<#include "../layuicommon/layuiheader.ftl">
<body class="layui-layout-body">
<#include "../layuicommon/nav.ftl">
<div class="layui-body"  style="margin-top: 60px">
    <h4 style="margin-left: 300px;margin-top: 100px"><a href="/book/buyer/booklist" class="alert-link">已经收到了您的订单   支付模块还未完成... 三秒后跳转</a></h4>
</div>
</body>
<script>
    setTimeout('location.href="/book/buyer/booklist"', 3000);
</script>