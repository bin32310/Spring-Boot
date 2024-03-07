package com.example.demo.domain;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("noticeVO")
public class NoticeVO {
	
	private int noNum; // 게시글 번호(AI) no_num
	
	//@NotBlank(message="제목을 입력해주세요.")
	@Pattern(regexp = "[a-zA-Z0-9ㄱ-힣]{1,30}", message = "최소 1자, 최대 30자까지 입력 가능하며 영문, 숫자, 한글만 입력 가능합니다.")
	//@Size(min = 1, message = "제목은 1글자 이상이어야 합니다.")
	private String noTitle; // 제목
	
	//@NotBlank(message="내용을 입력해주세요.")
	@Pattern(regexp = "[a-zA-Z0-9ㄱ-힣]{1,300}", message = "최소 1자, 최대 300자까지 입력 가능하며 영문, 숫자, 한글만 입력 가능합니다.")
	//@Size(min = 1, message = "내용은 1글자 이상이어야 합니다.")
	private String noContent; // 내용
	
	private String noFile; // 파일 경로
	private String noState; // 글 상태
	
	
}
