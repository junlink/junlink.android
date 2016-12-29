package com.example.juu79.moblielabs.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.juu79.moblielabs.R;


/**
 * Created by juu79 on 2016/12/17 0017.
 */
public class MyRecyclerViewHolder extends RecyclerView.ViewHolder {
    public TextView title;
    public TextView summary;
    public ImageView imageUrl;
    public TextView postTime;

//    public MyRecyclerViewHolder(View itemView,TextView summary,) {
//        super(itemView);
//        title = (TextView) itemView.findViewById(R.id.id_title);
//    }

    public MyRecyclerViewHolder(View itemView, TextView title, TextView summary,ImageView imageUrl) {
        super(itemView);
        this.title = title;
        this.summary = summary;
        this.imageUrl = imageUrl;

    }
}
