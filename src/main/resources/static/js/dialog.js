

/**
 * 显示loading
 * @param message
 * @param icon
 * @param shade
 */
function showLoading(message,icon,shade) {
    layer.load(message,{
        icon:icon,
        shade:shade
    })
}

/**
 * 隐藏loading
 */
function cancelLoading() {
    if (dialog != null){
        layer.close(dialog)
    }
}

/**
 * 显示toast
 * @param message
 */
function showToast(message) {
    layer.msg(message);
}

function showAlert() {
    layer.open("我是提示框",{ icon: 6, title: "提示", offset: "auto", skin: "layui-layer-molv"});
}