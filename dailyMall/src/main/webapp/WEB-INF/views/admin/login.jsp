<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인</title>
<style type="text/css">
.container {
	margin: 100px auto;
}

</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body class="container">
	<div class="offset-md-4 row col-md-6">
		<form id="adminLoginForm" action="/admin/login" method="post" >
				<div class="col-6">
					<div class="fw-bold text-center h4">관리자 로그인</div>
				</div>
			<br>
				<div class="col-6">
					<label for="userId" class="fw-bold">아이디</label>
				</div>
			<br>
				<div class="col-6">
					<input type="text" name="userId" class="form-control ">
				</div>
			<br>
				<div class="col-6">
					<label for="userPass" class="fw-bold">비밀번호</label>
				</div>
			<br>
				<div class="col-6">
					<input type="password" name="userPass" class="form-control">
				</div>
			<br>
				<div class="col-6">
					<button id="adminLoginBtn" type="button" class="btn btn-dark form-control" >로그인</button>
				</div>
			<br>
				<div class="col-6">
					<div class="text-danger text-center fw-bold">${failMsg}</div>
				</div>
		</form>
	</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$("#adminLoginBtn").on("click",function(){
		
		$("#adminLoginForm").submit()
		
	});
	

})



</script>

</html>