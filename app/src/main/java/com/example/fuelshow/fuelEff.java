package com.example.fuelshow;

public class fuelEff {
    String date,  time, rsperltr, litres, dkm,dprice;

    public fuelEff(String date, String time, String rsperltr, String litres, String dkm, String dprice) {
        this.date = date;
        this.time = time;
        this.rsperltr = rsperltr;
        this.litres = litres;
        this.dkm = dkm;
        this.dprice = dprice;
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

    public String getRsperltr() {
        return rsperltr;
    }

    public void setRsperltr(String rsperltr) {
        this.rsperltr = rsperltr;
    }

    public String getLitres() {
        return litres;
    }

    public void setLitres(String litres) {
        this.litres = litres;
    }

    public String getDkm() {
        return dkm;
    }

    public void setDkm(String dkm) {
        this.dkm = dkm;
    }

    public String getDprice() {
        return dprice;
    }

    public void setDprice(String dprice) {
        this.dprice = dprice;
    }
}
