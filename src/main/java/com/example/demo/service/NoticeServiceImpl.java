package com.example.demo.service;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Criteria;
import com.example.demo.domain.NoticeVO;
import com.example.demo.persistence.NoticeDAOImpl;

import lombok.RequiredArgsConstructor;

@Service(value="noticeService")
@RequiredArgsConstructor
public class NoticeServiceImpl {

	

	private static final Logger logger = LoggerFactory.getLogger(NoticeServiceImpl.class);
	
	private final NoticeDAOImpl ndao;
	
	// 글 목록 조회
	public List<NoticeVO> noticeList(Criteria cri) {
		logger.info("noticeList(Criteria cri) 호출");
		return ndao.noticeList(cri);
	}
	
	// 전체 글 수
	public int noticeCount() {
		logger.info("noticeCount() 호출 ");
		return 	ndao.noticeCount();
	}
	
	// 글쓰기
	public int write(NoticeVO noticeVO) {
		logger.info("write(NoticeVO noticeVO) 호출 " + noticeVO);
		return 	ndao.write(noticeVO);
	}
	
	// 글읽기
	public NoticeVO read(Integer noNum) {
		logger.info("read(Integer no_num) 호출 ");
		return 	ndao.read(noNum);
	}
	
	// 글삭제
	public int delete(Integer noNum) {
		logger.info("delete(Integer no_num) 호출 ");
		return 	ndao.delete(noNum);
	}
	
	// 글수정
	public int update(NoticeVO noticeVO) {
		logger.info("update(NoticeVO noardVO) 호출 ");
		return 	ndao.update(noticeVO);
	}

	
}
