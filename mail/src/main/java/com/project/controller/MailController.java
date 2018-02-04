package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailController {
	
	@Autowired
    private JavaMailSender mailSender;
	
	@Value("${spring.mail.username}")
    private String sender;
	
	@RequestMapping("/send")
	public Object uploadFile() {
		SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo("842892290@qq.com");
        message.setSubject("测试");
        message.setText("测试邮件内容");
        mailSender.send(message);
		return "ok";
	}
}
