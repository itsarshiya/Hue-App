package com.example.hueappla.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.hueappla.Group;
import com.example.hueappla.HueLamp;
import com.example.hueappla.LampListAdapter;
import com.example.hueappla.R;
import com.example.hueappla.menu_fragmentListener;

import java.util.ArrayList;

public class lamps extends AppCompatActivity implements menu_fragmentListener {

    private ArrayList<HueLamp> hueLamps;
    private ArrayList<Group> groups;
    private RecyclerView hueLampRecycler;
    private LampListAdapter lampListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.hueLamps = (ArrayList<HueLamp>) getIntent().getSerializableExtra("LAMPS");
        this.groups = (ArrayList<Group>) getIntent().getSerializableExtra("GROUPS");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lamps);
        this.hueLampRecycler = findViewById(R.id.lampRecycler);
        this.hueLampRecycler.setLayoutManager(new GridLayoutManager(
                this,
                1,
                RecyclerView.VERTICAL,
                false
        ));
        this.lampListAdapter = new LampListAdapter(this.hueLamps, this.groups);
        this.hueLampRecycler.setAdapter(lampListAdapter);
        this.lampListAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        this.hueLamps = (ArrayList<HueLamp>) getIntent().getSerializableExtra("LAMPS");
        this.groups = (ArrayList<Group>) getIntent().getSerializableExtra("GROUPS");
        super.onResume();
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
        /*
        Intent intent = new Intent(
                getApplicationContext(),
                lamps.class
        );
        intent.putExtra("LAMPS", this.hueLamps);
        intent.putExtra("GROUPS", this.groups);
        getApplicationContext().startActivity(intent);
        */
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
