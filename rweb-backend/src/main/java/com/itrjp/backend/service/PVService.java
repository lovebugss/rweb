package com.itrjp.backend.service;

/**
 * Created by MAC on 2018/10/19.
 */
public interface PVService {

    /**
     * 通过文章id获取文章阅读量
     */
    Integer selectArticlePv(String id);

    /**
     * 设置文章阅读量
     * @param id
     * @return
     */
    boolean setArticlePv(String id);

    /**
     * 设置文章阅读量
     * @param id
     * @param readCount
     * @return
     */
    boolean updateArticlePv(String id, Integer readCount);
}
