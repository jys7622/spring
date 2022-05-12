package com.webjjang.board.mapper;

import java.util.List;

import com.webjjang.board.vo.BoardVO;
import com.webjjang.util.PageObject;

public interface BoardMapper {
	
	
	// dao에서 작성한 메서드 형식으로 만들어준다.
	// interface만 만들어 두면 Mybatis 라이브러리에서 DAO를 대신 만들어 준다.
	// 주고 받는 데이터 타입 정의, SQL 문이 필요하다, 처리 명령문(insert, update등). BoardMapper.xml에 저장
	
	// 1. 리스트
	// List<BoardVO>는 데이터베이스에 BoardVO객체가 담겨있는 LIST를 달라고 요청
	//throws Exception은 추상클래스 선언만하고 사용하지 않는다는 의미.
	public List<BoardVO> list(PageObject pageObject) throws Exception; 
	// 2. 전체 데이터 개수
	public long getTotalRow(PageObject pageObject) throws Exception;
	// 2-1.보기
	public BoardVO view(long no) throws Exception;
	// 2-2. 조회수 1증가
	public int increase(long no) throws Exception;
	// 3. 글쓰기
	public int write(BoardVO vo) throws Exception; 
	// 4. 수정
	public int update(BoardVO vo) throws Exception; 
	// 5. 삭제
	public int delete(long no) throws Exception; 
	
}
