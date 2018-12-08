package com.itrjp.shiro.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
@Data
public class Resources implements Serializable{
    private static final long serialVersionUID = -6812242071705361506L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 资源名称
     */
    private String name;


    /**
     * 资源url
     */
    @Column(name = "resUrl")
    private String resurl;

    /**
     * 资源类型   1:菜单    2：按钮
     */
    private Integer type;

    /**
     * 父资源
     */
    @Column(name = "parentId")
    private Integer parentid;

    /**
     * 排序
     */
    private Integer sort;

    @Transient
    private String checked;//是否选中

}