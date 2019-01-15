package com.itrjp.radmin.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author renjp
 * @Date 2019/1/15 14:09
 * @Version 1.0
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfo {
    private String username;
    private String password;
    private boolean remember;
}
