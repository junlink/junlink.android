package com.example.juu79.moblielabs.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.juu79.moblielabs.R;
import com.example.juu79.moblielabs.data.Article;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juu79 on 2016/12/17 0017.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    public OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public Context mContext;
    public List<Article> mArticle=new ArrayList<>();
    public LayoutInflater mLayoutInflater;

    public MyRecyclerViewAdapter(List<Article> articles,Context mContext) {
        this.mContext = mContext;
        this.mArticle=articles;
        mLayoutInflater = LayoutInflater.from(mContext);
    }
    /**
     * 创建ViewHolder
     */
    @Override
    public MyRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = mLayoutInflater.inflate(R.layout.item_main, parent, false);
        MyRecyclerViewHolder mViewHolder = new MyRecyclerViewHolder(mView,
                (TextView) mView.findViewById(R.id.news_title),
                (TextView) mView.findViewById(R.id.news_summary),
                (ImageView) mView.findViewById(R.id.news_user)
        );
        return mViewHolder;
    }

    /**
     * 绑定ViewHoler，给item中的控件设置数据
     */
    @Override
    public void onBindViewHolder(final MyRecyclerViewHolder holder, final int position) {
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(holder.itemView, mArticle.size());
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnItemClickListener.onItemLongClick(holder.itemView, mArticle.size());
                    return true;
                }
            });
        }
         holder.imageUrl.setImageResource(R.mipmap.ic_launcher);
//        holder.imageUrl.setImageResource(mArticle.get(position).getImageUrl());
            holder.title.setText(mArticle.get(position).getTitle().toString());
            holder.summary.setText(mArticle.get(position).getSummary().toString());
    }

    @Override
    public int getItemCount() {
        return mArticle.size();
    }
}
