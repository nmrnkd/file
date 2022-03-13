package com.care.root.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.service.MailService;

@Controller
public class MailController {
	@Autowired MailService ms;

	@GetMapping("sendmail")
	public void sendMail(HttpServletResponse response) throws IOException {
//		ms.sendMail("kimduwls3@gmail.com", "여진아 코딩 열심히 하자", "안 하면 죽음뿐...");
		StringBuffer sb = new StringBuffer(); //str += ~로 쓰는 거보다 처리 속도가 빠름
		sb.append("<h1>제품 소개</h1>");
		sb.append("<a href=\"https://www.netflix.com/kr/\">");
		sb.append("<img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTDkvFCLSMbUU6Bqb1m-0y3LPAQ7_Gcs-PNZw&usqp=CAU\">");
		sb.append("</a>");
		String str = sb.toString();
		ms.sendMail("kimduwls3@gmail.com","광고", str);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("메일 전송 완료");
	}
	@GetMapping("auth_form")
	public String authForm() {
		return "auth";
	}
	@GetMapping("auth")
	public String auth(HttpServletRequest request) {
		ms.auth(request);
		return "redirect:https://www.google.com/";
	}
	@GetMapping("auth_check")
	public String authCheck(@RequestParam String userid,
							@RequestParam String userkey,
							HttpSession session) {
		String sessionKey = (String)session.getAttribute(userid);
		if(sessionKey != null) {
			if(sessionKey.equals(userkey)) {
				session.setAttribute("userid", userid);
			}
		}
		
		return "redirect:auth_form";
	}
}
