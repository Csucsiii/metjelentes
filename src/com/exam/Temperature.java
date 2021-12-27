package com.exam;

public class Temperature {
    private String id;
    private String midTemp;
    private String tempRange;

    public Temperature(String id, String midTemp) {
        this.id = id;
        this.midTemp = midTemp;
    }

    public Temperature(String id, String midTemp, String tempRange) {
        this.id = id;
        this.midTemp = midTemp;
        this.tempRange = tempRange;
    }

    public Temperature() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMidTemp() {
        return midTemp;
    }

    public void setMidTemp(String midTemp) {
        this.midTemp = midTemp;
    }

    public String getTempRange() {
        return tempRange;
    }

    public void setTempRange(String tempRange) {
        this.tempRange = tempRange;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "id='" + id + '\'' +
                ", midTemp='" + midTemp + '\'' +
                ", tempRange='" + tempRange + '\'' +
                '}';
    }
}
