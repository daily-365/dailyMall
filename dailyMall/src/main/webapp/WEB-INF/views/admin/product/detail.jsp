<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>물품 상세</title>
</head>
<body class="container-fluid">
	<main class="d-flex flex-nowrap" >
		<%@include file="/resources/common/admin/nav.jsp" %>
		<br>
		<div class="row">
			<br>
			<div class="row">
				<h4 class="fw-bold text-center">Product Detail</h4>
			</div>
			<br>
			<br>
			<div class="row">
				<div class="col-4 offset-md-4">
					<button id="selecttExcelBtn" type="button" class="btn btn-light form-control">엑셀  재등록</button>
					<input id="registFileBtn" type="file" style="display: none;">
					<br>
					<br>
					<div id="productExcelFileName" class="fw-bold"></div>
				</div>
				<div class="col-12">
					<table class="table table-bordered border-dark">
						<tr>
							<th>#</th>
							<th>상품코드</th>
							<th>분류</th>	
							<th>신선/가공/생산제품</th>	
							<th>품목,명칭</th>
							<th>옵션</th>
							<th>중량,수량,크기</th>
					    </tr>
					    <tr>
					    	<td></td>
							<td>${productVO.cord }</td>
							<td>${productVO.category }</td>
							<td>${productVO.foodtype }</td>
							<td>${productVO.name }</td>
							<td>${productVO.option }</td>
							<td>${productVO.size }</td>
						</tr>
					    <tr>
					    	<th>가격</th>
							<th>생산지</th>
							<th>원산지</th>
							<th>제조일자,소비기한/품질유지기한</th>
							<th>농산물</th>
							<th>축산물</th>
							<th>수입농축산물</th>
						</tr>
						 <tr>
							<td><fmt:formatNumber value="${productVO.price }"  maxFractionDigits="3"/></td>
							<td>${productVO.producer }</td>
							<td>${productVO.origin }</td>
							<td>${productVO.manufacturing }</td>
							<td>
								<c:if test="${productVO.ariculturalYn eq 'Y'}">
									농산물
								</c:if>
								<c:if test="${productVO.ariculturalYn eq 'N'}">
									해당사항없음
								</c:if>
							</td>
							<td>${productVO.livestock }</td>
							<td>
								<c:if test="${productVO.importedYn eq 'Y'}">
									수입농축산물
								</c:if>
								<c:if test="${productVO.importedYn eq 'N'}">
									해당사항없음
								</c:if>
							</td>	
						</tr>
						<tr>
							<th>상품구성</th>
							<th>보관방법/취급방법</th>
							<th>주의사항</th>
							<th>소비자상담실/연락처</th>
							<th>복수배송</th>
							<th>무료배송</th>
							<th>등록일</th>
						</tr>
						<tr>
							<td>${productVO.composition }</td>
							<td>${productVO.storage }</td>
							<td>${productVO.caution }</td>
							<td>${productVO.consulation }</td>
							<td>
								<c:if test="${productVO.multipleYn eq 'Y'}">
									복수배송
								</c:if>
								<c:if test="${productVO.multipleYn eq 'N'}">
									해당사항없음
								</c:if>
							</td>
							<td>
								<c:if test="${productVO.freeYn eq 'Y'}">
									무료배송
								</c:if>
								<c:if test="${productVO.freeYn eq 'N'}">
									해당사항없음
								</c:if>
							</td>
							<td><fmt:formatDate value="${productVO.regDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>	
						</tr>
					</table>
				</div>
				<div class="col-4 offset-md-2">
					<button id="modifyProductDataBtn" type="button" class="btn btn-secondary form-control">물품 재등록</button>
				</div>
				<div class="col-4">
					<button id="deleteProductDataBtn" type="button" class="btn btn-dark form-control">물품 삭제</button>
				</div>
			</div>
		</div>
	</main>
	<input type="hidden" id="getIdxValue" value="${productVO.idx }" >
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	
	$("#selecttExcelBtn").on("click",function(){
		$("#registFileBtn").click()
	});
	
	var file=null;
	
	$("#registFileBtn").on("change",function(e){
		$("#productExcelFileName").html(e.target.files[0].name)
		
		file = e.target.files[0]
	});
	
	$("#modifyProductDataBtn").on("click",function(){
		
		if(!confirm("물품 정보를 수정하시겠습니까?")){
			return false;
		}else{
			var formData = new FormData()	
				formData.append("excelFile",file)
				formData.append("idx",$("#getIdxValue").val())
			
			$.ajax({
				url:"/admin/product/excel/update",
				type:"post",
				data:formData,
				enctype :"multipart/form-data",
				processData: false,
				contentType: false,
				success:function(result){
					alert(result)
					location.reload(true)
					
				},error:function(error){
					alert("물품 수정에 실패하였습니다.")
					console.log(error)
					
				}
			})
		}
	})
	
	$("#deleteProductDataBtn").on("click",function(){
		
		if(!confirm("해당 상품 정보를 삭제하시겠습니까?")){
			return false;
		}else{
			$.ajax({
				url:"/admin/product/excel/delete",
				type:"post",
				data: { "idx" : $("#getIdxValue").val() },
				success:function(result){
					alert(result)
					location.href="/admin/product/list"
				},error:function(error){
					alert("물품 삭제에 실패하였습니다.")
					console.log(error)	
				}
			})
		}
	});
	
})


</script>
</html>