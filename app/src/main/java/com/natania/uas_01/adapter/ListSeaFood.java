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
import com.natania.uas_01.model.ResponseSeaFood;
import com.natania.uas_01.model.SeafoodItem;

import java.util.ArrayList;
import java.util.List;

public class ListSeaFood extends RecyclerView.Adapter<ListSeaFood.ViewHolder> {
    private Context context;
    private List<SeafoodItem> seafoodItems;


    public ListSeaFood(Context context,List<SeafoodItem> seafoodItems){
        this.context = context;
        this.seafoodItems = seafoodItems;
    }

    @NonNull
    @Override
    public ListSeaFood.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListSeaFood.ViewHolder holder, int position) {
        final SeafoodItem seafoodItem = seafoodItems.get(position);

        Glide.with(holder.itemView.getContext()).load(seafoodItem.getStrMealThumb())
                .apply(new RequestOptions().override(55,55))
                .into(holder.thumb);

        holder.tvName.setText(seafoodItem.getStrMeal());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("title", seafoodItem.getStrMeal());
                intent.putExtra("thumb", seafoodItem.getStrMealThumb());

                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return seafoodItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumb;
        public TextView tvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            thumb = itemView.findViewById(R.id.img_item);
            tvName = itemView.findViewById(R.id.tv_item_name_seafood);
        }
    }
}
