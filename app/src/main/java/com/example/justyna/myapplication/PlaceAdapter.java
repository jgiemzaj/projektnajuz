package com.example.justyna.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by student on 2017-12-18.
 */

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {
    private ArrayList<Place> places = new ArrayList<>();
    private OnClickPlace listener;

    public PlaceAdapter(ArrayList<Place> places, OnClickPlace listener) {
        this.places = places;
        this.listener=listener;
    }

    @Override
    public PlaceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, null);
        return new ViewHolder(itemLayoutView, listener);
    }

    @Override
    public void onBindViewHolder(PlaceAdapter.ViewHolder holder, int position) {
        holder.setPlaceName(places.get(position).getPlaceName() + "");
        holder.setInformation(places.get(position).getInformation() + "");
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.txt_information)
        TextView placeInfo;

        @BindView(R.id.txt_placeName)
        TextView placeName;

        private OnClickPlace listener;

        public ViewHolder(View itemView, OnClickPlace listener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        public void setPlaceName(String name) {
            placeName.setText(name);
        }

        public void setInformation(String s) {
            placeInfo.setText(s);
        }

        @Override
        public void onClick(View view) {listener.onClickPlace(view, getAdapterPosition());
        }
    }}





