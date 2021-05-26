<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bulletinForm.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="//cdn.ckeditor.com/4.16.1/standard/ckeditor.js"></script>
<script>
	$(function(){
		CKEDITOR.replace('content',{
			filebrowserUploadUrl: '${pageContext.request.contextPath }/fileUpload',
			height: '600px',
			width: '800px'
		});
	})
</script>
</head>
<body>
<div align="center">
		<h3>내용보기</h3>
		<form id="frm" action="bulletinUpdate.do" method="post">
		<input type="hidden" name = "id" value="${bulletin.id }">
			<table border="1">
				<tr>
					<th>순번</th>
					<td id="cid">${bulletin.id }</td>
					<th>작성일자</th>
					<td>${bulletin.regDate }</td>
					<th>작성자</th>
					<td>${bulletin.writer }</td>
					<th>조회수</th>
					<td>${bulletin.hit }</td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="7">
						<c:if test="${bulletin.writer eq uname }">
							<input id="ctitle" name="title" type="text"	value="${bulletin.title }">
						</c:if>
						<c:if test="${bulletin.writer ne uname }">
							${bulletin.title }
						</c:if>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="7"><textarea id="content" name="content" rows="6"
							cols="90">${bulletin.content }</textarea></td>
				</tr>
			</table>
			<div>
				<button type="button" onclick="location.href='bulletinListPaging.do'">목록보기</button>
				<c:if test="${bulletin.writer eq id }">
					<button type="submit">수정</button>
					<button type="button" onclick="location.href='bulletinUpdate.do?id=${bulletin.id }'">삭제</button>
				</c:if>
			</div>
		</form>
	</div>
</body>
</html>