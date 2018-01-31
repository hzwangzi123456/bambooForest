<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript">
        var nowAQI = 155;
    </script>
    <style type="text/css">
        #allmap {
            width: 980px;
            height: 550px;
        }
    </style>

</head>

<body>
<table id="ALL">
    <tr id="biaoti">
        <td style="height:50px;width:180px;"></td>
        <td style="width:970px;background-color:#EEEEEE;text-align: center;">
				<span style="color:black;font-size:40px;font-weight:bold;">
					浙江农林大学监测点 </span></td>

    </tr>

    <tr id="six">
        <td style="height:530px;width:180px;"></td>
        <td style="width:970px">
            <canvas id="myCanvas" width="960px"
                    height="530px"></canvas>
            <div
                    style="position:absolute;width:970px;height:530px;left:194px;top:60px;">
                <div id="toolTip" style="position:fixed;background-color:white;"
                     onmouseleave='hideToolTip()'></div>
                <!-- <table >
<tr ><td style="height:90px;width:360px;"></td>
<td></td>
</tr>
<tr><td style="height:30px;width:360px;">
<td><img  src="img/sBig1.png" height="29px" width="30px" onclick="showToolTip('站点1','水质良好',event);" />   </td>
</tr>
</table> 
-->
            </div>
        </td>
    </tr>
