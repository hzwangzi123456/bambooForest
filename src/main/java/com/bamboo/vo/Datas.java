package com.bamboo.vo;

public class Datas {

    private Integer id;

    private Double airTemperature;

    private Double airHumidity;

    private Double carbonDioxide;

    private Double soilTemperature;

    private Double soilHumidity;

    private Double insectDensity;

    private String dateTime;

    /******************************************时间范围查询拓展属性*****************************************************/
    /**
     * 起始时间
     * 举例:2017-09-01 00:00:00
     */
    private String startTimeTIMESTAMP;

    /**
     * 起始时间
     * 举例:2017-09-01 00:00:00
     */
    private String endTimeTIMESTAMP;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Double getAirTemperature() {
        return airTemperature;
    }

    public void setAirTemperature(Double airTemperature) {
        this.airTemperature = airTemperature;
    }

    public Double getAirHumidity() {
        return airHumidity;
    }

    public void setAirHumidity(Double airHumidity) {
        this.airHumidity = airHumidity;
    }

    public Double getCarbonDioxide() {
        return carbonDioxide;
    }

    public void setCarbonDioxide(Double carbonDioxide) {
        this.carbonDioxide = carbonDioxide;
    }

    public Double getSoilTemperature() {
        return soilTemperature;
    }

    public void setSoilTemperature(Double soilTemperature) {
        this.soilTemperature = soilTemperature;
    }

    public Double getSoilHumidity() {
        return soilHumidity;
    }

    public void setSoilHumidity(Double soilHumidity) {
        this.soilHumidity = soilHumidity;
    }

    public Double getInsectDensity() {
        return insectDensity;
    }

    public void setInsectDensity(Double insectDensity) {
        this.insectDensity = insectDensity;
    }

    public String getStartTimeTIMESTAMP() {
        return startTimeTIMESTAMP;
    }

    public void setStartTimeTIMESTAMP(String startTimeTIMESTAMP) {
        this.startTimeTIMESTAMP = startTimeTIMESTAMP;
    }

    public String getEndTimeTIMESTAMP() {
        return endTimeTIMESTAMP;
    }

    public void setEndTimeTIMESTAMP(String endTimeTIMESTAMP) {
        this.endTimeTIMESTAMP = endTimeTIMESTAMP;
    }

    @Override
    public String toString() {
        return "Datas{" +
                "airTemperature=" + airTemperature +
                ", airHumidity=" + airHumidity +
                ", carbonDioxide=" + carbonDioxide +
                ", soilTemperature=" + soilTemperature +
                ", soilHumidity=" + soilHumidity +
                ", insectDensity=" + insectDensity +
                ", dateTime='" + dateTime + '\'' +
                ", startTimeTIMESTAMP='" + startTimeTIMESTAMP + '\'' +
                ", endTimeTIMESTAMP='" + endTimeTIMESTAMP + '\'' +
                '}';
    }
}