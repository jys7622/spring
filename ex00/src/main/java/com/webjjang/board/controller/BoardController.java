package com.webjjang.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webjjang.board.service.BoardService;
import com.webjjang.myapp.HomeController;
import com.webjjang.util.PageObject;

@Controller
@RequestMapping("/board")
public class BoardController {
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	// 의존성 자동 주입(inject와 동일한 기능 -> Dependency Inject)
	@Autowired
	private BoardService service;
	//1. list
	@GetMapping("/list.do")
	public String list(PageObject pageObject, Model model) throws Exception{
		// 데이터를 받으면 처리 결과를 리퀘스트에 담는데, 스프링에서는 model에 담는다
		// model에 넣어주면 request에 담기도록 프로그램 되어있다.
		// 파라미터로 모델 객체를 전달 받아서 사용한다.
		// 페이지가 1보다 작으면 1페이지로 세팅해 준다.(페이지네이션 할 때 이전페이지누르면 1보다 작아지는 경우 방지)
		if(pageObject.getPage() < 1) pageObject.setPage(1);
		
		System.out.println("BoardController.list().pageObject -" + pageObject);
		model.addAttribute("list", service.list(pageObject));
		return "board/list";
	}
	//2. view
	//3. writeForm
	//3.1 write
	//4. updateForm
	//4.1 update
	//5. delete

}
