package com.itrjp.common.util;


import com.itrjp.common.entity.BaseEntity;

import java.util.Date;

/**
 * Created by ren on 2018/10/18.
 */
public class VSUtils {
    public static final int PAGE_NUMBER=1;
    public static final int PAGE_SIZE=10;

    /**
     * 增加操作的时候,调用当前方法,对共用字段(createBy和createDate)进行初始化
     * @param baseEntity
     */
    public static void insertInit(BaseEntity baseEntity) {
        if(HelpUtils.isNotEmpty(baseEntity)){
            baseEntity.setCreateBy("admin");
            baseEntity.setCreateTime(new Date());
            baseEntity.setActiveFlag(1);
            /* 主键处理 */
            if (HelpUtils.isEmpty(baseEntity.getId())) {
                baseEntity.setId(HelpUtils.getUUID());
            }
        }
    }
    /**
     * 增加操作的时候,调用当前方法,对共用字段(createBy和createDate)进行初始化
     * @param baseEntity
     */
    public static void insertInitByVdAdmin(BaseEntity baseEntity) {
        if(HelpUtils.isNotEmpty(baseEntity)){
            baseEntity.setCreateBy("vd_admin");
            baseEntity.setCreateTime(new Date());
            baseEntity.setActiveFlag(1);
            /* 主键处理 */
            if (HelpUtils.isEmpty(baseEntity.getId())) {
                baseEntity.setId(HelpUtils.getUUID());
            }
        }
    }


    /**
     * 修改操作的时候,调用当前方法,对共用字段(updateBy和updateDate)进行修改
     * @param baseEntity
     */
    public static void updateInit(BaseEntity baseEntity) {
        if(HelpUtils.isNotEmpty(baseEntity)){
            baseEntity.setUpdateBy("admin");
            baseEntity.setUpdateTime(new Date());
        }
    }
    /**
     * 修改操作的时候,调用当前方法,对共用字段(updateBy和updateDate)进行修改
     * @param baseEntity
     */
    public static void updateInitByVdAdmin(BaseEntity baseEntity) {
        if(HelpUtils.isNotEmpty(baseEntity)){
            baseEntity.setUpdateBy("vd_admin");
            baseEntity.setUpdateTime(new Date());
        }
    }
}
