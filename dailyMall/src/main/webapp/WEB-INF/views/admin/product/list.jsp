<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>물품 리스트</title>
</head>
<body class="container-fluid">
	<main class="d-flex flex-nowrap" >
		<%@include file="/resources/common/admin/nav.jsp" %>
		<br>
		<div class="row">
			<h4 class="fw-bold text-center">Product List</h4>
			<div class="col-12">
				<table class="table table-hover table-bordered">
					<tr>	
						<th>#</th>
						<th>상품코드</th>
						<th>분류</th>	
						<th>신선/가공/생산제품</th>	
						<th>품목,명칭</th>
						<th>중량,수량,크기</th>
						<th>가격</th>
						<th>소비자상담실/연락처</th>
						<th>등록일</th>
					</tr>
					<c:forEach var="list" items="${list }">
					<tr>
						<td>${list.rnum }</td>
						<td><a href="/admin/product/detail?idx=${list.idx }">${list.cord }</a></td>
						<td>${list.category }</td>
						<td>${list.foodtype }</td>
						<td>${list.name }</td>
						<td>${list.size }</td>
						<td><fmt:formatNumber value="${list.price }" maxFractionDigits="3"/> </td>
						<td>${list.consulation }</td>	
						<td><fmt:formatDate value="${list.regDate }" pattern="yyyy-MM-dd HH:mm:ss"/> </td>	
					</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<br>
		<br>
	</main>
	
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</html>