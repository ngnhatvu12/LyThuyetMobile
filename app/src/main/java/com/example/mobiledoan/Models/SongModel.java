package com.example.mobiledoan.Models;

public class SongModel {
    private String id;
    private String title;
    private String subtitle;
    private String url;
    private String coverURL;
    private String lyrics;

    // Default constructor
    public SongModel() {
        this.id = "";
        this.title = "";
        this.subtitle = "";
        this.url = "";
        this.coverURL = "";
        this.lyrics = "";
    }

    // Parameterized constructor
    public SongModel(String id, String title, String subtitle, String url, String coverURL, String lyrics) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.url = url;
        this.coverURL = coverURL;
        this.lyrics = lyrics;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCoverURL() {
        return coverURL;
    }

    public void setCoverURL(String coverURL) {
        this.coverURL = coverURL;
    }

    public void ifPresent(){}

    public  String getLyrics(){return lyrics; }
    public void  setLyrics(String lyrics) {this.lyrics =lyrics;}
}



