package com.exam;

public class Town {

    private String id;
    private String time;
    private String wind;
    private Integer temperature;

    public Town(String id, String time, String wind, Integer temperature) {
        this.id = id;
        this.time = time;
        this.wind = wind;
        this.temperature = temperature;
    }

    public Town() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Town{" +
                "id='" + id + '\'' +
                ", time='" + time + '\'' +
                ", wind='" + wind + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}
