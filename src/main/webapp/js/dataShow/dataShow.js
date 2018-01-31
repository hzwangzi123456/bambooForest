/**
 * Created by ziwang on 17/10/26.
 */
var resdata = null;//数据数组
var user = null;
var prefix = null;
//
// //所属省份绑定改变事件
// $('#select01')
//     .change(
//         function () {
//             doAjaxSyn(
//                 PROJECT_NAME
//                 + "/AuthorityAreasController/findAuthorityAreasByPojo.do",
//                 {
//                     province: $('#select01').val(),
//                     username: user.username
//                 },
//                 function (data) {
//                     var redata = strToJson(data);
//                     if (redata == null) {
//                         console.log("后台未发送ajax响应");
//                         return;
//                     }
//                     if ("isSucced" in redata == true
//                         && redata.isSucced == false) {
//                         console.log(redata.msg);
//                         return;
//                     }
//                     $('#select02').html('');
//                     var html = '<option value="" class="" selected="selected">请选择</option>';
//                     for (var i = 0; i < redata.length; i++) {
//                         html += '<option label="' + redata[i].extra
//                             + '" value="' + redata[i].prefix
//                             + '">' + redata[i].extra
//                             + '</option>';
//                     }
//                     $('#select02').append(html);
//                 });
//         });
//
// // 所属地区绑定改变事件
// $('#select02')
//     .change(
//         function () {
//             doAjaxSyn(
//                 PROJECT_NAME
//                 + "/AreasInstrumentsController/findAreasInstrumentsByPojo.do",
//                 {
//                     prefix: $('#select02').val()
//                 },
//                 function (data) {
//                     var redata = strToJson(data);
//                     if (redata == null) {
//                         console.log("后台未发送ajax响应");
//                         return;
//                     }
//                     if ("isSucced" in redata == true
//                         && redata.isSucced == false) {
//                         console.log(redata.msg);
//                         return;
//                     }
//                     $('#select03').html('');
//                     var html = '<option value="" class="" selected="selected">请选择</option>';
//                     for (var i = 0; i < redata.length; i++) {
//                         html += '<option label="'
//                             + redata[i].instrumentId
//                             + '" value="'
//                             + redata[i].instrumentId + '">'
//                             + redata[i].instrumentId
//                             + '</option>';
//                     }
//                     $('#select03').append(html);
//                 });
//         });

//根据设备id,开始时间,结束时间请求后台数据
function getChartDatas(start, end) {
    var redata = null;
    doAjaxSyn(PROJECT_NAME + "/DatasController/findDatasByPojo.do",
        {
            startTimeTIMESTAMP: start + ' 00:00:00',
            endTimeTIMESTAMP: end + ' 23:59:59',
        }, function (data) {
            //  debugger
            redata = strToJson(data);
            // console.log(redata);
        });
    if (!judgeAjaxData(redata)) {
        return null;
    }
    return redata;
}

$('#reload').click(function () {
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
    resdata = null;
    resdata = getChartDatas(start, end);
    // debugger;
    if (resdata == null) {
        alert("未找到数据");
        return;
    }
    //点击单图按钮
    $($(".single-button")[0]).trigger("click");
    //single显现
    $(".singlebox").show();
    //multip显示,不然echarts.init会获取不到dom的宽和高
    $(".mutiplebox").show();
    disposeFun();
    initFun();
    //multiple隐藏
    $(".mutiplebox").hide();
});

//销毁所有echarts实例
function disposeFun() {
    $(".colorful-tab-content").each(function () {
        echarts.dispose(this);
    });
}

//初始化echarts实例
function initFun() {
    if (resdata == null) {
        alert("未找到数据");
        return;
    }
    $(".colorful-tab-content").each(function () {
        initColor(resdata, this);
    });
}

//初始化图表(数据,dom,单位)
function initColor(arr, dom, unit) {
    var $object = $(dom);
    var mychart = echarts.init(dom);
    option02.xAxis[0].data = getDateTime(arr);
    if ($object.attr('id') == "airHumidity" || $object.attr('id').trim() == "airHumiditychart-airHumidity") {
        //y轴的名字
        option02.yAxis.name = '';
        option02.legend = {data: ['空气湿度']};
        option02.series = [{
            name: '空气湿度',
            type: 'line',
            stack: 'airHumidity值',
            data: new Array()
        }];
        option02.series[0].data = getAirHumidity(arr);
    } else if ($object.attr('id') == "airTemperature" || $object.attr('id').trim() == "airTemperaturechart-airTemperature") {
        //y轴的名字
        option02.yAxis.name = 'T(℃)';
        option02.legend = {data: ['空气温度']};
        option02.series = [{
            name: '空气温度',
            type: 'line',
            stack: 'T(℃)',
            data: new Array()
        }];
        option02.series[0].data = getAirTemperature(arr);
    } else if ($object.attr('id') == "carbonDioxide" || $object.attr('id').trim() == "carbonDioxidechart-carbonDioxide") {
        //y轴的名字
        option02.yAxis.name = 'us/cm';
        option02.legend = {data: ['二氧化碳含量']};
        option02.series = [{
            name: '二氧化碳含量',
            type: 'line',
            stack: 'CDT(us/cm)',
            data: new Array()
        }];
        option02.series[0].data = getCarbonDioxide(arr);
    } else if ($object.attr('id') == "insectDensity" || $object.attr('id').trim() == "insectDensitychart-insectDensity") {
        //y轴的名字
        option02.yAxis.name = '';
        option02.legend = {data: ['虫口密度']};
        option02.series = [{
            name: '虫口密度',
            type: 'line',
            stack: 'N(mg/L)',
            data: new Array()
        }];
        option02.series[0].data = getInsectDensity(arr);
    } else if ($object.attr('id') == "soilHumidity" || $object.attr('id').trim() == "soilHumiditychart-soilHumidity") {
        //y轴的名字
        option02.yAxis.name = 'mg/L';
        option02.legend = {data: ['土壤湿度']};
        option02.series = [{
            name: '土壤湿度',
            type: 'line',
            stack: 'DO(mg/L)',
            data: new Array()
        }];
        option02.series[0].data = getSoilHumidity(arr);
    } else if ($object.attr('id') == "soilTemperature" || $object.attr('id').trim() == "soilTemperaturechart-soilTemperature") {
        //y轴的名字
        option02.yAxis.name = '';
        option02.legend = {data: ['土壤温度']};
        option02.series = [{
            name: '土壤温度',
            type: 'line',
            stack: 'soilTemperature',
            data: new Array()
        }];
        option02.series[0].data = getSoilTemperature(arr);
        // } else if ($object.attr('id') == "P" || $object.attr('id').trim() == "Pchart-P") {
        //     //y轴的名字
        //     option02.yAxis.name = 'mg/L';
        //     option02.legend = {data: ['总磷']};
        //     option02.series = [{
        //         name: '总磷',
        //         type: 'line',
        //         stack: 'P(mg/L)',
        //         data: new Array()
        //     }];
        //     option02.series[0].data = getP(arr);
    }
    if (unit != "" && unit != null) {
        option.series[0].name += "(" + unit + ")";
    }
    mychart.setOption(option02);
    return mychart;
}


