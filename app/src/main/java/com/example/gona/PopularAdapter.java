/*

package com.example.gona;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ImageViewHolder> {

    private Context mContext;
    private List<Popular> mPopulars;

    public PopularAdapter(Context context, List<Popular> populars){
        mContext=context;
        mPopulars=populars;
    }
    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(mContext).inflate(R.layout.item_layout, viewGroup, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder imageViewHolder, int i) {
    Popular popularCur = mPopulars.get(i);
    imageViewHolder.prod_name.setText(popularCur.getProduct_title());
    imageViewHolder.prod_price.setText(popularCur.getProduct_price());
        Picasso.with(mContext)
                .load(popularCur.getProduct_image())
                .placeholder(R.drawable.image_placeholder)
                .fit()
                .centerCrop()
                .into((Target) imageViewHolder.prod_image);

                //.load(popularCur.getProduct_image())
                //.placeholder(R.drawable.image_placeholder)
               // .fit()
                //.centerCrop()
                //.into((Target) imageViewHolder.prod_image);
                //.load(R.drawable.image_placeholder).into(imageViewHolder.prod_image);

    }

    @Override
    public int getItemCount() {
        return mPopulars.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{

        public TextView prod_name;
        public  TextView prod_price;
        public TextView prod_image;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);

            prod_name=itemView.findViewById(R.id.prodName);
            prod_price=itemView.findViewById(R.id.prodPrice);
            prod_image=itemView.findViewById(R.id.prodImage);

        }
    }
}

*/
