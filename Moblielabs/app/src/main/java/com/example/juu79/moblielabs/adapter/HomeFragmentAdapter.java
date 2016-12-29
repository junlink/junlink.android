package com.example.juu79.moblielabs.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.Toolbar;

import com.example.juu79.moblielabs.Fragment.Fragment_five;
import com.example.juu79.moblielabs.Fragment.Fragment_four;
import com.example.juu79.moblielabs.Fragment.Fragment_one;
import com.example.juu79.moblielabs.Fragment.Fragment_six;
import com.example.juu79.moblielabs.Fragment.Fragment_three;
import com.example.juu79.moblielabs.Fragment.Fragment_two;
import com.example.juu79.moblielabs.R;

import java.util.List;

/**
 * Created by juu79 on 2016/12/17 0017.
 */

public class HomeFragmentAdapter extends FragmentStatePagerAdapter
{

    private String[] mTitles;
    private List<Fragment> mFragments;

    public HomeFragmentAdapter(FragmentManager fm, String[] mTitles, List<Fragment> mFragments) {
        super(fm);
        this.mTitles = mTitles;
        this.mFragments = mFragments;
    }
    @Override
    public Fragment getItem(int position) {
        String str = mTitles[position];
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = Fragment_one.newInstance(str);
                break;
            case 1:
                fragment = Fragment_two.newInstance(str);
                break;
            case 2:
                fragment = Fragment_three.newInstance(str);
                break;
            case 3:
                fragment = Fragment_four.newInstance(str);
                break;
            case 4:
                fragment = Fragment_five.newInstance(str);
                break;
            case 5:
                fragment = Fragment_six.newInstance(str);
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    /**
     * 联动 TabLayout 上的 Title
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

}