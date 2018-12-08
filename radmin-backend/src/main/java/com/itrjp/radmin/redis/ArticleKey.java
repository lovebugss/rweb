package com.itrjp.radmin.redis;

/**
 * Created by MAC on 2018/10/19.
 */
public class ArticleKey extends BasePrefix{
    /**
     * 阅读量超时时间，默认2分钟。
     */
    private String field;
    public static final int READ_COUNT_EXPIRE = 60 * 2;
    public static ArticleKey readCount = new ArticleKey(0,"readCount");
    public static ArticleKey reader = new ArticleKey(READ_COUNT_EXPIRE,"reader");

    private ArticleKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
}
