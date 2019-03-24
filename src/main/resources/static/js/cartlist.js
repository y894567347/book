
var totalPrice=0.0;
var data;
function totalPriceCal(data)
{
    totalPrice=0.0;
    if (data ===null)
        return ;
    for(var i = 0; i< data.length; i++){
        var price=data[i].productQuantity*data[i].productPrice;
        totalPrice+=price;
    }
    return totalPrice;
}

layui.use(['table'],function () {
   var table = layui.table;


   table.render({

       elem:'#cartTable'
       ,url:'/book/buyer/cart/view'
       ,height:400
       ,width:555
       ,limit:5
       ,page:false
       ,limits:[5,10,15,20]
       ,cols:[[
           {field: 'productName', title: '书名', width: 250, align: 'center', sort: true}
           ,{field: 'productQuantity', title: '数量', width: 100, align: 'center', sort: true}
           ,{field: 'productPrice', title: '租金', width: 100, align: 'center', sort: true}
           , {tittle: '操作', width: 100, align: 'center', toolbar: '#cartBar'}
       ]]
       ,done:function (res) {

           data = res.data;
           totalPrice = totalPriceCal(data);
           $("#totalPrice").text(totalPrice);
       }
   });


    table.on('tool(cartListFilter)',function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if(layEvent ==='delCart'){
            obj.del();
            $.get({
                url:'/book/buyer/cart/del?productId='+data.productId
            });
            //重载表格  重新获取总价
            table.reload('cartTable',{
                done:function (res) {
                    totalPrice = totalPriceCal(res.data);
                    console.log(totalPrice);
                    $("#totalPrice").text(totalPrice);
                }
            });
        }
    });

});
$("#buyButton").click(function () {
    if(totalPrice === 0){
        layer.msg("你的购物车为空,无法提交");
    }
    else{
        layer.open({

            title: '填写个人信息',
            type: 1,
            content:$("#buyerInfoForm"),
            btn:['确认'],
            btn1:function (index) {
                var testPhone = /^1(3|4|5|7|8)\d{9}$/
                var buyerPhone = $("#buyerPhone").val();
                if(!testPhone.test(buyerPhone)){
                   layer.msg("手机号格式不正确");
                }
                else {
                    $.post({
                        url: "/book/buyer/order/create?totalPrice=" + totalPrice,
                        data: $("#buyerInfoForm").serialize(),
                        success: function (data) {
                            totalPrice = 0.0;
                            window.location.href = "/book/buyer/pay"
                        }
                    })
                }
            }
        })
    }
});
