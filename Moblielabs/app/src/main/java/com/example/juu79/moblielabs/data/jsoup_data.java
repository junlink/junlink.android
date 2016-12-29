package com.example.juu79.moblielabs.data;

import android.util.Log;

import com.example.juu79.moblielabs.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by juu79 on 2016/12/20 0020.
 */

public class jsoup_data {

    public  static void getData(List<Article> articles) {
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
                String summary = temp_summary.textNodes().get(0).text();
                String title = temp.textNodes().get(0).text();
                articles.add(new Article(title,summary,R.mipmap.ic_launcher));
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
    }

}

