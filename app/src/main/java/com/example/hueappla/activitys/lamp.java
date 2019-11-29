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

public class lamp extends AppCompatActivity implements HueLampApiListener, ColorPickerListener, menu_fragmentListener {

    private HueLampApi hueLampApi;
    private HueLamp hueLamp;
    private ArrayList<Group> groupList;
    private ArrayList<HueLamp> hueLampList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.hueLampApi = new HueLampApi(getApplicationContext(), this);
        this.hueLamp = (HueLamp) getIntent().getSerializableExtra("LAMP");
        this.groupList = (ArrayList<Group>) getIntent().getSerializableExtra("GROUPS");
        this.hueLampList = (ArrayList<HueLamp>) getIntent().getSerializableExtra("LAMPS");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lamp);
    }

    @Override
    public void OnHueLampAvailable(HueLamp hueLamp) {

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

    @Override
    public void OnHueChanged(int hue) {
        this.hueLamp.setHue(hue, this.hueLampApi);
    }

    @Override
    public void OnBriChanged(int bri) {
        this.hueLamp.setBri(bri, this.hueLampApi);
    }

    @Override
    public void OnSatChanged(int sat) {
        this.hueLamp.setSat(sat, this.hueLampApi);
    }

    @Override
    public void OnOnChanged(boolean on) {
        this.hueLamp.setOn(on, this.hueLampApi);
    }

    @Override
    public void OnGroupsButtonClicked() {
        Intent intent = new Intent(
                getApplicationContext(),
                groups.class
        );
        intent.putExtra("LAMPS", this.hueLampList);
        intent.putExtra("GROUPS", this.groupList);
        getApplicationContext().startActivity(intent);
    }

    @Override
    public void OnLampsButtonClicked() {
        Intent intent = new Intent(
                getApplicationContext(),
                lamps.class
        );
        intent.putExtra("LAMPS", this.hueLampList);
        intent.putExtra("GROUPS", this.groupList);
        getApplicationContext().startActivity(intent);
    }

    @Override
    public void OnAllLampsButtonClicked() {
        Intent intent = new Intent(
                getApplicationContext(),
                allLamps.class
        );
        intent.putExtra("LAMPS", this.hueLampList);
        intent.putExtra("GROUPS", this.groupList);
        getApplicationContext().startActivity(intent);
    }
}
