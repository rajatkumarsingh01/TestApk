package com.example.putatoeproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class IconsAdapter extends RecyclerView.Adapter<IconsAdapter.IconViewHolder> {

    private final int[] iconList;
    private final LayoutInflater layoutInflater;

    public IconsAdapter(Context context, int[] iconList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.iconList = iconList;
    }

    @NonNull
    @Override
    public IconViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_icon, parent, false);
        return new IconViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IconViewHolder holder, int position) {
        int iconResource = iconList[position];
        holder.iconImageView.setImageResource(iconResource);
    }

    @Override
    public int getItemCount() {
        return iconList.length;
    }

    public static class IconViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImageView;

        public IconViewHolder(View view) {
            super(view);
            iconImageView = view.findViewById(R.id.iconImageView);
        }
    }
}
