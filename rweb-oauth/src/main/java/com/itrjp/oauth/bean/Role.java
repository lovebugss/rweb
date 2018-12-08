package com.itrjp.oauth.bean;

import lombok.Data;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
@Data
public class Role implements Serializable {
    private Long id; //编号
    private String role; //角色标识 程序中判断使用,如"admin"
    private String description; //角色描述,UI界面显示使用
    private List<Long> resourceIds; //拥有的资源
    private Boolean available = Boolean.FALSE; //是否可用,如果不可用将不会添加给用户


    public List<Long> getResourceIds() {
        if(resourceIds == null) {
            resourceIds = new ArrayList<Long>();
        }
        return resourceIds;
    }

    public String getResourceIdsStr() {
        if(CollectionUtils.isEmpty(resourceIds)) {
            return "";
        }
        StringBuilder s = new StringBuilder();
        for(Long resourceId : resourceIds) {
            s.append(resourceId);
            s.append(",");
        }
        return s.toString();
    }

    public void setResourceIdsStr(String resourceIdsStr) {
        if(StringUtils.isEmpty(resourceIdsStr)) {
            return;
        }
        String[] resourceIdStrs = resourceIdsStr.split(",");
        for(String resourceIdStr : resourceIdStrs) {
            if(StringUtils.isEmpty(resourceIdStr)) {
                continue;
            }
            getResourceIds().add(Long.valueOf(resourceIdStr));
        }
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }



}
