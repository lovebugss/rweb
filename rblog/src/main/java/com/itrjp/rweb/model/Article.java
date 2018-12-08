package com.itrjp.rweb.model;


import com.itrjp.common.entity.BaseEntity;
import com.itrjp.common.util.DateUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class Article extends BaseEntity {

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