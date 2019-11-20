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
    public void OnHueAdapterError() {
        Log.i("Netwerk Error", "Adapter gaat niet goed");
    }
}
