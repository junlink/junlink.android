package com.example.juu79.moblielabs;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.juu79.moblielabs.Fragment.Fragment_five;
import com.example.juu79.moblielabs.Fragment.Fragment_four;
import com.example.juu79.moblielabs.Fragment.Fragment_one;
import com.example.juu79.moblielabs.Fragment.Fragment_six;
import com.example.juu79.moblielabs.Fragment.Fragment_three;
import com.example.juu79.moblielabs.Fragment.Fragment_two;
import com.example.juu79.moblielabs.adapter.HomeFragmentAdapter;

import java.util.Arrays;
import java.util.List;

import static android.support.design.widget.TabLayout.MODE_SCROLLABLE;
import static com.example.juu79.moblielabs.R.id.nav_news;
import static com.example.juu79.moblielabs.R.layout.fragment_one;


public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {
    //初始化各种控件
    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;
    private FloatingActionButton fab;

    // ViewPager的数据适配器
    private HomeFragmentAdapter mHomeFragmentAdapter;
    // TabLayout中的tab标题
    private String[] mTitles;

    private Fragment_one fragment_one;
    private Fragment_two fragment_two;
    private Fragment_three fragment_three;
    private Fragment_four fragment_four;
    private Fragment_five fragment_five;
    private Fragment_six fragment_six;
    // 填充到ViewPager中的Fragment
    private List<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        configViews();
        initNavigationView();
    }


    //初始化各种控件
    public void initview() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.myviewpager);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        fab = (FloatingActionButton) findViewById(R.id.fab);
    }

    //对控件进行设置
    public void configViews() {
        // 设置显示Toolbar
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mToolbar.setTitle("首页");
        // 设置Drawerlayout开关指示器，即Toolbar最左边的那个icon
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        mTitles = getResources().getStringArray(R.array.tab_titles);
        mHomeFragmentAdapter = new HomeFragmentAdapter(getSupportFragmentManager(), mTitles, mFragments);
        mViewPager.setAdapter(mHomeFragmentAdapter);
        mViewPager.addOnPageChangeListener(this);
        mTabLayout.setTabMode(MODE_SCROLLABLE);
        mTabLayout.setupWithViewPager(mViewPager); // 将TabLayout和ViewPager关联起来。
        mTabLayout.setTabsFromPagerAdapter(mHomeFragmentAdapter); // 给Tabs设置适配器
        mViewPager.setCurrentItem(0);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /**
     * 设置NavigationView中menu的item被选中后要执行的操作
     */
    public void initNavigationView() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                // Handle navigation view item clicks here.
                mToolbar.setTitle(item.getTitle());
                int id = item.getItemId();
                if (id == R.id.nav_homepage) {
                    mViewPager.setCurrentItem(0);
                } else if (id == nav_news) {
                    mViewPager.setCurrentItem(1);
                } else if (id == R.id.nav_projects) {
                    mViewPager.setCurrentItem(2);
                } else if (id == R.id.nav_papers) {
                    mViewPager.setCurrentItem(3);
                } else if (id == R.id.nav_game) {
                    mViewPager.setCurrentItem(4);
                } else if (id == R.id.nav_us) {
                    mViewPager.setCurrentItem(5);
                } else if (id == R.id.nav_blog) {
                    mViewPager.setCurrentItem(6);
                } else if (id == R.id.nav_message) {

                } else if (id == R.id.nav_team) {

                }
                mDrawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")


    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            // 按下的如果是BACK，同时没有重复.
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
            }
        }
        return true;
    }


    @Override
    public void onPageSelected(int position) {
        mToolbar.setTitle(mTitles[position]);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }


    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {

    }
}
