package com.gojek.justjava;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    private final List<Item> titleList;
    private final OnItemClick itemClick;

    public HomeAdapter(List<Item> titleList, OnItemClick itemClick) {
        this.titleList = titleList;
        this.itemClick = itemClick;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_home, parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final HomeViewHolder holder, int position) {
        Item item = titleList.get(position);
        holder.textTitle.setText(item.getTitle());
        holder.textSubtitle.setText(item.getSubtitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.onClick(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return titleList.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {

        TextView textTitle;
        TextView textSubtitle;

        public HomeViewHolder(View itemView) {
            super(itemView);
            textTitle = (TextView) itemView.findViewById(R.id.text_title);
            textSubtitle = (TextView) itemView.findViewById(R.id.text_subtitle);
        }
    }
}
