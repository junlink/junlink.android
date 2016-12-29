package com.example.juu79.moblielabs.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
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
import com.example.juu79.moblielabs.data.jsoup_data;

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
public class Fragment_one extends Fragment implements SwipeRefreshLayout.OnRefreshListener , MyRecyclerViewAdapter.OnItemClickListener{
    private RecyclerView mRecyclerView;
    private MyRecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    //获取 fragment 依赖的 Activity，方便使用 Context
    private Activity mAct;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private MyRecyclerViewAdapter mRecyclerViewAdapter;
    private List<Article> article=new ArrayList<>();

    public static Fragment_one newInstance(String str) {
        Fragment_one fragment = new Fragment_one();
        Bundle bundle = new Bundle();
        bundle.putString("one", str);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Bundle bundle = getArguments();

        View view = inflater.inflate(R.layout.fragment_one, container, false);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.id_swiperefreshlayout);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.id_recyclerview);

        mSwipeRefreshLayout.setColorSchemeResources(R.color.main_blue_light, R.color.main_blue_dark);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        mLayoutManager =new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerViewAdapter = new MyRecyclerViewAdapter(article,getActivity());
        mRecyclerViewAdapter.setOnItemClickListener(this);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        return view;
    }

   private void initNewsDatas() {
       new Thread(new Runnable(){
           String summary;
           String title;
           @Override
           public void run() {
               try {
                   Document doc= Jsoup.connect("http://www.edulab.cn/lab.php?mod=paper&fid=50").get();
                   Elements mash=doc.select("div.bbda");
                   Log.e("x","xiangqing"+mash.text());
                   Elements titles= mash.select(" div.paper_title").select("a");
                   Elements summarys=mash.select("div.paper_msg").select("a");
                   Element temp;
                   Element temp_summary;
                   for(int i=0;i<mash.size();i++){
                       temp=titles.get(i);
                       temp_summary=summarys.get(i);
                       summary = temp_summary.textNodes().get(0).text();
                       title= temp.textNodes().get(0).text();
                       article.add(new Article(title,summary,R.mipmap.ic_launcher));
                   }
               } catch (IOException e) {
                   e.printStackTrace();
               }
               //耗时操作，完成之后发送消息给Handler，完成UI更新；
               mHandler.sendEmptyMessage(0);

               //需要数据传递，用下面方法；
               Message msg =new Message();
               msg.obj = article;//可以是基本类型，可以是对象，可以是List、map等；
               mHandler.sendMessage(msg);
           }

       }).start();
//     jsoup_data.getData(article)
//       article.add(new Article("第八届蓝桥杯大赛火热 ...","西南科技大学信息学院蓝桥杯大赛报名",R.mipmap.ic_launcher));
//       article.add(new Article("智能终端实验室网站正 ...","历经半年多时间，在实验室老师和同学的共同努力下，智能终端实验室网站正式上线",R.mipmap.ic_launcher));

   }

    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    //完成主界面更新,拿到数据
                    String data = (String)msg.obj;
                    initNewsDatas();
//                    textView.setText(data);

                    break;
                default:
                    break;
            }

        }
    };
    @Override
    public void onRefresh() {
        mSwipeRefreshLayout.setRefreshing(false);
        int temp = (int) (Math.random() * 10);
//        mRecyclerViewAdapter.mArticle.add(0, "new" + temp,);
//        mRecyclerViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public void onItemLongClick(View view, int position) {

    }
}