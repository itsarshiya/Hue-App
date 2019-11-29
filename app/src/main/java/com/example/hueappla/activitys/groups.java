package com.example.hueappla.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.hueappla.Group;
import com.example.hueappla.GroupListAdapter;
import com.example.hueappla.HueLamp;
import com.example.hueappla.LampListAdapter;
import com.example.hueappla.R;
import com.example.hueappla.menu_fragmentListener;

import java.util.ArrayList;

public class groups extends AppCompatActivity implements menu_fragmentListener {

    private ArrayList<HueLamp> hueLamps;
    private ArrayList<Group> groups;
    private RecyclerView groupRecycler;
    private GroupListAdapter groupListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.hueLamps = (ArrayList<HueLamp>) getIntent().getSerializableExtra("LAMPS");
        this.groups = (ArrayList<Group>) getIntent().getSerializableExtra("GROUPS");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);
        this.groupRecycler = findViewById(R.id.groupRecycler);
        this.groupRecycler.setLayoutManager(new GridLayoutManager(
                this,
                1,
                RecyclerView.VERTICAL,
                false
        ));
        this.groupListAdapter = new GroupListAdapter(this.groups);
        this.groupRecycler.setAdapter(this.groupListAdapter);
        this.groupListAdapter.notifyDataSetChanged();
    }

    @Override
    public void OnGroupsButtonClicked() {
        /*
        Intent intent = new Intent(
                getApplicationContext(),
                groups.class
        );
        intent.putExtra("LAMPS", this.hueLamps);
        intent.putExtra("GROUPS", this.groups);
        getApplicationContext().startActivity(intent);
        */
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
