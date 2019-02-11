package com.wallpaperhub.akaks09developers.wallpaperhub.Model;

public class weekModel {
    private String likes, downloads, day, img_url;

    public weekModel() {
    }

    public weekModel(String likes, String downloads, String day, String img_url) {
        this.likes = likes;
        this.downloads = downloads;
        this.day = day;
        this.img_url = img_url;
    }

    public String getLikes() {
        return likes;
    }

    public String getDownloads() {
        return downloads;
    }

    public String getDay() {
        return day;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public void setDownloads(String downloads) {
        this.downloads = downloads;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
