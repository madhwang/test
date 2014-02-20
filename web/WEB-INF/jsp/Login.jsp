<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<jsp:include page="./common/include.jsp"/>
</head>
<body>
<form id="loginForm" method="post">
	<input type="text" name="j_username" placeholder="ID" required>
	<input type="password" name="j_password" placeholder="Password" required>
	<button type="button" class="btn btn-primary jq_login">로그인</button>
</form>
</body>

<script type="text/javascript">

	$J(document).ready(function(){
		
		$J('.jq_login').click(function(){
			$J('#loginForm').prop("action","j_spring_security_check");
			$J('#loginForm').submit();
		});
		
	});


</script>
</html>