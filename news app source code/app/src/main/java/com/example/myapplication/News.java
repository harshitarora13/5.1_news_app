package com.example.myapplication;

import java.io.Serializable;

public class News implements Serializable {
    private String description;
    private int imageResource;
    private String channelName;

    public News(String channelName, int imageResource, String description) {
        this.description = description;
        this.imageResource = imageResource;
        this.channelName = channelName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
}