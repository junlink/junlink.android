package com.example.juu79.moblielabs.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.juu79.moblielabs.R;
import com.example.juu79.moblielabs.adapter.MyRecyclerViewAdapter;
import com.example.juu79.moblielabs.data.Article;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by juu79 on 2016/12/17 0017.
 */
public class Fragment_two extends Fragment implements SwipeRefreshLayout.OnRefreshListener , MyRecyclerViewAdapter.OnItemClickListener{

    public static Fragment_two newInstance(String str) {
        Fragment_two fragment = new Fragment_two();
        Bundle bundle = new Bundle();
        bundle.putString("two", str);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Bundle bundle = getArguments();

        View view = inflater.inflate(R.layout.fragment_two, container, false);

        return view;
    }



    @Override
    public void onRefresh() {

    }

    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public void onItemLongClick(View view, int position) {

    }
}