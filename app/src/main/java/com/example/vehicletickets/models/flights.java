package com.example.vehicletickets.models;

public class flights {
    private String deparute;
    private String arrival;
    private String date;
    private String time;
    private int totalPassanger;
    private int passanger;
    private String modelNo;


    public flights() {
    }

    public flights(String deparute, String arrival, String date, String time, int totalPassanger, int passanger, String modelNo) {
        this.deparute = deparute;
        this.arrival = arrival;
        this.date = date;
        this.time = time;
        this.totalPassanger = totalPassanger;
        this.passanger = passanger;
        this.modelNo = modelNo;
    }

    public String getDeparute() {
        return deparute;
    }

    public void setDeparute(String deparute) {
        this.deparute = deparute;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getTotalPassanger() {
        return totalPassanger;
    }

    public void setTotalPassanger(int totalPassanger) {
        this.totalPassanger = totalPassanger;
    }

    public int getPassanger() {
        return passanger;
    }

    public void setPassanger(int passanger) {
        this.passanger = passanger;
    }

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }
}
