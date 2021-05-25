<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
	function noticeInsert(){
		let title = document.getElementById("ctitle").value;
		let content = document.getElementById("ccontent").value;
		
		frm.title.value=title;
		frm.content.value=content;
		frm.submit();
	}	
</script>
<div align="center">
	<h3>공지사항 등록</h3>
	<form id="frm" action="noticeInsert.do" method="post">
		<input type="hidden" name="title">
		<input type="hidden" name="content">
	</form>
	<table border="1">
		<tr>
			<th>제목</th>
			<td><input type="text" id="ctitle" name="title"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea id ="ccontent" rows="6" cols="90"></textarea></td>
		</tr>
	</table>
	<div>
		<button type="button" onclick="location.href='noticeList.do'">목록보기</button>
		<button type="button" onclick="noticeInsert()">등록</button>
		<button type="reset">취소</button>
	</div>
</div>