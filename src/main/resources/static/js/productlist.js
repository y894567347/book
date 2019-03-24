//定义一些全局变量
var productQuantity=1;
var productId;

//获取用户名

$("#addCart").hide();

//把要用的组件写进来 其他JS都写在这个方法里
layui.use(['table','layer','slider','element','form'],function() {
    var table = layui.table,
        layer = layui.layer
        ,slider = layui.slider
        ,form=layui.form
        ,element = layui.element;


//初始化表格
    table.render({
        elem: '#productTable'
        , height: 316
        , width: 937
        ,limit:6
        , url: '/book/buyer/productlist' //数据接口
        , page: true//开启分页
        ,limits:[6,12,20,30]

        , cols: [[ //表头
            {field: 'productName', title: '书名', width: 150, align: 'center', sort: true}
            , {field: 'bookAuthor', title: '作者', align: 'center', width: 120}
            , {field: 'productPrice', title: '租金', align: 'center', width: 80,sort: true}
            , {field: 'productStock', title: '库存', width: 80, align: 'center', sort: true}
            , {field: 'productDescription', title: '描述', width: 300}
            , {tittle: '操作', width: 200, align: 'center', toolbar: '#booklistBar'}
        ]]

        , done: function (res, curr, count) {

        }
    });

    //绑定工具条 进行加入购物车 和查看图片操作
    table.on('tool(productListFilter)', function (obj) {

        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'detail') {

            var detailContent = "";
            detailContent += '<img width="250px" height="400px" src=' + data.productIcon + '>' + '</img>';
            layer.open({
                type: 1,
                title:'图片',
                content: detailContent
            })
        } else if (layEvent === 'addCart') {

                productId = data.productId;
                maxValue=data.productStock;

                    var ins1 = slider.render({
                        elem: '#productQuantity',
                        min: 1,
                        max: maxValue,
                        value: 1,
                        change: function (value) {
                            productQuantity = value;
                        },
                        input: true
                    });
                }
            $("#addCart").show();


    });

    table.on('row(productListFilter)', function(obj){
        var data = obj.data;
        layer.msg("请选择数量");
        productId = data.productId;
        maxValue=data.productStock;

        var ins1 = slider.render({
            elem: '#productQuantity',
            min: 1,
            max: maxValue,
            value: 1,
            change: function (value) {
                productQuantity = value;
            },
            input: true
        });
    $("#addCart").show();
    });

    //加入购物车点击方法
    $("#addCart").click(function () {
        $.get({
            url: '/book/buyer/cart/add?productId=' + productId + '&productQuantity=' + productQuantity
            ,success:function () {
                layer.msg("加入购物车成功");
                $("#addCart").hide();
            }
        })
    });


    //查看购物车方法
    $("#cartView").click(function () {

        window.location.href='/book/buyer/cart'
    });


    //下拉列表类目选择框
    form.on('select(categoryFilter)',function (data) {

            table.reload('productList',{
                elem: '#productTable'
                ,url:'/book/buyer/bycategoty?categoryType='+data.value
                , height: 316
                , width: 937
                ,limit:6
                , page: true//开启分页
                ,limits:[6,12,20,30]
                , cols: [[ //表头
                    {field: 'productName', title: '书名', width: 150, align: 'center', sort: true}
                    , {field: 'bookAuthor', title: '作者', align: 'center', width: 120}
                    , {field: 'productPrice', title: '租金', align: 'center', width: 80}
                    , {field: 'productStock', title: '库存', width: 80, align: 'center', sort: true}
                    , {field: 'productDescription', title: '描述', width: 300, sort: true}
                    , {tittle: '操作', width: 200, align: 'center', toolbar: '#booklistBar'}
                ]]

            })
    });

});








