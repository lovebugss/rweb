package com.itrjp.backend.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Transient;

/**
 * Created by ren on 2018/9/1.
 */
@Data
public class ArticleVo {
    private Integer readCount;

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    protected String original;

    protected String tags;

    protected String description;

    protected String articleTitle;
    @Transient
    protected String content;
    @Transient
    protected String date;

    @Column(name = "img_url")
    protected String imgUrl;


}
