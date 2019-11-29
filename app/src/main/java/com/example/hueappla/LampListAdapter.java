package com.example.hueappla;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hueappla.activitys.lamp;

import java.util.ArrayList;

public class LampListAdapter extends RecyclerView.Adapter<LampListAdapter.HueLampViewHolder> {

    private ArrayList<HueLamp> hueLampList;
    private ArrayList<Group> groupList;

    public LampListAdapter(ArrayList<HueLamp> hueLampList, ArrayList<Group> groupList) {
        this.hueLampList = hueLampList;
        this.groupList = groupList;
    }

    public class HueLampViewHolder extends RecyclerView.ViewHolder {

        public TextView index;
        public TextView bri;
        public TextView hue;
        public TextView sat;

        public HueLampViewHolder(@NonNull View itemView) {
            super(itemView);
            index = itemView.findViewById(R.id.index_id);
            bri = itemView.findViewById(R.id.bri_id);
            hue = itemView.findViewById(R.id.hue_id);
            sat = itemView.findViewById(R.id.sat_id);

            //Welke activity als er op geklikt wordt.
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override

                public void onClick(View view) {
                    Intent intent = new Intent(
                            view.getContext(),
                            lamp.class);

                    HueLamp hueLamp = hueLampList.get(HueLampViewHolder.super.getAdapterPosition());
                    intent.putExtra("LAMP",hueLamp);
                    intent.putExtra("LAMPS", hueLampList);
                    intent.putExtra("GROUPS", groupList);
                    view.getContext().startActivity(intent);
                }
            });
        }
    }

    @NonNull
    @Override
    public HueLampViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_hue_lamp_view_holder, parent, false);
        return new HueLampViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HueLampViewHolder holder, int position) {
        HueLamp hueLamp = hueLampList.get(position);
        holder.index.setText(hueLamp.getIndex());
        holder.bri.setText(String.valueOf(hueLamp.getBri()));
        holder.hue.setText(String.valueOf(hueLamp.getHue()));
        holder.sat.setText(String.valueOf(hueLamp.getSat()));
    }

    @Override
    public int getItemCount() {
        return hueLampList.size();
    }
}
