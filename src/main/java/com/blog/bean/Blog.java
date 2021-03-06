package com.blog.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Blog implements Serializable {
    private Long id;
    private String title;
    private String kind;
    private String schema;
    private Long pageView;
    private Account author;
    private Timestamp creationTime;
    private Timestamp modification;
    private String content;



    private String comment;

    public Blog(Long id, String title, String kind, String schema, Long pageView, Account author, Timestamp creationTime, Timestamp modification, String content, String comment) {
        this.id = id;
        this.title = title;
        this.kind = kind;
        this.schema = schema;
        this.pageView = pageView;
        this.author = author;
        this.creationTime = creationTime;
        this.modification = modification;
        this.content = content;
        this.comment = comment;
    }

    public Blog(String title, String kind, String schema, String content, Account account, Timestamp timestamp, long l) {
        this.title = title;
        this.kind = kind;
        this.schema = schema;
        this.author = account;
        this.creationTime = timestamp;
        this.pageView = l;
        this.content = content;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public Long getPageView() {
        return pageView;
    }

    public void setPageView(Long pageView) {
        this.pageView = pageView;
    }

    public Account getAuthor() {
        return author;
    }

    public void setAuthor(Account author) {
        this.author = author;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public Timestamp getModification() {
        return modification;
    }

    public void setModification(Timestamp modification) {
        this.modification = modification;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", kind='" + kind + '\'' +
                ", schema='" + schema + '\'' +
                ", pageView=" + pageView +
                ", author=" + author +
                ", creationTime=" + creationTime +
                ", modification=" + modification +
                ", content='" + content + '\'' +
                '}';
    }

    public Blog() {
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Blog(Long id, String title, String kind, String schema, Long pageView, Account author, Timestamp creationTime, Timestamp modification, String content) {
        this.id = id;
        this.title = title;
        this.kind = kind;
        this.schema = schema;
        this.pageView = pageView;
        this.author = author;
        this.creationTime = creationTime;
        this.modification = modification;
        this.content = content;
    }
}
