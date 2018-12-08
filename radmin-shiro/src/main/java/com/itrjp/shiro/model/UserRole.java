package com.itrjp.shiro.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "user_role")
public class UserRole implements Serializable{
    private static final long serialVersionUID = -916411139749530670L;
    @Column(name = "userId")
    private Integer userid;

    @Column(name = "roleId")
    private String roleid;
}