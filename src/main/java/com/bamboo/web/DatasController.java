package com.bamboo.web;

import com.alibaba.fastjson.JSON;
import com.bamboo.bo.GenericService;
import com.bamboo.vo.Datas;
import com.common.base.BaseController;
import com.common.util.ExportExcelUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * @author wangzi
 * @date 18/1/25 上午5:23.
 */
@Controller
@Scope("prototype")
@RequestMapping("/DatasController")
public class DatasController extends BaseController {
    private static Logger logger = Logger
            .getLogger(DatasController.class);


    /**
     * 注入业务接口层
     **/
    @Autowired
    private GenericService<Datas> genericService;

    /**
     * 定义参数
     **/
    private Datas datas;

    @ModelAttribute
    public void setParaVal(Datas datas) {
        this.datas = datas;
        System.out.println(JSON.toJSONString(datas).toString());
    }

    public Map getPojoMap() {
        Map map = new HashMap<String, Object>();
        map.put("airTemperature", datas.getAirTemperature());
        map.put("airHumidity", datas.getAirHumidity());
        map.put("carbonDioxide", datas.getCarbonDioxide());
        map.put("soilTemperature", datas.getSoilTemperature());
        map.put("soilHumidity", datas.getSoilHumidity());
        map.put("insectDensity", datas.getInsectDensity());
        map.put("dateTime", datas.getDateTime());
        map.put("startTimeTIMESTAMP", datas.getStartTimeTIMESTAMP());
        map.put("endTimeTIMESTAMP", datas.getEndTimeTIMESTAMP());
        return map;
    }

    @RequestMapping("/insert.do")
    public void insert() {
        if (datas == null) {
            setFailure("未接受到数据");
            return;
        }
        if (datas.getAirHumidity() == null) {
            setFailure("未设置空气湿度");
            return;
        }
        if (datas.getAirTemperature() == null) {
            setFailure("未设置空气温度");
            return;
        }
        if (datas.getCarbonDioxide() == null) {
            setFailure("未设置二氧化碳含量");
            return;
        }
        if (datas.getInsectDensity() == null) {
            setFailure("未设置虫口密度");
            return;
        }
        if (datas.getSoilHumidity() == null) {
            setFailure("未设置土壤湿度");
            return;
        }
        if (datas.getSoilTemperature() == null) {
            setFailure("未设置土壤温度");
            return;
        }
        try {
            int res = genericService.insert(datas);
            if (res == 1) {
                setSuccess("插入一条记录");
            } else {
                setFailure("插入失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
        }
    }

    @RequestMapping("/findCountByVo.do")
    public void findCountByVo() {
        try {
            Integer i = genericService.findCountByVo(datas);
            System.out.println(i);
            setAjaxMsg(i.toString());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
        }
    }

    @RequestMapping("/findByPojo.do")
    public void findDatasByPojo() {
        try {
            List<Datas> list = genericService.findByPojo(datas);
            setAjaxObject(list);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
        }
    }

    @RequestMapping("/findByPage.do")
    public void findByPage() {
        try {
            Integer cnt = genericService.findCountByVo(datas);
            getPageUtil().setTotal(cnt);
            List<Datas> list = null;
            if (cnt > 0) {
                Map schMap = getSchMap();
                schMap.putAll(getPojoMap());
                list = genericService.findByPage(schMap);
                setAjaxGridData(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
        }
    }

    @RequestMapping(value = "/generateExcel.do")
    public void gengerateExcel() {
        try {
            //定义导出excel的名字
            String excelName = "竹林数据表" + datas.getStartTimeTIMESTAMP().substring(0, 10) + "to" + datas.getEndTimeTIMESTAMP().substring(0, 10);

            //得到所要导出的数据
            List<Datas> list = genericService.findByPojo(datas);

            // 获取需要转出的excle表头的map字段
            LinkedHashMap<String, String> fieldMap = new LinkedHashMap<String, String>();
            fieldMap.put("airTemperature", "空气温度");
            fieldMap.put("airHumidity", "空气湿度");
            fieldMap.put("carbonDioxide", "二氧化碳含量");
            fieldMap.put("soilTemperature", "土壤温度");
            fieldMap.put("soilHumidity", "土壤湿度");
            fieldMap.put("insectDensity", "虫口密度");
            fieldMap.put("dateTime", "日期");


            ExportExcelUtils.export(excelName, list, fieldMap, response);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
        }

    }
}
