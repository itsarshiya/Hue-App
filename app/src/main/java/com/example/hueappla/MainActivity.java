package com.example.hueappla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements HueLampApiListener {

    private ArrayList<HueLamp> hueLamps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.hueLamps = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void OnHueLampAvailable(HueLamp hueLamp) {
        this.hueLamps.add(hueLamp);
    }

    @Override
    public void OnHueAdapterError(String error) {
        Log.i("Netwerk Error", "Adapter gaat niet goed");
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
