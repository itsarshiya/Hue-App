package com.example.hueappla.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.example.hueappla.Group;
import com.example.hueappla.HueLamp;
import com.example.hueappla.HueLampApi;
import com.example.hueappla.HueLampApiListener;
import com.example.hueappla.R;
import com.example.hueappla.activitys.groups;
import com.example.hueappla.menu_fragmentListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements HueLampApiListener, menu_fragmentListener {

    private transient ArrayList<HueLamp> hueLamps;
    private transient ArrayList<Group> groups;
    private HueLampApi hueLampApi;

    private Button buttonOn;
    private Button buttonOff;
    private SeekBar brightsness;
    private SeekBar Color;
    private SeekBar Saturation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.hueLamps = new ArrayList<>();
        this.groups = new ArrayList<>();
        //this.hueLamps.add(new HueLamp("1", true, 100));
        //this.hueLamps.add(new HueLamp("3", true, 100));
        //this.hueLamps.add(new HueLamp("4", false, 0));
        //this.groups.add(new Group("1"));
        //this.groups.add(new Group("2"));
        //this.groups.add(new Group("3"));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.hueLampApi = new HueLampApi(getApplicationContext(), this);

        this.buttonOn = findViewById(R.id.buttonOn);
        this.buttonOff = findViewById(R.id.buttonOff);
        this.brightsness = findViewById(R.id.Brightsness);
        this.brightsness.setMax(254);
        this.Color = findViewById(R.id.Color);
        this.Color.setMax(65535);
        this.Saturation = findViewById(R.id.Saturation);
        this.Saturation.setMax(254);

        hueLampApi.searchForHueLamps();

        this.buttonOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAllHueLampsOn(true);
            }
        });
        this.buttonOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAllHueLampsOn(false);
            }
        });
        this.brightsness.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                setAllHueLampsBri(seekBar.getProgress());
            }
        });
        this.Color.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                setAllHueLampsHue(seekBar.getProgress());
            }
        });
        this.Saturation.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                setAllHueLampsSat(seekBar.getProgress());
            }
        });
    }

    public void setAllHueLampsOn(boolean on) {
        for(HueLamp hueLamp : this.hueLamps) {
            hueLamp.setOn(on, this.hueLampApi);
        }
    }
    public void setAllHueLampsHue(int hue) {
        for(HueLamp hueLamp : this.hueLamps) {
            hueLamp.setHue(hue, this.hueLampApi);
        }
    }
    public void setAllHueLampsSat(int sat) {
        for(HueLamp hueLamp : this.hueLamps) {
            hueLamp.setSat(sat, this.hueLampApi);
        }
    }
    public void setAllHueLampsBri(int bri) {
        for(HueLamp hueLamp : this.hueLamps) {
            hueLamp.setBri(bri, this.hueLampApi);
        }
    }

    @Override
    public void OnHueLampAvailable(HueLamp hueLamp) {
        //hueLamp.setHueLampApi(this.hueLampApi);
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
        Intent intent = new Intent(
                getApplicationContext(),
                allLamps.class
        );
        intent.putExtra("LAMPS", this.hueLamps);
        intent.putExtra("GROUPS", this.groups);
        getApplicationContext().startActivity(intent);
    }
}
