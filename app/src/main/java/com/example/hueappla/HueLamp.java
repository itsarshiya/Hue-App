package com.example.hueappla;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

import java.io.Serializable;

public class HueLamp implements HueLampApiListener, Serializable {

    private String index;
    private boolean on;
    private boolean ton;
    private int bri;
    private int tbri;
    private int hue;
    private int thue;
    private int sat;
    private int tsat;

    public HueLamp(String index, boolean on, int bri, int hue, int sat) {
        this.index = index;
        this.on = on;
        this.bri = bri;
        this.hue = hue;
        this.sat = sat;
    }

    /*
    public void setHueLampApi(HueLampApi hueLampApi) {
        this.hueLampApi = hueLampApi;
    }
    */

    public String getIndex() {
        return this.index;
    }

    public boolean getOn() {
        return this.on;
    }

    public int getBri() {
        return this.bri;
    }

    public int getHue() {
        return this.hue;
    }

    public int getSat() {
        return this.sat;
    }

    public void setOn(boolean on, HueLampApi hueLampApi) {
        this.ton = on;
        hueLampApi.setHueLampStateOn(this, this.ton, this);
    }

    public void setBri(int bri, HueLampApi hueLampApi) {
        this.tbri = bri;
        hueLampApi.setHueLampStateBri(this, this.tbri, this);
    }

    public void setHue(int hue, HueLampApi hueLampApi) {
        this.thue = hue;
        hueLampApi.setHueLampStateHue(this, this.thue, this);
    }

    public void setSat(int sat, HueLampApi hueLampApi) {
        this.tsat = sat;
        hueLampApi.setHueLampStateSat(this, this.tsat, this);
    }

    @Override
    public void OnHueLampSetOn(String error, HueLamp hueLamp) {
        this.on = this.ton;
    }

    @Override
    public void OnHueLampSetSat(String error, HueLamp hueLamp) {
        this.sat = this.tsat;
    }

    @Override
    public void OnHueLampSetBri(String error, HueLamp hueLamp) {
        this.bri = this.tbri;
    }

    @Override
    public void OnHueLampSetHue(String error, HueLamp hueLamp) {
        this.hue = this.thue;
    }

    @Override
    public void OnHueLampSetOnError(String error) {

    }

    @Override
    public void OnHueLampSetBriError(String error) {

    }

    @Override
    public void OnHueLampSetSatError(String error) {

    }

    @Override
    public void OnHueLampSetHueError(String error) {

    }

    @Override
    public void OnHueLampAvailable(HueLamp hueLamp) {

    }

    @Override
    public void OnHueAdapterError(String error) {

    }

}