//向上按钮绑定点击事件
$(".top").click(function () {
    var tot = $(document).scrollTop();
    var timer = setInterval(function () {
        tot -= 50;
        if (tot <= 0) {
            $(document).scrollTop(0);
            clearTimeout(timer);
            return;
        }
        $(document).scrollTop(tot);
    }, 15);
});

//切换单和多图
$(".single-button").click(function () {
    $(this).siblings(".single-button").removeClass("button-green");
    $(this).addClass("button-green");
    var text = $(this).text();
    if (text.trim() == "单图") {
        $(".singlebox").show();
        $(".mutiplebox").hide();
    } else {
        $(".singlebox").hide();
        $(".mutiplebox").show();
    }
});

// 得到空气湿度数组
function getAirHumidity(obj) {
    var airHumidity = new Array();
    for (var i = 0; i < obj.length; i++)
        airHumidity[i] = obj[i].airHumidity;
    return airHumidity;
}

// 得到二氧化碳数组
function getCarbonDioxide(obj) {
    var carbonDioxide = new Array();
    for (var i = 0; i < obj.length; i++)
        carbonDioxide[i] = obj[i].carbonDioxide;
    return carbonDioxide;
}

// 得到空气温度数组
function getAirTemperature(obj) {
    var airTemperature = new Array();
    for (var i = 0; i < obj.length; i++)
        airTemperature[i] = obj[i].airTemperature;
    return airTemperature;
}

// 得到虫口密度数组
function getInsectDensity(obj) {
    var insectDensity = new Array();
    for (var i = 0; i < obj.length; i++)
        insectDensity[i] = obj[i].insectDensity;
    return insectDensity;
}

// 得到溶解氧数组
function getSoilHumidity(obj) {
    var soilHumidity = new Array();
    for (var i = 0; i < obj.length; i++)
        soilHumidity[i] = obj[i].soilHumidity;
    return soilHumidity;
}

// 得到土壤温度数组
function getSoilTemperature(obj) {
    var soilTemperature = new Array();
    for (var i = 0; i < obj.length; i++)
        soilTemperature[i] = obj[i].soilTemperature;
    return soilTemperature;
}

// // 得到总磷数组
// function getP(obj) {
//     var P = new Array();
//     for (var i = 0; i < obj.length; i++)
//         P[i] = obj[i].p;
//     return P;
// }

//得到日期
function getDateTime(obj) {
    var date_time = new Array();
    for (var i = 0; i < obj.length; i++) {
        var dateString = obj[i].dateTime.substring(0, obj[i].dateTime.length - 2);
        var year = dateString.substring(0, 4);
        var month = dateString.substring(5, 7);
        var day = dateString.substring(8, 10);
        var hour = dateString.substring(11, 13);
        var minute = dateString.substring(14, 16);
        var second = dateString.substring(17, 19);
        date_time[i] = month + '月' + day + '日' + hour + ':' + minute;
    }
    return date_time;
}

$(function () {
    doAjaxSyn(PROJECT_NAME + "/UserController/findSessionByLogin.do", {}, function (data) {
        var redata = strToJson(data);
        if (!judgeAjaxData(redata)) {
            window.location.href = PROJECT_NAME + INDEX_NAME;
            return;
        }
    });
    var mtree = $('ul.mtree');
    mtree.addClass('jet');
    $("#colorful-elliptic").colorfulTab({
        theme: "elliptic"
    });
    $("#colorful-elliptic-airHumidity").colorfulTab({
        theme: "elliptic"
    });
    $("#colorful-elliptic-airTemperature").colorfulTab({
        theme: "elliptic"
    });
    $("#colorful-elliptic-insectDensity").colorfulTab({
        theme: "elliptic"
    });
    // $("#colorful-elliptic-P").colorfulTab({
    //     theme: "elliptic"
    // });
    $("#colorful-elliptic-carbonDioxide").colorfulTab({
        theme: "elliptic"
    });
    $("#colorful-elliptic-soilHumidity").colorfulTab({
        theme: "elliptic"
    });
    $("#colorful-elliptic-soilTemperature").colorfulTab({
        theme: "elliptic"
    });
    //向后台发送ajax请求
    $(".header").load("../controllerCommon/header.html");
    $(".nav").load("../controllerCommon/nav.html");


});