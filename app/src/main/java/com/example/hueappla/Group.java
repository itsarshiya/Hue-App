package com.example.hueappla;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Group implements Serializable {

    private ArrayList<HueLamp> hueLampList;

    private boolean on;
    private int bri;
    private int hue;
    private int sat;
    private String index;

    public Group(String index) {
        this.hueLampList = new ArrayList<HueLamp>();
        this.index = index;
        this.hue = 0;
        this.bri = 100;
        this.sat = 100;
    }

    public void addHueLamp(HueLamp hueLamp, HueLampApi hueLampApi) {
        this.hueLampList.add(hueLamp);
        hueLamp.setOn(this.on, hueLampApi);
        hueLamp.setHue(this.hue, hueLampApi);
        hueLamp.setSat(this.sat, hueLampApi);
        hueLamp.setBri(this.bri, hueLampApi);
    }

    public void removeHueLamp(HueLamp hueLamp) {
        this.hueLampList.remove(hueLamp);
    }

    public ArrayList<HueLamp> getHueLampList() {
        return this.hueLampList;
    }

    public boolean getIsOn() {
        return on;
    }

    public int getBri() {
        return bri;
    }

    public int getHue() {
        return hue;
    }

    public int getSat() {
        return sat;
    }

    public void setOn(boolean on, HueLampApi hueLampApi) {
        this.on = on;
        setAllOn(hueLampApi);
    }

    public void setBri(int bri, HueLampApi hueLampApi) {
        this.bri = bri;
        setAllBri(hueLampApi);
    }

    public void setHue(int hue, HueLampApi hueLampApi) {
        this.hue = hue;
        setAllHue(hueLampApi);
    }

    public void setSat(int sat, HueLampApi hueLampApi) {
        this.sat = sat;
        setAllSat(hueLampApi);
    }

    private void setAllOn(HueLampApi hueLampApi) {
        for(HueLamp hueLamp : hueLampList) {
            hueLamp.setOn(this.on, hueLampApi);
        }
    }

    private void setAllBri(HueLampApi hueLampApi) {
        for(HueLamp hueLamp : hueLampList) {
            hueLamp.setBri(this.bri, hueLampApi);
        }
    }

    private void setAllHue(HueLampApi hueLampApi) {
        for(HueLamp hueLamp : hueLampList) {
            hueLamp.setHue(this.hue, hueLampApi);
        }
    }

    private void setAllSat(HueLampApi hueLampApi) {
        for(HueLamp hueLamp : hueLampList) {
            hueLamp.setSat(this.sat, hueLampApi);
        }
    }

    public boolean isOn() {
        return on;
    }

    public String getIndex() {
        return index;
    }

}
