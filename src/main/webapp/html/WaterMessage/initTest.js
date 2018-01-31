/**
 * Created by ziwang on 18/1/18.
 */
//边框描点结构体
function point(x, y) {
    this.x = x;
    this.y = y;
}

//距离结构体
function distant(dis, col) {
    this.dis = dis;
    this.col = col;
}

//站点信息
var Zhan = new Array();
var ZhanCol = new Array();
Zhan[0] = new point(381, 115);
ZhanCol[0] = 0;//0
Zhan[1] = new point(581, 147);
ZhanCol[1] = 16;//16
Zhan[2] = new point(732, 136);
ZhanCol[2] = 90;//90
Zhan[3] = new point(704, 271);
ZhanCol[3] = 5;//5
Zhan[4] = new point(613, 353);
ZhanCol[4] = 25;//25
Zhan[5] = new point(495, 471);
ZhanCol[5] = 69;//69
Zhan[6] = new point(367, 392);
ZhanCol[6] = 52;//5
Zhan[7] = new point(257, 250);
ZhanCol[7] = 14;//14

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

