/*user.js 来处理用户的业务逻辑比如登录,退出 */

/**
 * 登录操作
 * @param account 账号
 * @param password 密码
 * @param callback 回调
 */
function login(account, password, callback) {
    $.post('/login', {
        account: account,
        password: password
    }, callback, "json");
}


function updateUserInfo(User,callback) {

}

/**
 * 退出登录
 * @param account 账号
 */
function logout(account,callback) {

}

