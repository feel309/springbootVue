package com.leetube.member.persistence;

import org.springframework.data.repository.CrudRepository;

import com.leetube.member.domain.Member;

public interface MemberRepository extends CrudRepository<Member, String>{
}
