package com.blog.bean;

import java.io.Serializable;

public class Kind implements Serializable {
    private String kind;

    @Override
    public String toString() {
        return "Kind{" +
                "kind='" + kind + '\'' +
                '}';
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Kind() {
    }

    public Kind(String kind) {
        this.kind = kind;
    }
}
