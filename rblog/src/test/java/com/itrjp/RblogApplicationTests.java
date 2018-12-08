package com.itrjp;

import com.itrjp.common.util.EmailUtil;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RblogApplicationTests {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private SpringTemplateEngine thymeleafEngine;

    @Test
    public void sendSimpleMail() throws Exception {

//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("r979668507@163.com");
//        message.setTo("979668507@qq.com");
//        message.setSubject("主题：简单邮件");
//        message.setText("测试邮件内容");
//
////        mailSender.send(message);
        EmailUtil.setMailSender(mailSender);
//        EmailUtil.sendEmail(null);
        IllegalAccessError error = new IllegalAccessError("参数错误");
        EmailUtil.sendExceptionInfo(error);
    }

    @Test
    public void sendAttachmentsMail() throws Exception {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("r979668507@163.com");
        helper.setTo("979668507@qq.com");
        helper.setSubject("主题：有附件");
        helper.setText("有附件的邮件");

        FileSystemResource file = new FileSystemResource(new File("weixin.jpg"));
        helper.addAttachment("附件-1.jpg", file);
        helper.addAttachment("附件-2.jpg", file);

        mailSender.send(mimeMessage);
    }

    @Test
    public void sendInlineMail() throws Exception {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("dyc87112@qq.com");
        helper.setTo("dyc87112@qq.com");
        helper.setSubject("主题：嵌入静态资源");
        helper.setText("<html><body><img src=\"cid:weixin\" ></body></html>", true);

        FileSystemResource file = new FileSystemResource(new File("weixin.jpg"));
        helper.addInline("weixin", file);

        mailSender.send(mimeMessage);
    }

    @Test
    public void sendTemplateMail() throws Exception {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("r979668507@163.com");
        helper.setTo("979668507@qq.com");
        helper.setSubject("主题：模板邮件");

        Map<String, Object> model = new HashedMap();
        model.put("username", "didi");
        Context context = new Context();
        context.setVariable("hello","a");
        String text = thymeleafEngine.process("email", context);
        helper.setText(text, true);

        mailSender.send(mimeMessage);
    }

}
