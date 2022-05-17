
 package com.webjjang.member.controller;
  
 import org.springframework.web.bind.annotation.RequestMapping;

import com.webjjang.member.service.MemberService;
import com.webjjang.member.vo.LoginVO;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
 import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.log4j.Log4j;
  
  //url자동생성
  
  @Controller //member 요청들어오면 매핑
  
  @RequestMapping("/member")
  
  
  @Log4j 
  public class MemberController {
	  
	  // 자동 DI
	  // MemberService에 @Service 어노테이션을 붙여줘야 생성된다.
	  @Autowired
	  private MemberService service;
	  
	  
  @GetMapping("/login.do")
  public String loginForm() { log.info("login 폼으로 이동"); 
  return "member/login";
  
  } // 사용자가 ID, PW 입력해서 보낸다 -> 받는다.
  // 로그인처리는 세션사용. 로그인정보에 맞는 정보를 db에서 꺼내와서 세션에 담는다.
  @PostMapping("/login.do")
  public String login(LoginVO invo, HttpSession session) throws Exception {
	  
	  log.info("로그인 처리 - invo : " + invo);
	  
	  session.setAttribute("login", service.login(invo));
	  
	  return "redirect : /board/list.do";
	  
  	}
  	// 로그아웃은 세션에있는 정보를 지워야하기 때문에 세션에 있는 데이터를 받는다.
  @GetMapping("/logout.do")
  	public String logout(HttpSession session) throws Exception {
  		// 로그아웃 처리 - session의 정보를 지운다. removeAttribute이용하여 사용.
	  
	  session.removeAttribute("login");
	  		 log.info("로그아웃 처리됨");
  		return "redirect : /board/list.do";
  	}
  	
 } 
  
 