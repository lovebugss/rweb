package com.itrjp.common.util;

import java.io.UnsupportedEncodingException;

/**
 * 传值中文乱码解决方案
 *
 * @author renjp
 */
public class EncodingTool {
    /**
     * 将ISO-8859-1编码转换为 UTF-8
     *
     * @param str
     * @return
     */
    public static String encodeStr(String str) {
        try {
            return new String(str.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 转换为HTML编码
     *
     * @param content
     * @return
     */
    public static String htmlEncode(String content) {
        if (content == null) return "";
        String html = content;

        //    html = html.replace( "'", "&apos;");
        html = html.replaceAll("&", "&amp;");
        html = html.replace("\"", "&quot;");  //"
        html = html.replace("\t", "&nbsp;&nbsp;");// 替换跳格
        html = html.replace(" ", "&nbsp;");// 替换空格
        html = html.replace("<", "&lt;");

        html = html.replaceAll(">", "&gt;");

        return html;
    }

    /**
     * 转换为java转义字符
     *
     * @param content
     * @return
     */
    public static String htmlunEncode(String content) {
        if (content == null) return "";
        String html = content;

        //    html = html.replace( "'", "&apos;");
        html = html.replaceAll("&amp", "&;");
        html = html.replace("&quot;", "\"");  //"
        html = html.replace("&nbsp;&nbsp;", "\t");// 替换跳格
        html = html.replace("&nbsp;", " ");// 替换空格
        html = html.replace("&lt;", "<");
        html = html.replaceAll("&gt;", ">");

        return html;
    }
}
