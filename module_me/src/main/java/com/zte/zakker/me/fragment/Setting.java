package com.zte.zakker.me.fragment;

public class Setting {
    private String name;
    private int imageId_name;
    private int imageId_right;
    public Setting(String name, int imageId_name, int imageId_right){
        this.name = name;
        this.imageId_name = imageId_name;
        this.imageId_right= imageId_right;
    }
    public String getName() {
        return name;
    }

    public int getImageId_name() {
        return imageId_name;
    }

    public int getImageId_right() {
        return imageId_right;
    }
}
