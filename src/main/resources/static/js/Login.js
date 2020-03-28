$(function () {
    $("#btn_login").click(function () {
        showLoading("加载中...",2,0.1);
        $.post('/login',{
            account:$("#account").val(),
            password:$("#password").val()
        },function(data,status){
            if (data.code === 1){
                 let account = data.data.user_account;
                alert("成功\n数据："+account+"---"+"\n状态："+status)
            }else {
                alert("失败\n数据："+data.msg+"---"+"\n状态："+status)
            }
            cancelLoading()
        },"json");
    });
});

