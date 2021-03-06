package com.webjjang.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.webjjang.board.mapper.BoardMapper;
import com.webjjang.board.vo.BoardVO;
import com.webjjang.util.PageObject;

// 서비스 자동생성 어노테이션 
// @Controller, @Service, @Repository, @Component, RestController
// -> servlet-context.xml에 scan 패키지 안쪽에 존재해야됨

@Service
public class BoardService {
	
	//service 안에는 dao가 필요하지만 dao대신에 mapper를 사용
	// 인터페이스로 만들어놓은 BoardMapper에 mybatis가 dao를 생성 -> 만들어진 dao를 new로 생성해서
	// mapper에 집어넣는다.
	@Inject
	private BoardMapper mapper;

	// setter가 있어야 생성해서 파라미터로 전달해서 위의 mapper에 전달
	// 밖에서 생성한것을 세터의 파라미터인 mapper에 전달 -> this.mapper = mapper; 오른쪽 mapper에 전달 -> 왼쪽 mapper에 전달
	// 이 과정을 자동으로 할 수 있도록 하는것이 Inject
	
	/*
	 * public void setMapper(BoardMapper mapper) { this.mapper = mapper; }
	 */

	 // 1.list
		public List<BoardVO> list(PageObject pageObject) throws Exception{
			// 전체 데이터 개수 가져오기 처리를 해줘야 시작 줄과 끝줄이 계산된다. 없으면 데이터를 안가져 온다.
			pageObject.setTotalRow(mapper.getTotalRow(pageObject));
			System.out.println("BoardService.list().pageObject -" + pageObject);
			return mapper.list(pageObject);
		}
	 // 2. view
	 public BoardVO view (long no, int inc) throws Exception{
		 System.out.println("BoardService.view().no, inc -" + no +"," + inc);
		 if(inc == 1) mapper.increase(no);
		 return mapper.view(no);

	 }
	 // 3. write
	 public int write(BoardVO vo) throws Exception{
		 System.out.println("BoardService.write().vo -" + vo);
		 return mapper.write(vo);
		 
	 }
	 // 4. update
	 public int update(BoardVO vo) throws Exception{
		 System.out.println("BoardService.update().vo -" + vo);
		 return mapper.update(vo);
	 }
	 
	 // 4. delete
	 public int delete(long no) throws Exception{
		 System.out.println("BoardService.delete().no -" + no);
		 return mapper.delete(no);
	 }
	
}
