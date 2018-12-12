package com.itrjp.backend.model;

import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;

@Data
public class Foo {

    @Field("id")
    private String id;

    @Field("title")
    private String title;
    @Field("tag")
    private String tag;

    public Foo() {
    }

    public Foo(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public Foo(String id, String title, String tag) {
        this.id = id;
        this.title = title;
        this.tag = tag;
    }
}
