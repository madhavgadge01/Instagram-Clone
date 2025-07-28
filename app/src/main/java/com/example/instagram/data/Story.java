package com.example.instagram.data;

public class Story {
    private int id;
    private String userName;
    private int storyImage;

    public Story(int id, String userName, int storyImage) {
        this.id = id;
        this.userName = userName;
        this.storyImage = storyImage;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public int getStoryImage() {
        return storyImage;
    }
}