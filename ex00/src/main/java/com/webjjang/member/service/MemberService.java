package com.webjjang.member.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.webjjang.member.mapper.MemberMapper;
import com.webjjang.member.vo.LoginVO;


@Service
public class MemberService {
	
	// 메퍼를 통해서 DI를 자동으로
	@Inject
	private MemberMapper mapper;
	//로그인
	//Member.xml을 이용해서 service를 작성
	
	public LoginVO login(LoginVO invo) throws Exception{
		return mapper.login(invo);
	}
}
