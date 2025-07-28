package com.example.instagram.data;

public class Post {
    private int id;
    private int userImage;
    private int mainImage;
    private String caption;
    private String commentText;
    private String user_name;
    private int likeCount;
    private boolean isLiked;
    private boolean isSaved;

    public Post(int id, int userImage, int mainImage, String caption, String likeText, String commentText, String user_name) {
        this.id = id;
        this.userImage = userImage;
        this.mainImage = mainImage;
        this.caption = caption;
        this.commentText = commentText;
        this.user_name = user_name;

        try {
            this.likeCount = Integer.parseInt(likeText.split(" ")[0]);
        } catch (Exception e) {
            this.likeCount = 0;
        }

        this.isLiked = false;
        this.isSaved = false; // default not saved
    }


    public boolean isSaved() {
        return isSaved;
    }

    public void toggleSaved() {
        isSaved = !isSaved;
    }

    public int getId() {
        return id;
    }

    public int getUserImage() {
        return userImage;
    }

    public int getMainImage() {
        return mainImage;
    }

    public String getCaption() {
        return caption;
    }

    public String getCommentText() {
        return commentText;
    }

    public String getUser_name() {
        return user_name;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public String getLikedText() {
        return likeCount + " likes";
    }

    public void toggleLike() {
        if (isLiked) {
            likeCount--;
            isLiked = false;
        } else {
            likeCount++;
            isLiked = true;
        }
    }
}