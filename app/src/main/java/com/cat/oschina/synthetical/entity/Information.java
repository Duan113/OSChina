package com.cat.oschina.synthetical.entity;

public class Information {
    private String author;
    private long id;
    private String title;
    private String  type;
    private long authorid;
    private String  pubDate;
    private String commentCount;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String  type) {
        this.type = type;
    }

    public long getAuthorid() {
        return authorid;
    }

    public void setAuthorid(long authorid) {
        this.authorid = authorid;
    }

    public String  getPubDate() {
        return pubDate;
    }

    public void setPubDate(String  pubDate) {
        this.pubDate = pubDate;
    }

    public String  getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }
}
