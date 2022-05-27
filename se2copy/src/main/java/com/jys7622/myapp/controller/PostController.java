package com.jys7622.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jys7622.myapp.VO.PostVO;
import com.jys7622.myapp.mapper.PostMapper;

@Controller
@RequestMapping(value = "post")
public class PostController {

	
	  @Autowired private PostMapper postMapper;
	  
	 

	@GetMapping(value = "list.do")
	private String list(Model model) {
		List<PostVO> posts = postMapper.getSearch();
		model.addAttribute("posts", posts);
		return "post/list";
	}
}
