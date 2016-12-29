package com.example.juu79.moblielabs.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.juu79.moblielabs.R;
import com.example.juu79.moblielabs.adapter.ListviewAdapter;
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
public class Fragment_four extends Fragment {

    ListView listView;
    private List<Article> article=new ArrayList<>();

    public static Fragment_four newInstance(String str) {
        Fragment_four fragment = new Fragment_four();

        Bundle bundle = new Bundle();
        bundle.putString("four", str);

        fragment.setArguments(bundle);

        return  fragment;
    }
    private void initNewsDatas() {

        String summary;
        String title;
//     jsoup_data.getData(article);
        try {
            Document doc= Jsoup.connect("http://www.edulab.cn/lab.php?mod=paper&fid=50").get();
//            File input = new File("file:///android_assets/news.html");
//            Document doc=Jsoup.parse(input, "UTF-8", "http://www.edulab.cn/lab.php?mod=news&fid=50");

//            Element masthead = doc.select("div.wp div.ct2 wp cl div.bm_c xld").first();
//            Element masthead = doc.select("z").first();
//            Element mashead =doc.select("div.wp div.ct2 wp cl div.lab_mn div.bm_vw ").first();
//              Elements title=mashead.select("div.bm_h cl").select("h1.xs2");
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
//            for (int index = 0; index < titleElements.size(); index++) {
//                temp = titleElements.get(index);
//                temp_summary=summaryElements.get(index);
//                String titles = temp.textNodes().get(0).text();
//                String summarys = temp_summary.textNodes().get(0).text();
//                articles.add(new Article(titles,summarys,R.mipmap.ic_launcher));
//                Log.e("x","xiangqing"+titles);
//                Log.e("x","xiangqing"+summarys);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//       article.add(new Article("第八届蓝桥杯大赛火热 ...","西南科技大学信息学院蓝桥杯大赛报名",R.mipmap.ic_launcher));
//       article.add(new Article("智能终端实验室网站正 ...","历经半年多时间，在实验室老师和同学的共同努力下，智能终端实验室网站正式上线",R.mipmap.ic_launcher));

    }
    Runnable runnable2 = new Runnable(){
        @Override
        public void run() {
            //
            // TODO: http request.
            //
            initNewsDatas();


        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        View view = inflater.inflate(R.layout.fragment_four, container, false);
        listView = (ListView) view.findViewById(R.id.list_papers);
        new Thread(runnable2).start();
        listView.setAdapter(new ListviewAdapter(getContext(),article));
        return view;
    }

}
