$(function () {
    $("#btn_login").click(function () {
        let account = $("#account").val();
        let password = $("#password").val();
        if (isStringEmpty(account)){
            // showAlert()
            showToast("账号不能为空")
            return;
        }

        if (isStringEmpty(password)){
            showToast("密码不能为空")
            return;
        }
        showLoading("加载中...", 2, 0.1);
        login(account,password,function (data, status) {
            if (data.code === 1) {
                let account = data.data.user_account;
                showToast("登录成功");
                $("#show_account").text(account);
            } else {
                showToast("登录失败");
            }
        });
        cancelLoading();
    });
});

function login(account, password, callback) {
    $.post('/login', {
        account: account,
        password: password
    }, callback, "json");
}

