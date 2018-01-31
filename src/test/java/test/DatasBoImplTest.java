package test;

import com.bamboo.bo.DatasBo;
import com.bamboo.bo.impl.DatasBoImpl;
import com.bamboo.vo.Datas;
import com.bamboo.web.DatasController;
import com.common.util.DateUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DecimalFormat;
import java.util.Date;

/**
 * @author wangzi
 * @date 18/1/25 上午5:47.
 */
public class DatasBoImplTest {

    private ApplicationContext classPathXmlApplicationContext;
    private DatasBoImpl datasBoImpl;

    @Before
    public void init() {
        String[] strings = {"classpath:spring/applicationContext-dao.xml", "classpath:spring/applicationContext-service.xml", "classpath:spring/applicationContext-trans.xml", "classpath:spring/springmvc.xml", "classpath:mybatis/sqlMapConfig.xml"};
        classPathXmlApplicationContext = new ClassPathXmlApplicationContext(strings);
        // datasBoImpl = (DatasBoImpl) classPathXmlApplicationContext.getBean("datasBoImpl");
    }

    /**
     * 得到1.00 - num.00的随机double数
     *
     * @param num
     * @return
     */
    public Double getRandom(int num) {
        double res = 0.0;
        DecimalFormat df = new DecimalFormat(".#");
        res = Double.parseDouble(df.format(num * Math.random()));
        return res;
    }


    @Test
    public void insert() {
//        DatasController test = classPathXmlApplicationContext.getBean(DatasController.class);
//        AreasInstrumentsBoImpl test = (AreasInstrumentsBoImpl) classPathXmlApplicationContext.getBean("areasInstrumentsBoImpl");
        DatasController datasController = classPathXmlApplicationContext.getBean(DatasController.class);
        DatasBo datasBo = datasController.getDatasBo();
        String dateStr = "2018-01-25";
        for (int i = 0; i < 800; i++) {
            Datas datas = new Datas();
            datas.setAirTemperature(getRandom(40));
            datas.setAirHumidity(getRandom(100));
            datas.setCarbonDioxide(getRandom(200));
            datas.setInsectDensity(getRandom(1000));
            datas.setSoilHumidity(getRandom(200));
            datas.setSoilTemperature(getRandom(40));
            dateStr = DateUtil.getDateStringFromStrDayAdd(DateUtil.y_m_dFormat, dateStr, -1);
            Date date = DateUtil.getDateFromStr(DateUtil.y_m_dFormat, dateStr);
            String time = "";
            String hour = (int) (Math.random() * 23) + "";
            if (hour.length() == 1) {
                hour = "0" + hour;
            }
            String minute = (int) (Math.random() * 59) + "";
            if (minute.length() == 1) {
                minute = "0" + minute;
            }
            String second = (int) (Math.random() * 59) + "";
            if (second.length() == 1) {
                second = "0" + second;
            }
            time += hour + ":" + minute + ":" + second;
            datas.setDateTime(dateStr + " " + time);
//            System.out.println(datas);
            datasBo.insertDatas(datas);
        }
    }
}
