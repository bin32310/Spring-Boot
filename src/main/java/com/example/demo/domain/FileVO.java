package com.example.demo.domain;



import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("fileVO")
public class FileVO {
	
	private int fileNum; // 파일 번호(AI)
	private int noNum; // 게시글 번호
	private String fileName; // 제목
	private String fileState; // 파일 경로
	private String filePath; // 파일 경로
	private String fileUuid; // 파일 uuid
	
	
	  
}
