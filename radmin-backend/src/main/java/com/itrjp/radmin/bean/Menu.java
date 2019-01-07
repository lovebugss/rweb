package com.itrjp.radmin.bean;

import com.itrjp.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

/**
 * Created by ren on 2018/11/3.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sys_menu")
public class Menu extends BaseEntity {

    private String name;
    private String path;
    private String icon;
    @Column(name = "order_num")
    private Integer orderNum;
    private String local;
    @Column(name = "parent_id")
    private String parentId;
    @Transient
    private List<Menu> children;

}
