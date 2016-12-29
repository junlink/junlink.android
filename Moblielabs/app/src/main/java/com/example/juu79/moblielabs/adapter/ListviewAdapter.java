package com.example.juu79.moblielabs.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.juu79.moblielabs.R;
import com.example.juu79.moblielabs.data.Article;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juu79 on 2016/12/21 0021.
 */

public class ListviewAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<Article> problemDatas = new ArrayList<>();

    public ListviewAdapter(Context context, List<Article>problemDatas) {
        this.problemDatas = problemDatas;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return problemDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return problemDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = mInflater.inflate(R.layout.item_main, null);
            viewHolder.item_textview0 = (TextView) view.findViewById(R.id.news_summary);
            viewHolder.item_textview1 = (TextView) view.findViewById(R.id.news_title);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        String title = problemDatas.get(position).getTitle();
        String summary = problemDatas.get(position).getSummary();
        viewHolder.item_textview0.setText(title);
        viewHolder.item_textview1.setText(summary);
        return view;
    }

    class ViewHolder {
        public TextView item_textview0;
        public TextView item_textview1;

    }

}
