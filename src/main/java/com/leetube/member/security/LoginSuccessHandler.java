package com.leetube.member.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
	private static int TIME = 60 * 60;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,Authentication auth)
			throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		session.setAttribute("userName", auth.getName());
		System.out.println("3---"+session.getAttribute("userName"));
		request.getSession().setMaxInactiveInterval(TIME);
		super.onAuthenticationSuccess(request, response, auth);
	}
	
}
