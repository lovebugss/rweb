package com.itrjp.rweb.service;

/**
 * Created by ren on 2018/11/25.
 */
public interface EmailService {


    void sendEmail();
    void sendEmail(String text);
    void sendEmail(String toUser,String text);
}
