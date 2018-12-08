package com.itrjp.rweb.vo;

import com.itrjp.rweb.model.Article;
import lombok.Data;

/**
 * Created by ren on 2018/9/1.
 */
@Data
public class ArticleVo extends Article{
    private Integer readCount;

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }




}
