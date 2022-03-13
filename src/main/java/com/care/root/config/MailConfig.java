package com.care.root.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
    @Bean
    public static JavaMailSender mailSender() {
        JavaMailSenderImpl jms = new JavaMailSenderImpl();
        jms.setHost("smtp.gmail.com"); //구글 제공, 메일 서버 설정
        jms.setPort(587); //구글 제공, 메일 서버 포트
        jms.setUsername("kimduwls3@gmail.com");
        jms.setPassword("Je8100je!!");

        Properties prop = new Properties();
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true"); 
        prop.setProperty("mail.smtp.starttls.enable", "true");
      
        prop.setProperty("mail.debug", "true");
        
        jms.setJavaMailProperties(prop);

        return jms;
    }

}
