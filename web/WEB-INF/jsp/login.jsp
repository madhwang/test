<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
</body>
<div>
	<sec:authentication property="Authorities"/>
</div>
</form>

<script type="text/javascript">

	$J(document).ready(function(){
		
		$J('.jq_login').click(function(){
			$J('#loginForm').prop("action","j_spring_security_check");
			$J('#loginForm').submit();
		});
		
	});


</script>
</html>