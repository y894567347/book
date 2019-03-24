<#include "../layuicommon/layuiheader.ftl">
<body class="layui-layout-body">
<#include "../layuicommon/nav.ftl">
<script type="text/html" id="cartBar">
    <a class="layui-btn layui-btn-danger layui-btn-sm" lay-event="delCart">不要了</a>
</script>
<div class="layui-body"  style="margin-top: 60px">
<div id="cart_div" style="margin-left: 200px">
    <table id="cartTable"  class="layui-table" lay-data="{id: 'cartList'}"  lay-filter="cartListFilter" >
    </table>

<div style="margin-left: 370px">
    <span>总金额: </span> <span id="totalPrice"></span>
</div>
    <button	class="layui-btn layui-btn-danger"  id="buyButton" style="margin-left: 230px">确认租借</button>
</div>

</div>
<!--如果Layer弹出层要调用某个DOM，那它必须在<body>的最外层 比如这个form-->
<form class="layui-form"  id="buyerInfoForm" action="" style="display: none;margin-right: 50px;margin-top: 20px" >
    <div class="layui-form-item">
        <label class="layui-form-label">联系人</label>
        <div class="layui-input-inline">
            <input type="text" id="buyerName" name="buyerName" required  lay-verify="required" placeholder="可用昵称，作为交付凭证" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">收货地址</label>
        <div class="layui-input-inline">
            <input type="text" id="buyerAddress"  name="buyerAddress" required  lay-verify="required" placeholder="例如：行健轩4 A119" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">电话</label>
        <div class="layui-input-inline">
            <input type="text" name="buyerPhone" id="buyerPhone" required   placeholder="请填写本人号码" autocomplete="off" class="layui-input">
        </div>
    </div>
</form>
<script src="/book/js/cartlist.js"></script>
<script src="/book/js/nav.js"></script>
</body>