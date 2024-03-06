package com.example.demo.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.Criteria;
import com.example.demo.domain.NoticeVO;
import com.example.demo.domain.PageVO;
import com.example.demo.service.NoticeServiceImpl;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

	@Inject
	private NoticeServiceImpl nService;

	
	// http://localhost:8080/notice/main	
	// 메인 GET
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String mainGET(Criteria cri, Model model, HttpSession session) throws Exception {
		
		// 페이징 처리( 페이지 블럭 처리 객체 )
		PageVO pageVO = new PageVO();
		pageVO.setCri(cri);
		pageVO.setTotalCount(nService.noticeCount()); // 전체 글 수
		model.addAttribute("pageVO", pageVO);
		
		// 페이지 이동시 받아온 페이지 번호
		if (cri.getPage() > pageVO.getEndPage()) {
			// 잘못된 페이지 정보 입력
			cri.setPage(pageVO.getEndPage());
		}
		
		// session에 페이지 정보 저장
		session.setAttribute("page", cri.getPage());
		
		//  전체 글 목록
		model.addAttribute("noticeList", nService.noticeList(cri));
		return "/notice/main";
	}
	
	// 글쓰기 GET
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String writeGET() throws Exception {
		logger.debug("writeGET()호출");
		
		return "/notice/write";
	}

	// 글쓰기 POST
	@ResponseBody
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public int boWritePOST(NoticeVO noticeVO, HttpSession session) throws Exception {
		logger.debug("writePOST(NoticeVO noticeVO)호출");
		
		logger.debug("글 정보 boardVO : " + noticeVO);
		if (nService.write(noticeVO) == 1) {
			return 1;
		}
		return 0;
	}

	// 글 읽기 GET
	@RequestMapping(value = "read", method = RequestMethod.GET)
	public String read(Integer no_num, Model model, HttpSession session) throws Exception {
		model.addAttribute("notice",  nService.read(no_num));
		return "/notice/read";
	}
	
	// 글 삭제 POST
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public int deletePOST(Integer no_num) throws Exception {
		logger.debug("deletePOST(Integer no_num)호출");
		return nService.delete(no_num);
	}
	
	// 글 수정 POST
	@RequestMapping(value = "boUpdate", method = RequestMethod.POST)
	public int boUpdatePOST(NoticeVO noticeVO) throws Exception {
		logger.debug("boUpdatePOST(NoticeVO noticeVO)호출");
		return nService.update(noticeVO);
	}

}
