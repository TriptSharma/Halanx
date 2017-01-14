package com.halanx.tript.userapp;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by Tript on 28-12-2016.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{

    private LayoutInflater inflater;
    List<Info> data = Collections.emptyList();

    public Adapter(Context context, List<Info> data){
        inflater = LayoutInflater.from(context);
        this.data = data;
    }
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.slider_view,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Adapter.MyViewHolder holder, int position) {
        Info current = data.get(position);
        holder.txt.setText(current.title);
        holder.img.setImageResource(current.icon_id);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt;
        ImageView img;
        public MyViewHolder(View itemView) {
            super(itemView);
            txt = (TextView) itemView.findViewById(R.id.itemText);
            img = (ImageView) itemView.findViewById(R.id.itemView);


        }
    }
}
