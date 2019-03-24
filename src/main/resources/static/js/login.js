layui.use("layer",function () {

    console.log("此网站由YJJ本人独立完成");
    var layer = layui.layer;


    $("#loginButton").click(function () {

        $.post({
            url: '/book/islogin',
            data:$("#loginForm").serialize(),
            success:function (data) {
                if(data.code === 200){
                    window.location.href='/book/buyer/booklist';
                    layer.msg(data.msg);
                }
                else if(data.code === 300){

                        window.location.href='admin/book/booklist'
                }
                else {
                    layer.msg(data.msg);
                }

            }
        })
    })
});