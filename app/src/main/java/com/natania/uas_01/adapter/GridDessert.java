package com.natania.uas_01.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.natania.uas_01.R;
import com.natania.uas_01.activity.DetailActivity;
import com.natania.uas_01.model.DessertItem;


import java.util.List;

public class GridDessert extends RecyclerView.Adapter<GridDessert.ViewHolder> {
    private Context context;
    private List<DessertItem> dessertitems;

    public GridDessert(Context context,List<DessertItem>dessertItems){
        this.context = context;
        this.dessertitems = dessertItems;
    }

    @NonNull
    @Override
    public GridDessert.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid,parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull GridDessert.ViewHolder holder, int position) {
        final DessertItem dessertItem = dessertitems.get(position);

        holder.tvName.setText(dessertItem.getStrMeal());
        Glide.with(holder.itemView.getContext()).load(dessertItem.getStrMealThumb())
                .into(holder.thumb);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("title", dessertItem.getStrMeal());
                intent.putExtra("thumb", dessertItem.getStrMealThumb());

                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return dessertitems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView thumb;
        TextView tvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            thumb = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name_Dessert);
        }
    }
}
