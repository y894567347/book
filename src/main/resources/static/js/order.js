
layui.use(['layer','table'],function () {

    var layer = layui.layer,
        table = layui.table;

    table.render({
        elem:'#orderTable'
        , height: 473
        , width: 987
        ,limit:10
        ,url:'/book/buyer/order/orderlist'
        ,page:true
        ,limits:[10,20,30]
        , cols: [[ //表头
            {field: 'orderId', title: '订单号', width: 240, align: 'center', sort: true}
            , {field: 'buyerName', title: '联系人', align: 'center', width: 120}
            , {field: 'buyerPhone', title: '电话', align: 'center', width: 150,sort: true}
            , {field: 'buyerAddress', title: '地址', width: 200, align: 'center', sort: true}
            , {field: 'orderAmount', title: '总价', width: 80, align: 'center'}
            , {tittle: '操作', width: 190, align: 'center', toolbar: '#orderListBar'}
        ]]
    });
    table.on('tool(orderListFilter)', function (obj){

        var data = obj.data;
        var layEvent = obj.event;
        if (layEvent === 'orderDetail') {
            var length = data.orderDetailList.length;
            var res= data.orderDetailList;
            var str = "";
            for(var i = 0; i<length ; i++){
                str+='<div style="margin-top: 20px">书名：'+res[i].productName+'<p>数量：'+res[i].productQuantity+'</p>'
                +'<p>租金：'+res[i].productPrice+'</p></div>';
            }
            layer.open({
                type:1,
                title:'订单详情',
                content:str
            })



        }
    });
});