package com.example.hueappla.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.hueappla.ColorPickerListener;
import com.example.hueappla.Group;
import com.example.hueappla.HueLamp;
import com.example.hueappla.HueLampApi;
import com.example.hueappla.HueLampApiListener;
import com.example.hueappla.R;
import com.example.hueappla.menu_fragmentListener;

import java.util.ArrayList;

public class allLamps extends AppCompatActivity implements menu_fragmentListener, ColorPickerListener, HueLampApiListener {

    private ArrayList<HueLamp> hueLamps;
    private ArrayList<Group> groups;
    private HueLampApi hueLampApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.hueLamps = (ArrayList<HueLamp>) getIntent().getSerializableExtra("LAMPS");
        this.groups = (ArrayList<Group>) getIntent().getSerializableExtra("GROUPS");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_lamps);
        this.hueLampApi = new HueLampApi(getApplicationContext(), this);
        //hueLampApi.searchForHueLamps();
    }

    @Override
    public void OnGroupsButtonClicked() {
        Intent intent = new Intent(
                getApplicationContext(),
                groups.class
        );
        intent.putExtra("LAMPS", this.hueLamps);
        intent.putExtra("GROUPS", this.groups);
        getApplicationContext().startActivity(intent);
    }

    @Override
    public void OnLampsButtonClicked() {
        Intent intent = new Intent(
                getApplicationContext(),
                lamps.class
        );
        intent.putExtra("LAMPS", this.hueLamps);
        intent.putExtra("GROUPS", this.groups);
        getApplicationContext().startActivity(intent);
    }

    @Override
    public void OnAllLampsButtonClicked() {
        /*
        Intent intent = new Intent(
                getApplicationContext(),
                allLamps.class
        );
        intent.putExtra("LAMPS", this.hueLamps);
        intent.putExtra("GROUPS", this.groups);
        getApplicationContext().startActivity(intent);
        */
    }

    @Override
    public void OnHueChanged(int hue) {
        for(HueLamp hueLamp : this.hueLamps) {
            hueLamp.setHue(hue, this.hueLampApi);
        }
    }

    @Override
    public void OnBriChanged(int bri) {
        for(HueLamp hueLamp : this.hueLamps) {
            hueLamp.setBri(bri, this.hueLampApi);
        }
    }

    @Override
    public void OnSatChanged(int sat) {
        for(HueLamp hueLamp : this.hueLamps) {
            hueLamp.setSat(sat, this.hueLampApi);
        }
    }

    @Override
    public void OnOnChanged(boolean on) {
        for(HueLamp hueLamp : this.hueLamps) {
            hueLamp.setOn(on, this.hueLampApi);
        }
    }

    @Override
    public void OnHueLampAvailable(HueLamp hueLamp) {
        this.hueLamps.add(hueLamp);
    }

    @Override
    public void OnHueAdapterError(String error) {

    }

    @Override
    public void OnHueLampSetOn(String error, HueLamp hueLamp) {

    }

    @Override
    public void OnHueLampSetOnError(String error) {

    }

    @Override
    public void OnHueLampSetBri(String error, HueLamp hueLamp) {

    }

    @Override
    public void OnHueLampSetBriError(String error) {

    }

    @Override
    public void OnHueLampSetSat(String error, HueLamp hueLamp) {

    }

    @Override
    public void OnHueLampSetSatError(String error) {

    }

    @Override
    public void OnHueLampSetHue(String error, HueLamp hueLamp) {

    }

    @Override
    public void OnHueLampSetHueError(String error) {

    }
}
