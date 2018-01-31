var xPos;
var yPos;
var num = 10;

/**
 * 显示对话框
 * @param title 对话框题目
 * @param msg 
 * @param evt
 */
function showToolTip(title, msg, evt) {
    if (evt) {
        var url = evt.target;
    } else {
        evt = window.event;
        var url = evt.srcElement;
    }
    xPos = evt.clientX;
    yPos = evt.clientY;

    var toolTip = document.getElementById("toolTip");
    toolTip.innerHTML = "<h1>"
        + title
        + "</h1>"
        + "<button onClick='showhidediv(one)' >内容一 </button>"
        + "<button onClick='showhidediv(two)' >内容二 </button>"
        + "<br>"
        + "<div id='one' style='display: ' >"
        + "氧气浓度值<br>"
        + "<table  border='2'>"
        + "<tr><td width='50px'>前天</td><td width='50px'>昨天</td><td width='50px'>今天</td></tr>"
        + "<tr><td>30</td><td>40</td><td>25</td></tr>" + "</table>"
        + "</div>" + "<div id='two' style='display:none ' >" + "今日水质： "
        + msg + "</div>"

        + "<button onclick='Tip()' >近24小时 </button>";
    toolTip.style.top = parseInt(yPos) + 2 + "px";
    toolTip.style.left = parseInt(xPos) + 2 + "px";
    toolTip.style.visibility = "visible";

}

/**
 * 对话框选择
 * @param id
 */
function showhidediv(id) {
    console.log(id);
    var ONE = document.getElementById("one");
    var TWO = document.getElementById("two");
    if (id == one) {
        if (ONE.style.display == 'none') {
            ONE.style.display = 'block';
            TWO.style.display = 'none';
        }
    } else {
        if (TWO.style.display == 'none') {
            TWO.style.display = 'block';
            ONE.style.display = 'none';
        }
    }

}

/**
 * 渲染水质变化图
 */
function Tip() {
    // hideToolTip();
    if (num >= 1) {
        num--;
        // console.log('函数执行了' + num + '次');
        // pic=3;
        ZhanCol[1] = num * 10;
        // nowAQI_2=70+num*10;
        // nowAQI_3=0+num*10;
        // showToolTip('站点1','水质良好','3',event);
        paint();
        setTimeout('Tip()', 500); // 2秒后重复执行
    } else
        num = 10;

}

/**
 * 隐藏对话框
 */
function hideToolTip() {
    var toolTip = document.getElementById("toolTip");
    toolTip.style.visibility = "hidden";
}


$(function () {
    Tip();
});