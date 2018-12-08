package com.itrjp.radmin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import java.util.List;

/**
 * Created by ren on 2018/11/3.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
//    @Id
//    @GeneratedValue
    private String id;
    private String resName;
    private String resKey;
    private String resIcon;
    private List<Menu> children;

    public Menu(String id, String resName, String resKey, String resIcon) {
    }
}
