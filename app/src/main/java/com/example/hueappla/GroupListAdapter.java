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

public class GroupListAdapter extends RecyclerView.Adapter<GroupListAdapter.GroupViewHolder>{

    private ArrayList<Group> groupList;

    public GroupListAdapter(ArrayList<Group> groupList) {
        this.groupList = groupList;
    }

    @NonNull
    @Override
    public GroupListAdapter.GroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.group_view_holder, parent, false);
        return new GroupListAdapter.GroupViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GroupListAdapter.GroupViewHolder holder, int position) {
        Group group = groupList.get(position);
        holder.index.setText(group.getIndex());
        holder.bri.setText(String.valueOf(group.getBri()));
        holder.hue.setText(String.valueOf(group.getHue()));
        holder.sat.setText(String.valueOf(group.getSat()));
    }

    @Override
    public int getItemCount() {
        return this.groupList.size();
    }

    public class GroupViewHolder extends RecyclerView.ViewHolder {

        public TextView index;
        public TextView bri;
        public TextView hue;
        public TextView sat;

        public GroupViewHolder(@NonNull View itemView) {
            super(itemView);
            index = itemView.findViewById(R.id.group_id);
            bri = itemView.findViewById(R.id.bri_id);
            hue = itemView.findViewById(R.id.hue_id);
            sat = itemView.findViewById(R.id.sat_id);

            //TODO: 24-11-2019 Ga naar nieuwe detailed view group.
            //Welke activity als er op geklikt wordt.
            //itemView.setOnClickListener(new View.OnClickListener() {

            //    @Override

            //    public void onClick(View view) {
            //        Intent intent = new Intent(
            //                view.getContext(),
            //                lamp.class);

            //        HueLamp hueLamp = hueLampList.get(LampListAdapter.HueLampViewHolder.super.getAdapterPosition());
            //        intent.putExtra("LAMP",hueLamp);
            //        view.getContext().startActivity(intent);
            //    }
            //});
        }
    }

}
