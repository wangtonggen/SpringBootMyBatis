
var layer = layui.layer;
var loading;
function showLoading(message,icon,shade) {
    loading = layer.load(message,{
        icon:icon,
        shade:shade
    })
}

function cancelLoading() {
    if (loading != null){
        layer.close(loading)
    }
}