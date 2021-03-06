package com.care.root.service;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	@Autowired JavaMailSender mailSender;
	public void sendMail(String to, String subject, String body) {
		MimeMessage message = mailSender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = 
					new MimeMessageHelper(message, true, "utf-8");
			helper.setTo(to); //받는 사람 메일 주소
			helper.setSubject(subject); //제목
			helper.setText(body, true); //내용 
			//true로 넣으면 html형식을 html형식으로 받음
			
			mailSender.send(message);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	   public void auth(HttpServletRequest request) {
		      HttpSession session = request.getSession();
		      String userid = "KimYeoJin";
		      String userkey = rand();
		      session.setAttribute(userid, userkey);
		      String body="<h2>안녕하세요 아뱅입니다</h2><hr>"
		            +"<h3>"+userid+" 님</h3>"
		            +"<p>인증하기 버튼을 누르면 로그인 됩니다</p>"
		            +"<a href='http://localhost:8015"
		            +request.getContextPath()+"/auth_check?userid="
		            +userid+"&userkey="+userkey+"'>인증하기</a>";
		      sendMail("kimduwls3@gmail.com","이메일 인증입니다",body);
		   }
		   private String rand() {
		      Random ran = new Random();
		      String str="";
		      int num;
		      while(str.length() != 20) {
		         num = ran.nextInt(75)+48;//0~74 + 48 (숫자,소문자, 대문자)
		         if((num>=48 && num<=57)||(num>=65 && num<=90)||(num>=97 && num<=122)) {
		            str+=(char)num;
		         }else {
		            continue;
		         }
		      }
		      return str;
	   }	
}
