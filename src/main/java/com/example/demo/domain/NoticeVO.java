package com.example.demo.domain;

import lombok.Data;

@Data
//@Alias("NoticeVO")
public class NoticeVO {
	
	private int no_num; // 게시글 번호(AI)
	private String no_title; // 제목
	private String no_content; // 내용
	private String no_file; // 파일 경로
	private String no_state; // 글 상태
	
}
