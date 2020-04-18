package com.leetube.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leetube.member.domain.Member;
import com.leetube.member.persistence.MemberRepository;

import lombok.extern.java.Log;

@Controller
@Log
public class MemberController {
	
	@Autowired
	PasswordEncoder pwEncoder;
	
	@Autowired
	MemberRepository memberRepository;
	
	@GetMapping(path = "/")
	public String getMain() {
		log.info("getMain");
		return "index.html";
	}
	
	@GetMapping(path = "/home")
	public @ResponseBody Member getHome(HttpSession session) {
		Member member = new Member();
		log.info("home uid" + session.getAttribute("userName"));
		member.setUid((String) session.getAttribute("userName"));
		
		return member;
	}
	
	@GetMapping("/join")
	public String getJoin() {
		log.info("getJoin");
		return "index";
	}
	
	@PostMapping("/join")
	public @ResponseBody String postJoin(@RequestBody Member member, HttpSession session) {
		System.out.println("---------"+ member);
		String encryptPw = pwEncoder.encode(member.getUpw());
		log.info("hash password: " + encryptPw);
		member.setUpw(encryptPw);
		memberRepository.save(member);
		return "success";
	}
	
}
