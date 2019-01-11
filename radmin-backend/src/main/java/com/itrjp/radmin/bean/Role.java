package com.itrjp.radmin.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
public class Role implements Serializable{
    private static final long serialVersionUID = -6140090613812307452L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "roleDesc")
    private String roledesc;
    @Transient
    private Integer selected;

}