package com.itrjp.shiro.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@ToString
public class User implements Serializable{
    private static final long serialVersionUID = -8736616045315083846L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    /**
     * 是否启用
     */
    private Integer enable;

}