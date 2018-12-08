package com.itrjp.radmin.bean;

import lombok.Data;

import javax.persistence.Entity;
import java.util.List;

/**
 * Created by ren on 2018/11/4.
 */
@Data
@Entity
public class Role {
//    @Id
//    @GeneratedValue
    private String id;
    private String roleName;
    private List resources;
}
