package com.itrjp.oauth.bean;

import lombok.Data;

import java.io.Serializable;

/**
 *
 */
@Data
public class App implements Serializable {
    private Long id;
    private String name;
    private String appKey;
    private String appSecret;
    private Boolean available = Boolean.FALSE;
}
