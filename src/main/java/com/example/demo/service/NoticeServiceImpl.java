package com.example.demo.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Criteria;
import com.example.demo.domain.NoticeVO;
import com.example.demo.persistence.NoticeDAOImpl;

@Service(value="noticeService")
public class NoticeServiceImpl {

	

	private static final Logger logger = LoggerFactory.getLogger(NoticeServiceImpl.class);
	
	// NoticeVO 객체 주입
	@Inject
	private NoticeDAOImpl ndao;
	
	// 글 목록 조회
	public List<NoticeVO> noticeList(Criteria cri) {
		logger.debug("noticeList(Criteria cri) 호출");
		return ndao.noticeList(cri);
	}
	
	// 글쓰기
	public int noticeCount() {
		logger.debug("noticeCount() 호출 ");
		return 	ndao.noticeCount();
	}
	
	// 글쓰기
	public int write(NoticeVO noardVO) {
		logger.debug("write(NoticeVO noticeVO) 호출 ");
		return 	ndao.write(noardVO);
	}
	
	// 글읽기
	public NoticeVO read(Integer no_num) {
		logger.debug("read(Integer no_num) 호출 ");
		return 	ndao.read(no_num);
	}
	
	// 글삭제
	public int delete(Integer no_num) {
		logger.debug("delete(Integer no_num) 호출 ");
		return 	ndao.delete(no_num);
	}
	
	// 글수정
	public int update(NoticeVO noardVO) {
		logger.debug("update(NoticeVO noardVO) 호출 ");
		return 	ndao.update(noardVO);
	}

	
}
