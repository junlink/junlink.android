package com.example.juu79.moblielabs.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.juu79.moblielabs.R;

/**
 * Created by juu79 on 2016/12/17 0017.
 */
public class Fragment_three extends Fragment {


    public static Fragment_three newInstance(String str) {
        Fragment_three fragment = new Fragment_three();

        Bundle bundle = new Bundle();
        bundle.putString("three", str);

        fragment.setArguments(bundle);

        return  fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Bundle bundle = getArguments();

        View view = inflater.inflate(R.layout.fragment_three, container, false);
        return view;
    }

}

