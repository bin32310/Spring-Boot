package com.example.demo.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Criteria;
import com.example.demo.domain.NoticeVO;


@Repository(value="noticeDAO")
public class NoticeDAOImpl {

	

	private static final Logger logger = LoggerFactory.getLogger(NoticeDAOImpl.class);
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "com.example.demo.persistence.NoticeDAOImpl";
	

	// 글 목록 조회
	public List<NoticeVO> noticeList(Criteria cri) {
		logger.info("noticeList(Criteria cri) 호출");
		return sqlSession.selectList(NAMESPACE + ".noticeList", cri);
	}
	
	// 글 수
	public int noticeCount() {
		logger.info("noticeCount() 호출");
		return sqlSession.selectOne(NAMESPACE + ".noticeCount");
	}
	
	// 글쓰기
	public int write(NoticeVO noticeVO) {
		logger.info("write(NoticeVO noticeVO) 호출" + noticeVO);
		return sqlSession.insert(NAMESPACE + ".write", noticeVO);
	}
	
	// 글읽기
	public NoticeVO read(Integer noNum) {
		logger.info("read(Integer no_num) 호출 ");
		return 	sqlSession.selectOne(NAMESPACE + ".read", noNum);
	}
	
	// 글삭제
	public int delete(Integer noNum) {
		logger.info("delete(Integer no_num) 호출 ");
		return 	sqlSession.update(NAMESPACE + ".delete", noNum);
	}
	
	// 글수정
	public int update(NoticeVO noticeVO) {
		logger.info("update(NoticeVO noticeVO) 호출 ");
		return 	sqlSession.update(NAMESPACE + ".update", noticeVO);
	}
	
}
