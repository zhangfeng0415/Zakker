package com.zte.zakker.automation.fragment;

public class PlayWay {
    private String title;
    private String text;
    private int imageId_name;
    private int imageId_right;
    public PlayWay(int imageId_name, String title, String text, int imageId_right){
        this.imageId_name = imageId_name;
        this.title = title;
        this.text= text;
        this.imageId_right = imageId_right;
    }
    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public int getImageId_name() {
        return imageId_name;
    }

    public int getImageId_right() {
        return imageId_right;
    }
}
