package com.example.juu79.moblielabs.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.juu79.moblielabs.R;
import com.example.juu79.moblielabs.adapter.MyRecyclerViewAdapter;
import com.example.juu79.moblielabs.adapter.MyStaggeredViewAdapter;

/**
 * Created by juu79 on 2016/12/17 0017.
 */
public class Fragment_five extends Fragment  {

    private View mView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private MyRecyclerViewAdapter mRecyclerViewAdapter;
    private MyStaggeredViewAdapter mStaggeredAdapter;

    private static final int SPAN_COUNT = 2;
    private int flag = 0;



    public static Fragment_five newInstance(String str) {
        Fragment_five fragment = new Fragment_five();

        Bundle bundle = new Bundle();
        bundle.putString("five", str);

        fragment.setArguments(bundle);

        return  fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Bundle bundle = getArguments();

        View view = inflater.inflate(R.layout.fragment_five, container, false);
        return view;
    }

}
