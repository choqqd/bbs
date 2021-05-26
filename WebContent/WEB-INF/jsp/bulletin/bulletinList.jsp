<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
<script>
	function formSubmit(BulletinId){
      frm.id.value = BulletinId;
      frm.submit();
	}
</script>
</head>
<body>

	<form id = "frm" action="bulletin.do" method="post">
		<input type="hidden" id="id" name="id">
	</form>
	<div align="center">
		<h3>자유게시판</h3>
		<div style="width:80%">
			<table class="table" border="1">
				<tr>
					<th width="100">순번</th>
					<th width="200">제목</th>
					<th width="150">작성자</th>
					<th width="150">작성일자</th>
					<th width="100">조회수</th>
				</tr>
				<c:forEach items="${bulletinList }" var="vo">
					<tr onclick="formSubmit(${vo.id })">
						<td>${vo.id }</td>
						<td>${vo.title }</td>
						<td>${vo.writer }</td>
						<td>${vo.regDate }</td>
						<td>${vo.hit }</td>
					</tr>
				</c:forEach>
			</table>
			<div>
				<button type="button" onclick="location.href='main.do'">첫 페이지</button>
				<c:if test="${!empty id }">
					<button type="button" onclick="location.href='bulletinForm.do'">등록</button>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>