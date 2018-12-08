package com.itrjp.oauth.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-17
 * <p>Version: 1.0
 */
@Data
public class Client implements Serializable {

    private Long id;
    private String clientName;
    private String clientId;
    private String clientSecret;
}
