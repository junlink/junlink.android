package com.example.juu79.moblielabs.data;

/**
 * Created by juu79 on 2016/12/18 0018.
 */

public class Article {
    private String title;
    private String summary;
    private int imageUrl;
//    private String postTime;

    public Article(String title, String summary, int imageUrl) {
        this.title = title;
        this.summary = summary;
        this.imageUrl = imageUrl;
//        this.postTime = postTime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSummary() {
        return summary;
    }


    public void setImageUrl(int imageUrl){
        this.imageUrl = imageUrl;
    }

    public int getImageUrl(){
        return imageUrl;
    }

//    public void setPostTime(String postTime){
//        this.postTime = postTime;
//    }
//
//    public String getPostTime(){
//        return postTime;
//    }

}