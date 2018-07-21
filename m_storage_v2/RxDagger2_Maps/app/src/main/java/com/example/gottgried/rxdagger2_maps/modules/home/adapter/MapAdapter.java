package com.example.gottgried.rxdagger2_maps.modules.home.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gottgried.rxdagger2_maps.R;
import com.example.gottgried.rxdagger2_maps.pojo.Result;

import java.util.List;

/**
 * Created by Gottgried on 21.07.2018.
 */

public class MapAdapter extends RecyclerView.Adapter<MapAdapter.Holder> {

    private LayoutInflater mLayoutInflater;
    private List<Result> maps;

    public MapAdapter(LayoutInflater mLayoutInflater) {
        this.mLayoutInflater = mLayoutInflater;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(mLayoutInflater.inflate(R.layout.maps_item, parent, false));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
            holder.bind(maps.get(position));
    }

    @Override
    public int getItemCount() {
        return maps.size();
    }

    public void addPlaces(List<Result> result){
        maps.addAll(result);
        notifyDataSetChanged();
    }



    //TODO: Bind the vies
    public class Holder extends RecyclerView.ViewHolder{

        public Holder(View itemView) {
            super(itemView);
        }

        public void bind(Result result){

        }
    }
}
