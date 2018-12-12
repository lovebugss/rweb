package com.itrjp.backend.vo;

import com.itrjp.backend.model.Article;
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
