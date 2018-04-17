/**
 * 初始化测试详情对话框
 */
var AaaInfoDlg = {
    aaaInfoData : {}
};

/**
 * 清除数据
 */
AaaInfoDlg.clearData = function() {
    this.aaaInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
AaaInfoDlg.set = function(key, val) {
    this.aaaInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
AaaInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
AaaInfoDlg.close = function() {
    parent.layer.close(window.parent.Aaa.layerIndex);
}

/**
 * 收集数据
 */
AaaInfoDlg.collectData = function() {
    this
    .set('id')
    .set('name');
}

/**
 * 提交添加
 */
AaaInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/aaa/add", function(data){
        Feng.success("添加成功!");
        window.parent.Aaa.table.refresh();
        AaaInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.aaaInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
AaaInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/aaa/update", function(data){
        Feng.success("修改成功!");
        window.parent.Aaa.table.refresh();
        AaaInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.aaaInfoData);
    ajax.start();
}

$(function() {

});
