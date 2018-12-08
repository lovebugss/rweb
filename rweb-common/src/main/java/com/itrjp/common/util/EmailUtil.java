package com.itrjp.common.util;

import com.itrjp.common.entity.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.thymeleaf.spring5.SpringTemplateEngine;

/**
 * Created by ren on 2018/11/25.
 */
public class EmailUtil {

    private static JavaMailSender mailSender;
    private static SpringTemplateEngine thymeleafEngine;

    public static void sendEmail(Email email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("r979668507@163.com");
        message.setTo("979668507@qq.com");
        message.setSubject(email.getSubject());
        message.setText(email.getContent());

        mailSender.send(message);
    }
    public static void sendExceptionInfo(Throwable t){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("r979668507@163.com");
        message.setTo("979668507@qq.com");
        message.setSubject("异常报警");
        StringBuffer sb = new StringBuffer();
        sb.append("message:"+t.getMessage()+"\t");
        sb.append(t.toString());
        message.setText(sb.toString());

        mailSender.send(message);
    }
    public static void sendExceptionInfo(String text){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("r979668507@163.com");
        message.setTo("979668507@qq.com");
        message.setSubject("异常报警");

        message.setText(text);

        mailSender.send(message);
    }

    public static void setMailSender(JavaMailSender mailSender) {
        EmailUtil.mailSender = mailSender;
    }

    public static void setThymeleafEngine(SpringTemplateEngine thymeleafEngine) {
        EmailUtil.thymeleafEngine = thymeleafEngine;
    }
}
