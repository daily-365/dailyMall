<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>물품 등록</title>

</head>
<body class="container-fluid">
	<main class="d-flex flex-nowrap" >
		<%@include file="/resources/common/admin/nav.jsp" %>
		<br>
		<div class="row">
			<h4 class="fw-bold text-center">Product Registration</h4>
			<div class="col-4 offset-md-4">
				<button id="selecttExcelBtn" type="button" class="btn btn-outline-success form-control">엑셀 등록</button>
				<input id="registFileBtn" type="file" style="display: none;">
				<div id="productExcelFileName" class="fw-bold"></div>
			</div>
			<div class="col-12">
				<table class="table table-bordered border-dark">
					<tr>
						<th>순번</th>
						<th>상품코드</th>
						<th>분류</th>	
						<th>신선/가공/생산제품</th>	
						<th>품목,명칭</th>
						<th>중량,수량,크기</th>
						<th>가격</th>
				    </tr>
				    <tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>	
					</tr>
				    <tr>
						<th>생산지</th>
						<th>원산지</th>
						<th>제조일자,소비기한/품질유지기한</th>
						<th>농산물</th>
						<th>축산물</th>
						<th>수입농축산물</th>
						<th>
					</th>
					 <tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>	
					</tr>
					<tr>
						<th>상품구성</th>
						<th>보관방법/취급방법</th>
						<th>주의사항</th>
						<th>소비자상담실/연락처</th>
						<th>등록일</th>
						<th>
						<th>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>	
					</tr>
				</table>
			</div>
			<br>
			<br>
			<div class="col-4 offset-md-4">
				<button id="registExcelBtn" type="button" class="btn btn-success form-control">물품 등록</button>
			</div>
		</div>
		<br>
		<br>
	</main>
	
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
	
	$("#registExcelBtn").on("click",function(){

		if(!confirm("물품을 등록하시겠습니까?")){
			return false;
		}else{
			var formData = new FormData()	
				formData.append("excelFile",file)
			
			$.ajax({
				url:"/admin/product/excel/upload",
				type:"post",
				data:formData,
				enctype :"multipart/form-data",
				processData: false,
				contentType: false,
				success:function(result){
					alert(result)
					location.href="/admin/product/list"				
					
				},error:function(error){
					alert("물품 등록에 실패하였습니다.")
					console.log(error)
					
				}
			})
		}
	})
	
	
})


</script>
</html>