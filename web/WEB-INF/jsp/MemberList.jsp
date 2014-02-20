<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>멤버 리스트</title>
<jsp:include page="./common/include.jsp"/>
</head>
<body>
<sec:authentication property="Authorities"/>
<div>
	<button type="button" class="btn btn-info jq_myinfo">개인기록</button>
</div>
<table class="table">
<thead>
	<tr>
		<th>사번</th>
		<th>이름</th>
		<th>출근시각</th>
		<th>퇴근시각</th>
		<th>출/퇴근</th>
	</tr>
</thead>
<tbody>
	<c:forEach items="${members}" var="member">
	<tr>
		<td>${member.memberNo}</td>
		<td>${member.memberName}</td>
		<td>${member.timeRecord.startTime} </td>
		<td>${member.timeRecord.endTime}</td>
		<td>
		<c:if test="${loginMember.memberNo eq member.memberNo}">
			<c:choose>
				<c:when test="${empty member.timeRecord.startTime}">
					<button type="button" class="btn btn-primary jq_punchin">출근</button>
				</c:when>
				<c:when test="${empty member.timeRecord.startTime}">
					<button type="button" class="btn btn-primary jq_punchout">퇴근</button>
				</c:when>
			</c:choose>		
		</c:if>		
		</td>
	</tr>
	</c:forEach>
</tbody>
</table>
<form metod="post" name="Punch" action="">
<input type="hidden" name="page" value="${page}">
</form>
<script>
$J(document).ready(function(){
	$J('.jq_punchin').click(function(){
		var memberNo = $J(this).data('member_no');
		$J('#memberNo').val(memberNo);
		$J('form[name=Punch]').attr('action', './PunchIn');
		$J('form').submit();
	});
	
	
	$J('.jq_punchout').click(function(){
		var memberNo = $J(this).data('member_no');
		$J('#memberNo').val(memberNo);
		$J('form[name=Punch]').attr('action', './PunchOut');
		$J('form').submit();
	});
	
	
	$J('.jq_myinfo').click(function(){
		location.href="./MyInfo";
	});
	
});


</script>
</body>
</html>