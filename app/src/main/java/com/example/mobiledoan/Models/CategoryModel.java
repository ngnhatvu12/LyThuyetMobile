package com.example.mobiledoan.Models;

import java.util.List;

public class CategoryModel {
    private String name;
    private String coverURL;
    private List<String> songs;

    public CategoryModel(String name, String coverURL, List<String> songs) {
        this.name = name;
        this.coverURL = coverURL;
        this.songs = songs;
    }

    // Empty constructor
    public CategoryModel() {
        this("", "", null);
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoverURL() {
        return coverURL;
    }

    public void setCoverURL(String coverURL) {
        this.coverURL = coverURL;
    }

    public List<String> getSongs() {
        return songs;
    }

    public void setSongs(List<String> songs) {
        this.songs = songs;
    }

    // toString method
    @Override
    public String toString() {
        return "CategoryModel{" +
                "name='" + name + '\'' +
                ", coverURL='" + coverURL + '\'' +
                ", songs=" + songs +
                '}';
    }
}
