package com.example.demo.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Criteria;
import com.example.demo.domain.NoticeVO;
import com.example.demo.domain.PageVO;
import com.example.demo.service.NoticeServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/notice")
public class NoticeController {

	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	private final NoticeServiceImpl nService;

	// http://localhost:8080/notice/main	
	// 메인 GET
	@GetMapping("/main")
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
		logger.info("nService.noticeList(cri) : " + nService.noticeList(cri));
		return "/notice/main";
	}
	/*
	 * 게시글 등록 폼
	 * 
	 * @param noticeVO
	 * @param model
	 * @return
	 */
	
	// 글쓰기 GET
	@GetMapping("/write")
	public String writeGET(Model model) throws Exception {
		model.addAttribute("noticeVO", new NoticeVO());
		return "/notice/write";
	}

	// 글쓰기 POST
	@PostMapping("/write")
	public String writePOST(@Valid @ModelAttribute("noticeVO") NoticeVO noticeVO, BindingResult bindingResult) throws Exception {
		logger.info("글 정보 noticeVO : " + noticeVO);
		
		// 검증 실패시 다시 입력 페이지로 
		if(bindingResult.hasErrors()) {
			logger.info("errors={}", bindingResult);
			return "/notice/write";
		}

		// 검증 성공시
		nService.write(noticeVO);
		return "redirect:/notice/main";
	}

	// 글 읽기 GET
	@GetMapping("/read")
	public String read(Integer noNum, Model model, HttpSession session) throws Exception {
		model.addAttribute("notice",  nService.read(noNum));
		return "/notice/read";
	}
	
	// 글 삭제 POST
	@PostMapping("/delete")
	public int deletePOST(Integer noNum) throws Exception {
		logger.debug("deletePOST(Integer no_num)호출");
		return nService.delete(noNum);
	}
	
	// 글 수정 POST
	@PostMapping("update")
	public int boUpdatePOST(NoticeVO noticeVO) throws Exception {
		logger.debug("boUpdatePOST(NoticeVO noticeVO)호출");
		return nService.update(noticeVO);
	}

}
