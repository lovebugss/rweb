package com.itrjp.rweb.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by MAC on 2018/10/22.
 */
@Data
@Table(name = "article_read_count")
@AllArgsConstructor
public class ArticleReadCount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private Integer readCount;


}
