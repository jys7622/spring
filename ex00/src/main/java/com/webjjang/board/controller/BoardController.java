package com.webjjang.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.webjjang.board.service.BoardService;
import com.webjjang.board.vo.BoardVO;
import com.webjjang.util.PageObject;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board")
public class BoardController {
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	// 의존성 자동 주입(inject와 동일한 기능 -> Dependency Inject)
	@Autowired
	private BoardService service;
	//1. list
	@GetMapping("/list")
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
	// 처리 결과를 request에 담아야 하는데 spring에서는 request가 모델에 존재.
	// 모델에 넣어주면 request에 담기도록 되어있다. 파라미터로 모델 객체를 전달 받아서 사용

	@GetMapping("/view.do")
	public String view(long no, int inc, Model model) throws Exception{

		System.out.println("BoardController.view().no, inc-" + no + "," +inc);

		// 글 내용 중에서 줄바꿈처리를 해야만 한다. \n -> <br>태그로 바꾼다.

		BoardVO vo = service.view(no, inc);  // view 메서드 호출하고 변수에 담아야 사용가능
		// vo를 받아서 set해서다시 넣어서 get으로 가져온 것을 \n을 br태그로 바꿔서 다시 set해서 집어넣는다
		vo.setContent(vo.getContent().replace("\n", "<br>"));
		model.addAttribute("vo", vo);
		
		return "board/view"; 
		
	}
	//3. writeForm
	@GetMapping("/write.do")
	public String WriteForm() throws Exception{
			
		// GetMapping에서 write.do 요청이 들어오면 write.jsp로 넘어가도록 설정
		return "board/write";
		}
	//3.1 write
	@PostMapping("/write.do")
	public String write(BoardVO vo) throws Exception{ 
		
		System.out.println("BoardController.write().vo-" + vo);
		service.write(vo);
		return "redirect:list.do";
	}
	//4. updateForm
	//view.jsp에서 no를 받아서 쓴다. 데이터를 가져오면 model이필요. 모델에 담아서 jsp로 넘긴다
	@GetMapping("/update.do")
	public String updateForm(long no, Model model) throws Exception{
		System.out.println("BoardController.updateForm().no-" + no);
		
		//updateForm에서 update하려고 할 때 조회수가 늘어나면 안되니까 increase값을 0으로 넘긴다.
		model.addAttribute("vo", service.view(no, 0));
		
		return "board/update";
	}
	//4.1 update
	@PostMapping("/update.do")
	public String update(BoardVO vo) throws Exception{
		System.out.println("BoardController.update().vo-" + vo);
		service.update(vo);
		
		return "redirect:view.do?no= " + vo.getNo() + "&inc=0";
		
	}
	//5. delete
	@GetMapping("/delete.do")
	public String delete(long no) throws Exception{
		System.out.println("BoardController.delete().no-" + no);
		//서비스에서 delete메소드를 호출하여 no를 넘겨라
		service.delete(no);
		return "redirect:list.do";
	}
	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	public String fileUpload(Model model, MultipartRequest multipartRequest, HttpServletRequest request) throws IOException{
		System.out.println("컨트롤러 요청들어옴");
		MultipartFile imgfile = multipartRequest.getFile("Filedata");
		Calendar cal = Calendar.getInstance();
		String fileName = imgfile.getOriginalFilename();
		String fileType = fileName.substring(fileName.lastIndexOf("."), fileName.length());
		String replaceName = cal.getTimeInMillis() + fileType;  
		
		String path = request.getSession().getServletContext().getRealPath("/")+File.separator+"resources/upload";
		FileUpload.fileUpload(imgfile, path, replaceName);
		model.addAttribute("path", path);
		model.addAttribute("filename", replaceName);
		return "board/file_upload";
	}

}