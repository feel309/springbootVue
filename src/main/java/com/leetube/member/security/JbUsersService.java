package com.leetube.member.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.leetube.member.persistence.MemberRepository;

@Service
public class JbUsersService implements UserDetailsService{
	
	@Autowired
	MemberRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("1. username---"+ username);
		
		return repo.findById(username).filter(m -> m != null)
				.map(m -> new JbSecurityUser(m)).get();
	}
	
}
