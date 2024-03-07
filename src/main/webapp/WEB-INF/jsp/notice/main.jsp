<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<style>

.table, th, td{
	border: 1px solid;
	border-collapse: collapse;
	
}
.no{
	width: 60px;
	text-align: center;
}

.title{
	width: 300px;
	text-align: center;
}

.list_page{
	width: 360px;
	text-align: center;
}

.list_page_ul li{
	list-style: none;
}

</style>

<h1>main.jsp</h1>


<div class="container">
	<input type="button" value="글쓰기" onclick="location.href='/notice/write';"> <br>
	<div class="view">
		<!-- 게시판 리스트 -->
		<table class="table">
		   	<thead>
				<tr>
			      	<th class="no">No</th>
			      	<th class="title">제목 </th>
			  	</tr>
			</thead>
		    <tbody>
		    <c:forEach var="list" items="${noticeList }">
		         <tr>
		             <td class="no"><c:out value="${list.noNum}"/> </td>
		             <td class="title">
		             	 <a href="/notice/read?noNum=${list.noNum}">
			             	 <c:out value="${list.noTitle}"/>
		             	 </a>
	             	 </td>
		         </tr>
		     </c:forEach>
		    </tbody>
            <c:if test="${empty noticeList}">
				<tr>
				    <td colspan="2" class="center">게시글이 존재하지 않습니다.</td>
				</tr>
            </c:if>
		</table>
		
		<!-- 페이지 번호 -->
		<div class="list_page">
			<ul class="list_page_ul">
				<c:if test="${pageVO.prev == true }">
					<li><a href="/notice/main?page=${pageVO.startPage-1 }">«</a></li>
					&nbsp
				</c:if>
				
				<c:forEach var="i" begin="${pageVO.startPage }" end="${pageVO.endPage }" step="1">
					&nbsp&nbsp
					<li 
						<c:if test="${pageVO.cri.page eq i}">
							class="page_active"
						</c:if>
					>
						<c:if test="${pageVO.cri.page ne i}">
							<a href="/notice/main?page?page=${i }">
								${i }
							</a>
						</c:if>
						<c:if test="${pageVO.cri.page eq i}">
								${i }
						</c:if>
					</li>
					&nbsp&nbsp
				</c:forEach>
				
				<c:if test="${pageVO.next == true }">
					&nbsp
					<li><a href="/notice/main?page?page=${pageVO.endPage+1 }">»</a></li>
				</c:if>
			</ul>
		</div>
		
	</div>
</div>
