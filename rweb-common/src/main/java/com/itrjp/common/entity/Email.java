package com.itrjp.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.File;
import java.util.Map;
import java.util.Set;

/**
 * Created by ren on 2018/11/25.
 */
@Data
@AllArgsConstructor
public class Email {
    private Set<String> toSet;  //收件人
    private String subject;  //主题
    private String content;  //正文
    private boolean isHtml;  //正文是否是HTML
    private Map<String, File> attachments;  //附件路径
    private boolean isAttachment;  //是否有附件

    public Email() {

    }
}
