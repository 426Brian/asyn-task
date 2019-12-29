package com.springboot01.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskApplicationTests {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    /**
     * 简单邮件发送
     */
    @Test
    public void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("来自1165380405 的邮件");
        message.setText("sringboot 测试发送邮件");
        //发送至我的谷歌邮箱
        message.setTo("redplumblossom197@gmail.com");
        message.setFrom("1165380405@qq.com");

        javaMailSender.send(message);
    }

    /**
     * 复杂邮件发送
     */

    @Test
    public void send() throws Exception{
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeHelper = new MimeMessageHelper(mimeMessage, true);

        mimeHelper.setSubject("复杂的邮件");
        mimeHelper.setText("<b style='color:red'> 复杂邮件测试");
        mimeHelper.setTo("redplumblossom197@gmail.com");
        mimeHelper.setFrom("1165380405@qq.com");

        mimeHelper.addAttachment("SendEmail", new File("E:\\Projects\\java_demo\\src\\main\\java\\com\\sendmail\\SendEmail.java"));

        javaMailSender.send(mimeMessage);

    }

}
