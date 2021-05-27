<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	

<div style="width: 80%; margin: 10px auto; text-align: center;">
	<table class = "table" border="1">
	<c:forEach items="${cartList }" var ="vo">
		<tr>
			<th colspan="2">상품명</th><th width="150">가격</th><th width="100">만족도</th><th width="100">갯수</th>
		</tr>
		<tr>
			<td width="200px"><img class="card-img-top" style="width: 100px;" src="upload/${vo.itemImage }" alt="..." /></td>
			<td width="200px">${vo.itemName } / ${vo.itemDesc }</td>
			<td width="200px">
			<c:choose>
				<c:when test="${vo.sale eq 'y' }">
					<span class="text-muted text-decoration-line-through">
						<fmt:formatNumber type="currency" value="${vo.price }"></fmt:formatNumber>
						<br>
					</span>
						<fmt:formatNumber type="currency" value="${vo.salePrice }"></fmt:formatNumber>
				</c:when>
				<c:otherwise>
					<span class="text-muted">
						<fmt:formatNumber type="currency" value="${vo.price }"></fmt:formatNumber>
						</span>
					</c:otherwise>
			</c:choose></td>
			<td width="200px">
			<div class="d-flex justify-content-center small text-warning mb-2">
				<c:forEach begin="1" end="${vo.likeIt }">
					<div class="bi-star-fill"></div>
				</c:forEach>
			</div>
			</td>
			<td width="200px">${vo.qty }</td>
		</tr>
	</c:forEach>
	</table>

</div>