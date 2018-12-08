package com.itrjp.rweb.systemlog;

import java.lang.annotation.*;

/**
 * 主要用于日志打印
 * @author renjp
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLog {
    /**
     * 动作描述
     */
    String description()  default "";

    /**
     * 操作类型
     */
    enum OperateType{ ADD,UPDATE, DELETE, SEARCH ,LOGIN,LOGOUT,DOWNLOAD,UPLOAD ,START,STOP};

    /**
     * 操作类型，默认搜索
     * @return
     */
    OperateType type() default OperateType.SEARCH;

    /**
     * 模块
     * @return
     */
    String modular() default "";

}
