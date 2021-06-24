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

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
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
    public Blog( String title, String kind, String schema, String content,  Account author, Timestamp creationTime,Long pageView) {
        this.title = title;
        this.kind = kind;
        this.schema = schema;
        this.author = author;
        this.creationTime = creationTime;
        this.content = content;
        this.pageView=pageView;
    }
    public Blog(Long id, String kind, String schema, String content, Timestamp modification) {
        this.id=id;
        this.kind = kind;
        this.schema = schema;
        this.content = content;
        this.modification=modification;
    }


}
