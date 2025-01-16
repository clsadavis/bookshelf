package com.aca.bookshelf.model;

public class Hashtag {
    private String hashtagName;
    private String description;
    private Integer hashtagId;

    public Integer getHashtagId() {
        return hashtagId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHashtagName() {
        return hashtagName;
    }

    public void setHashtagName(String hashtagName) {
        this.hashtagName = hashtagName;
    }
}
