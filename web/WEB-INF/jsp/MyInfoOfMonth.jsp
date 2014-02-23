<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>월별 내역</title>
<jsp:include page="./common/include.jsp"/>
</head>
<body>
<sec:authentication property="Authorities"/>
<div>
	<button type="button" class="btn btn-info" onclick="javascript:history.go(-1);">뒤로</button>
</div>
<h3>${year}년 ${month}월 상세 내역</h3>
<table class="table">
<thead>
	<tr>
		<th>날짜</th>
		<th>출근시각</th>
		<th>퇴근시각</th>
		<th>근무시간</th>
	</tr>
</thead>
<tbody>
	<c:forEach items="${timeRecords}" var="timeRecord">
	<tr>
		<td>${timeRecord.recordYmd}</td>
		<td><fmt:formatDate value="${timeRecord.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		<td><fmt:formatDate value="${timeRecord.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		<td>
			${timeRecord.workingHour}  시간
			${timeRecord.workingMinute} 분
			${timeRecord.workingSecond} 초
		</td>
	</tr>
	</c:forEach>
</tbody>
</table>
</body>
</html>