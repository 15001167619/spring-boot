/**
 * 测试管理初始化
 */
var Aaa = {
    id: "AaaTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Aaa.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '', field: 'name', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Aaa.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Aaa.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加测试
 */
Aaa.openAddAaa = function () {
    var index = layer.open({
        type: 2,
        title: '添加测试',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/aaa/aaa_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看测试详情
 */
Aaa.openAaaDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '测试详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/aaa/aaa_update/' + Aaa.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除测试
 */
Aaa.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/aaa/delete", function (data) {
            Feng.success("删除成功!");
            Aaa.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("aaaId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询测试列表
 */
Aaa.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Aaa.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Aaa.initColumn();
    var table = new BSTable(Aaa.id, "/aaa/list", defaultColunms);
    table.setPaginationType("client");
    Aaa.table = table.init();
});
