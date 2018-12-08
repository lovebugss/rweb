package com.itrjp.shiro.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "role_resources")
public class RoleResources implements Serializable{
    private static final long serialVersionUID = -8559867942708057891L;
    @Id
    @Column(name = "roleId")
    private Integer roleid;

    @Id
    @Column(name = "resourcesId")
    private String resourcesid;

}