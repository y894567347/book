<#include "../layuicommon/layuiheader.ftl">
<body>
<div style="margin-top: 200px;margin-left: 500px" >
<h1 style="margin-left: 100px">长理书屋BETA</h1><br/>
<form id="loginForm" class="layui-form"   >
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-inline">
            <input type="text" name="username" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-inline">
            <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
    </div>

</form>
<button  class="layui-btn"  style="margin-left: 100px"  id="loginButton" >登陆</button><br/>
    普通用户  :  yjj 密码：111111<br/>
    管理员账号: root 密码：123456

</div>

</body>
<script src="/book/js/login.js"></script>
