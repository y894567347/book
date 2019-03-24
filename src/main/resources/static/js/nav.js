//获取用户名
$.get({
    url: '/book/getusername',
    success:function (data) {
        $("#userName").text(data);
    }
});