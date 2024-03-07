package com.example.demo.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/**
 * 페이징 처리를 계산하는 기준들
 */
@Data
@Alias("CriVO")
public class Criteria{
	
	private int page;
	private int pageSize; // 한페이지에 표시되는 리스트 개수
	private String keyword;
	private int pageStart; // 현재 페이지에서 시작되는 페이지의 숫자 
	
	// 기본 설정
	public Criteria() {
		this.page = 1;
		this.pageSize = 5;
	}
	
	// 
	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}
	
	// 
	public void setPageSize(int pageSize) {
		if(pageSize <= 0 || pageSize > 100) {
			this.pageSize = 10;
			return;
		}
		this.pageSize = pageSize;
	}
	
	// 변수를 저장하기위한 목적X
	// mapper에서 호출되는 메서드 #{pageStart }를 호출함
	public int getPageStart() {
		this.pageStart = (this.page -1 ) * pageSize;
		return pageStart;
	}


}
