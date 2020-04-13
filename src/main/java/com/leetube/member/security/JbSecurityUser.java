package com.leetube.member.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.leetube.member.domain.Member;
import com.leetube.member.domain.MemberRole;

import lombok.Getter;

@Getter
public class JbSecurityUser extends User{

	private static final String ROLE_PREFIX = "ROLE_";
	
	private Member member;
	private String memberStr;
	
	//생성자
	public JbSecurityUser(Member member) {
		super(member.getUid(), member.getUpw(), makeGrantedAuthority(member.getRoles()));
		
		System.out.println("2----");
		this.member = member;
		this.memberStr = member.getUid();
	}
	
	private static List<GrantedAuthority> makeGrantedAuthority(List<MemberRole> roles) {
		List<GrantedAuthority> list = new ArrayList<>();
		roles.forEach(role -> list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role.getRoleName())));
		return list;
	}

}
