/**
 * Created by ziwang on 18/1/27.
 */
//定义一个全局变量
// var obj = {
//     search: function () {
//         alert("1");
//     },
// };
//
$(".main-excel").click(function () {

    var start = $('#start').val();
    if (start == null || start == '') {
        alert('请选择起始时间');
        return;
    }
    start = start.replace('年', '-');
    start = start.replace('月', '-');
    start = start.replace('日', '');
    var end = $('#end').val();
    if (end == null || end == '') {
        alert('请选择结束时间');
        return;
    }
    end = end.replace('年', '-');
    end = end.replace('月', '-');
    end = end.replace('日', '');
    if (start > end) {
        alert('起始时间不能大于结束时间');
        return;
    }
    // doAjaxGET(PROJECT_NAME + "/DatasController/generateExcel.do", {
    //     startTimeTIMESTAMP: start + ' 00:00:00',
    //     endTimeTIMESTAMP: end + ' 23:59:59'
    // }, function (data) {
    //     console.log(data);
    // });
    start += ' 00:00:00';
    end += ' 23:59:59';
    $("#excel-form").show();
    var attrObj = {"action": PROJECT_NAME + "/DatasController/generateExcel.do", "target": "_blank", "method": "post"};
    $("#excel-form").attr(attrObj);
    $("#excel-form").html('');
    var html = '<input id = "excel-form-input01" name = "startTimeTIMESTAMP">';
    html += '<input id = "excel-form-input02" name = "endTimeTIMESTAMP">';
    html += '<input type="submit" value="Send Request">'
    $("#excel-form").append(html);
    $("#excel-form-input01").val(start);
    $("#excel-form-input02").val(end);
    $("#excel-form").submit();
    $("#excel-form").hide();
});

/**
 * 加载按钮点击事件
 */
$("#reload").click(function () {

    //使用jQuery [attribute=value] 选择器
    console.log($('input[name="start"]').val());
    console.log($('input[name="end"]').val());

    var start = $('#start').val();
    if (start == null || start == '') {
        alert('请选择起始时间');
        return;
    }
    start = start.replace('年', '-');
    start = start.replace('月', '-');
    start = start.replace('日', '');
    var end = $('#end').val();
    if (end == null || end == '') {
        alert('请选择结束时间');
        return;
    }
    end = end.replace('年', '-');
    end = end.replace('月', '-');
    end = end.replace('日', '');
    if (start > end) {
        alert('起始时间不能大于结束时间');
        return;
    }
    $("#show-box").datagrid("load", {
        startTimeTIMESTAMP: start + ' 00:00:00',
        endTimeTIMESTAMP: end + ' 23:59:59',
    });
});

$(function () {
    //它才会在全局对象（即当前作用域链的最顶层对象，如window对象）中创造num属性并赋值。
    obj = {
        search: function () {
            alert(11);
        },
    };
    doAjaxSyn(PROJECT_NAME + "/UserController/findSessionByLogin.do", {}, function (data) {
        var redata = strToJson(data);
        if (!judgeAjaxData(redata)) {
            window.location.href = PROJECT_NAME + INDEX_NAME;
            return;
        }

    });
    //向后台发送ajax请求
    $(".header").load("../controllerCommon/header.html");
    $(".nav").load("../controllerCommon/nav.html");

    $("#show-box").datagrid({
        url: PROJECT_NAME + "/DatasController/findDatasByPage.do",
        left: 20,
        title: '数据表格显示',
        iconCls: 'icon-search',
        //显示斑马线效果
        striped: true,
        //自适应
        fitColumns: true,
        //加载信息
        loadMsg: '正在加载数据。。。。。',
        //显示行号
        rownumbers: true,
        //单选
        singleSelect: true,
        //记录行style设置函数
        rowStyler: function (index, row) {
            // if (row.airTemperature > 20) {
            //     return "background-color:orange";
            // }
        },
        //引入工具栏
        toolbar: '#tb',
        columns: [[
            {
                field: 'id',
                title: '数据id',
                sortable: true,
                width: 100,
                align: "center",
            },
            {
                field: 'dateTime',
                title: '数据日期',
                sortable: true,
                width: 200,
                align: "center",
            },
            {
                field: 'airTemperature',
                title: '空气温度',
                sortable: true,
                width: 100,
                align: "center",
            },
            {
                field: 'airHumidity',
                title: '空气湿度',
                sortable: true,
                width: 100,
                align: "center",
            },
            {
                field: 'carbonDioxide',
                title: '二氧化碳含量',
                sortable: true,
                width: 100,
                align: "center",
            },
            {
                field: 'soilTemperature',
                title: '土壤温度',
                sortable: true,
                width: 100,
                align: "center",
            },
            {
                field: 'soilHumidity',
                title: '土壤湿度',
                sortable: true,
                width: 100,
                align: "center",
            },
            {
                field: 'insectDensity',
                title: '虫口密度',
                sortable: true,
                width: 100,
                align: "center",
            }
        ]],
        pagination: true,
        pageSize: 10,
        pageList: [10, 20, 30, 40, 50, 60],
        sortName: 'date_time',
        sortOrder: 'ASC',
    });

});
