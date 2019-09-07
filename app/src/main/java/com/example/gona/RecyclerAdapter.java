package com.example.gona;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    private ArrayList<DataProvider> arrayList = new ArrayList<DataProvider>();

    public RecyclerAdapter(ArrayList<DataProvider> arrayList){
        this.arrayList = arrayList;
    }
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);

        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        DataProvider dataProvider = arrayList.get(position);
        holder.imageView.setImageResource(dataProvider.getImg_res());
        holder.f_name.setText(dataProvider.getF_name());
        holder.price.setText(dataProvider.getPrice());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView f_name, price;
        public RecyclerViewHolder(View view){
            super(view);
            imageView = (ImageView) view.findViewById(R.id.img);
            f_name = (TextView) view.findViewById(R.id.f_name);
            price = (TextView) view.findViewById(R.id.price);
        }
    }
}
