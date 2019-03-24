
<div class="layui-layout layui-layout-admin">
<div class="layui-header layui-bg-black" >

    <div class="layui-logo layui-bg-black"><i class="layui-icon layui-icon-home"></i>长理书屋</div>
    <ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item">
             <span class="layui-badge" id="userName">     </span>
        </li>
        <li class="layui-nav-item" style="margin-left: 40px">
            <a href="/book/admin/book/booklist">进入后台管理</a>
        </li>
    </ul>
</div>

<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <ul class="layui-nav layui-nav-tree" lay-filter="test">
            <li class="layui-nav-item layui-nav-itemed">
                <a href="javascript:;">买家选项</a>
                <dl class="layui-nav-child">
                    <dd><a href="/book/buyer/booklist";">书单</a></dd>
                    <dd><a href="/book/buyer/cart";">购物车</a></dd>
                    <dd><a href="/book/buyer/order";">我的订单</a></dd>
                    <dd><a href="/book/loginout";">登出</a></dd>
                </dl>
            </li>
        </ul>

    </div>
</div>
</div>