</table>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/WaterMessage/tooltip.js"></script>
<script type="text/javascript">
    //init();
    //边框描点结构体
    function point(x, y) {
        this.x = x;
        this.y = y;
    }

    function spoint(x, y, z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    //距离结构体
    function distant(dis, col) {
        this.dis = dis;
        this.col = col;
    }

    //站点信息
    var Zhan = new Array();
    var ZhanCol = new Array();
    Zhan[0] = new spoint(381, 115, 0);
    ZhanCol[0] = 0;
    Zhan[1] = new spoint(581, 147, 0);
    ZhanCol[1] = 16;
    Zhan[2] = new spoint(732, 136, 0);
    ZhanCol[2] = 90;
    Zhan[3] = new spoint(704, 271, 0);
    ZhanCol[3] = 5;
    Zhan[4] = new spoint(613, 353, 0);
    ZhanCol[4] = 25;
    Zhan[5] = new spoint(495, 471, 0);
    ZhanCol[5] = 69;
    Zhan[6] = new spoint(367, 392, 0);
    ZhanCol[6] = 52;
    Zhan[7] = new spoint(257, 250, 0);
    ZhanCol[7] = 14;

    Zhan[8] = new spoint(451, 155, 150);
    ZhanCol[8] = 25;
    Zhan[9] = new spoint(695, 192, 150);
    ZhanCol[9] = 60;
    Zhan[10] = new spoint(645, 296, 150);
    ZhanCol[10] = 95;
    Zhan[11] = new spoint(515, 388, 150);
    ZhanCol[11] = 35;
    Zhan[12] = new spoint(353, 361, 150);
    ZhanCol[12] = 15;
    Zhan[13] = new spoint(295, 279, 150);
    ZhanCol[13] = 79;
    Zhan[14] = new spoint(366, 212, 150);
    ZhanCol[14] = 68;
    //边框的点
    var i, j, ymin, ymax, m;
    var _Data = new Array();
    _Data[0] = new point(380, 114);
    _Data[1] = new point(401, 115);
    _Data[2] = new point(432, 121);
    _Data[3] = new point(458, 128);
    _Data[4] = new point(469, 129);
    _Data[5] = new point(476, 134);
    _Data[6] = new point(489, 134);
    _Data[7] = new point(519, 142);
    _Data[8] = new point(557, 152);
    _Data[9] = new point(569, 153);
    _Data[10] = new point(600, 145);
    _Data[11] = new point(619, 136);
    _Data[12] = new point(633, 125);
    _Data[13] = new point(647, 110);
    _Data[14] = new point(663, 92);
    _Data[15] = new point(673, 84);
    _Data[16] = new point(697, 79);
    _Data[17] = new point(713, 81);
    _Data[18] = new point(725, 90);
    _Data[19] = new point(734, 107);
    _Data[20] = new point(740, 126);
    _Data[21] = new point(740, 135);
    _Data[22] = new point(733, 143);
    _Data[23] = new point(734, 153);
    _Data[24] = new point(740, 160);
    _Data[25] = new point(738, 176);
    _Data[26] = new point(730, 193);
    _Data[27] = new point(723, 219);
    _Data[28] = new point(722, 234);
    _Data[29] = new point(712, 257);
    _Data[30] = new point(706, 272);
    _Data[31] = new point(698, 307);
    _Data[32] = new point(667, 322);
    _Data[33] = new point(659, 330);
    _Data[34] = new point(653, 348);
    _Data[35] = new point(647, 355);
    _Data[36] = new point(612, 366);
    _Data[37] = new point(610, 357);
    _Data[38] = new point(603, 350);
    _Data[39] = new point(597, 358);
    _Data[40] = new point(595, 367);
    _Data[41] = new point(596, 375);
    _Data[42] = new point(589, 377);
    _Data[43] = new point(587, 371);
    _Data[44] = new point(581, 365);
    _Data[45] = new point(576, 363);
    _Data[46] = new point(574, 370);
    _Data[47] = new point(575, 377);
    _Data[48] = new point(577, 383);
    _Data[49] = new point(564, 391);
    _Data[50] = new point(559, 382);
    _Data[51] = new point(550, 378);
    _Data[52] = new point(548, 387);
    _Data[53] = new point(549, 394);
    _Data[54] = new point(553, 401);
    _Data[55] = new point(545, 408);
    _Data[56] = new point(540, 403);
    _Data[57] = new point(535, 400);
    _Data[58] = new point(529, 400);
    _Data[59] = new point(529, 409);
    _Data[60] = new point(532, 414);
    _Data[61] = new point(534, 419);
    _Data[62] = new point(527, 431);
    _Data[63] = new point(522, 429);
    _Data[64] = new point(516, 426);
    _Data[65] = new point(513, 426);
    _Data[66] = new point(513, 434);
    _Data[67] = new point(515, 440);
    _Data[68] = new point(519, 445);
    _Data[69] = new point(512, 459);
    _Data[70] = new point(508, 470);
    _Data[71] = new point(507, 479);
    _Data[72] = new point(470, 480);
    _Data[73] = new point(456, 459);
    _Data[74] = new point(441, 444);
    _Data[75] = new point(420, 425);
    _Data[76] = new point(393, 408);
    _Data[77] = new point(367, 397);
    _Data[78] = new point(336, 391);
    _Data[79] = new point(305, 377);
    _Data[80] = new point(275, 361);
    _Data[81] = new point(269, 340);
    _Data[82] = new point(266, 313);
    _Data[83] = new point(261, 287);
    _Data[84] = new point(255, 260);
    _Data[85] = new point(249, 245);
    _Data[86] = new point(236, 234);
    _Data[87] = new point(224, 220);
    _Data[88] = new point(215, 206);
    _Data[89] = new point(211, 192);
    _Data[90] = new point(214, 187);
    _Data[91] = new point(221, 193);
    _Data[92] = new point(228, 200);
    _Data[93] = new point(239, 214);
    _Data[94] = new point(254, 222);
    _Data[95] = new point(264, 225);
    _Data[96] = new point(278, 224);
    _Data[97] = new point(296, 217);
    _Data[98] = new point(310, 206);
    _Data[99] = new point(327, 194);
    _Data[100] = new point(340, 178);
    _Data[101] = new point(349, 161);
    _Data[102] = new point(355, 145);
    _Data[103] = new point(366, 131);
    _Data[104] = new point(376, 115);
    _Data[105] = new point(380, 114);
    _Data[106] = new point(401, 115);
    ymin = ymax = _Data[0].y
    for (i = 1; i <= 104; i++) {
        if (_Data[i].y > ymax)
            ymax = _Data[i].y;
        if (_Data[i].y < ymin)
            ymin = _Data[i].y;
    }
    //X轴扫描记录数组
    var pp = new Array(); //先声明一维
    for (i = 0; i < 500; i++) { //一维长度
        pp[i] = new Array(); //在声明二维
        for (j = 0; j < 10; j++) { //二维长度为5
            pp[i][j] = 0;
        }
    }
    var oldpp = new Array(); //先声明一维
    for (i = 0; i < 500; i++) { //一维长度
        oldpp[i] = new Array(); //在声明二维
        for (j = 0; j < 10; j++) { //二维长度为5
            oldpp[i][j] = 0;
        }
    }
    //X轴扫描交点数
    var kk = new Array();
    for (i = 0; i < 500; i++) {
        kk[i] = 0;
    }

    //X轴扫描交点数
    var oldkk = new Array();
    for (i = 0; i < 500; i++) {
        oldkk[i] = 0;
    }

    //X轴扫描求焦点
    for (i = ymin; i <= ymax; i++) {
        kk[i] = 0;
        for (j = 0; j < 105; j++) {
            if ((_Data[j].y < i && _Data[j + 1].y > i)
                    || (_Data[j].y > i && _Data[j + 1].y < i)) {
                x = (i - _Data[j].y) * (_Data[j + 1].x - _Data[j].x)
                        / (_Data[j + 1].y - _Data[j].y) + _Data[j].x;
                pp[i][kk[i]++] = x;
            }
            if (_Data[j + 1].y == i) {
                x = _Data[j + 1].x;
                if (i < _Data[j].y && i < _Data[j + 2].y) {
                    pp[i][kk[i]++] = x;
                    pp[i][kk[i]++] = x;
                } else if (i >= _Data[j].y && i >= _Data[j + 2].y) {
                } else
                    pp[i][kk[i]++] = x;
            }
        }

    }

    //每行交点排序
    var t;
    for (m = ymin; m <= ymax; m++) {
        for (i = 0; i < kk[m] - 1; i++) {
            for (j = i + 1; j < kk[m]; j++)
                if (pp[m][i] > pp[m][j]) {
                    t = pp[m][i];
                    pp[m][i] = pp[m][j];
                    pp[m][j] = t;
                }

        }
    }

    for (i = ymin; i <= ymax; i++) {
        oldkk[i] = kk[i];
        for (j = 0; j < kk[i]; j++) {
            oldpp[i][j] = pp[i][j];
        }
    }
    //var p1= new point ; var p2= new point ;
    //var PA= new point ; var PB= new point ; var P3= new point ;

    paint();
    //	var wwdis=new distant;

    function paint() {
        var c = document.getElementById("myCanvas");
        var context = c.getContext("2d");
        //context.beginPath();
        //context.strokeStyle ="blue";

        /* context.moveTo(_Data[0].x,_Data[0].y);
         for(i=1;i<=105;i++)  context.lineTo(_Data[i].x,_Data[i].y);
         context.closePath();context.stroke();
         context.fillStyle = "rgb(100,149,237)";
         context.fill();      */
        var m1, m2, num, wi, wj, wm, wm1, wm2;
        var lp = new spoint;
        var dis, col;
        var _Juli = new Array();
        var tt;//= new distant;
        wz = 100;
        for (wz = 0; wz < 96; wz += 6) {

            for (wi = ymin; wi <= ymax; wi++) {
                for (wj = 0; wj < kk[wi]; wj = wj + 2) {
                    for (wm = pp[wi][wj]; wm <= pp[wi][wj + 1]; wm = wm + 2) {

                        num = 0;
                        for (m1 = 0; m1 < 15 - 1; m1++) {
                            for (m2 = m1 + 1; m2 < 15; m2++) {
                                lp.x = wm;
                                lp.y = wi;
                                lp.z = wz;
                                _Juli[num] = new distant;
                                _Juli[num++] = GetNearestDistance(Zhan[m1],
                                        Zhan[m2], lp, m1, m2);
                                //  _Juli[num++]=new distant(wwdis.dis,wwdis.col);
                            }
                        }
                        var wk = 12;
                        for (m1 = 0; m1 < wk; m1++) {
                            for (m2 = m1 + 1; m2 < num; m2++) {
                                if (_Juli[m1].dis > _Juli[m2].dis) {
                                    tt = _Juli[m1].dis;
                                    _Juli[m1].dis = _Juli[m2].dis;
                                    _Juli[m2].dis = tt;
                                    tt = _Juli[m1].col;
                                    _Juli[m1].col = _Juli[m2].col;
                                    _Juli[m2].col = tt;

                                }
                            }
                        }
                        col = 0;
                        for (m1 = 0; m1 < wk; m1++)
                            col = col + _Juli[m1].col;
                        col = col / wk;
                        // col=_Juli[0].col;
                        context.beginPath();
                        // context.fillStyle="rgb(0,255,255)";
                        if (col <= 50) {
                            col = Math.floor(255 * 2 * col / 100);
                            context.fillStyle = "rgb(0,0," + col + ")";
                        } else {
                            col = col - 50;
                            col = Math.floor(255 * 2 * col / 100);
                            context.fillStyle = "rgb(0," + col + ",255)";
                        }

                        var wwdian = new point;
                        wwdian = sanZer(wm, wi, wz);
                        context.fillRect(wwdian.x, wwdian.y, 2, 2);
                    }

                }
            }

        }
        //收缩聚拢
        for (; wz <= 150; wz = wz + 6) {
            for (wi = ymin; wi <= ymax; wi++) {
                for (wj = 0; wj < oldkk[wi]; wj = wj + 2) {
                    wm1 = oldpp[wi][wj];
                    wm2 = oldpp[wi][wj + 1];
                    if (wm1 == -1)
                        continue;
                    else {

                        for (wm = wm1; wm <= wm2; wm = wm + 2) {

                            num = 0;
                            for (m1 = 0; m1 < 15 - 1; m1++) {
                                for (m2 = m1 + 1; m2 < 15; m2++) {
                                    lp.x = wm;
                                    lp.y = wi;
                                    lp.z = wz;
                                    _Juli[num] = new distant;
                                    _Juli[num++] = GetNearestDistance(Zhan[m1],
                                            Zhan[m2], lp, m1, m2);
                                    //  _Juli[num++]=new distant(wwdis.dis,wwdis.col);
                                }
                            }
                            var wk = 12;
                            for (m1 = 0; m1 < wk; m1++) {
                                for (m2 = m1 + 1; m2 < num; m2++) {
                                    if (_Juli[m1].dis > _Juli[m2].dis) {
                                        tt = _Juli[m1].dis;
                                        _Juli[m1].dis = _Juli[m2].dis;
                                        _Juli[m2].dis = tt;
                                        tt = _Juli[m1].col;
                                        _Juli[m1].col = _Juli[m2].col;
                                        _Juli[m2].col = tt;

                                    }
                                }
                            }
                            col = 0;
                            for (m1 = 0; m1 < wk; m1++)
                                col = col + _Juli[m1].col;
                            col = col / wk;
                            // col=_Juli[0].col;
                            context.beginPath();
                            // context.fillStyle="rgb(0,255,255)";
                            if (col <= 50) {
                                col = Math.floor(255 * 2 * col / 100);
                                context.fillStyle = "rgb(0,0," + col + ")";
                            } else {
                                col = col - 50;
                                col = Math.floor(255 * 2 * col / 100);
                                context.fillStyle = "rgb(0," + col + ",255)";
                            }

                            var wwdian = new point;
                            wwdian = sanZer(wm, wi, wz);
                            context.fillRect(wwdian.x, wwdian.y, 2, 2);
                        }

                        wm1 = wm1 + 2;
                        wm2 = wm2 - 2;
                        if (wm1 <= wm2) {
                            oldpp[wi][wj] = wm1;
                            oldpp[wi][wj + 1] = wm2;
                        } else {
                            oldpp[wi][wj] = -1;
                            oldpp[wi][wj + 1] = -1;
                        }

                    }
                }
            }
        }

    }

    function sanZer(x, y, z) {
        var dian = new point;
        dian.x = x - y / 2 * Math.cos(45 * Math.PI / 180);
        dian.y = z + y / 2 * Math.sin(45 * Math.PI / 180);
        return dian;

    }

    //function
    function GetPointDistance(p1, p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y)
                * (p1.y - p2.y) + (p1.z - p2.z) * (p1.z - p2.z));
    }
    function GetNearestDistance(PA, PB, P3, wm1, wm2) {
        var wwdis = new distant;
        var wwcol;
        //----------图2--------------------
        var a, b, c;
        a = GetPointDistance(PB, P3);
        if (a <= 0.00001) {
            wwcol = ZhanCol[wm2];
            wwdis.dis = 0.0;
            wwdis.col = wwcol;
            return wwdis;
        }

        b = GetPointDistance(PA, P3);
        if (b <= 0.00001) {
            wwcol = ZhanCol[wm1];
            wwdis.dis = 0.0;
            wwdis.col = wwcol;
            return wwdis;
        }
        c = GetPointDistance(PA, PB);
        if (c <= 0.00001) {
            wwcol = ZhanCol[wm2];
            wwdis.dis = a;
            wwdis.col = wwcol;
            return wwdis;
        }
        //如果PA和PB坐标相同，则退出函数，并返回距离
        //------------------------------

        if (a * a >= b * b + c * c) {//--------图3--------
            wwcol = ZhanCol[wm1];
            wwdis.dis = b;
            wwdis.col = wwcol;
            return wwdis;
        }//如果是钝角返回b
        if (b * b >= a * a + c * c) {//--------图4-------
            wwcol = ZhanCol[wm1];
            wwdis.dis = a;
            wwdis.col = wwcol;
            return wwdis;
        } //如果是钝角返回a

        //图1
        var l = (a + b + c) / 2; //周长的一半
        var s = Math.sqrt(l * (l - a) * (l - b) * (l - c)); //海伦公式求面积，也可以用矢量求
        var d = 2 * s / c;
        var dd = Math.sqrt(b * b - d * d);
        //wwcol=ZhanCol[wm1]*dd/c+ZhanCol[wm2]*(1-dd/c);
        wwcol = ZhanCol[wm1] + (ZhanCol[wm2] - ZhanCol[wm1]) * (dd / c);
        wwdis.dis = d;
        wwdis.col = wwcol;
        return wwdis;
    }
</script>
</body>
</html>