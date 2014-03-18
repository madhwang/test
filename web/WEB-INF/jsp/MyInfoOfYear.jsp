<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내 정보</title>
<jsp:include page="./common/include.jsp"/>
</head>
<body>
<table class="table table-condensed">
<thead>
	<tr>
		<th>연도</th>
		<th>월</th>
		<th>총 근무 시간</th>
		<th>상세보기</th>
	</tr>
</thead>
<tbody>
	<c:forEach items="${timeStatsLst}" var="timeStats">
	<c:set value="" var="recordDay"/>
	<c:set value="" var="recordHour"/>
	<tr>
		<td>${timeStats.year}</td>
		<td>${timeStats.month}</td>
		<td>
			<c:if test="${timeStats.totalRecordHour ge 8}">${timeStats.totalRecordHour/8}일 </c:if>
			<c:if test="${timeStats.totalRecordHour%8 gt 0}">${timeStats.totalRecordHour }시간</c:if>
		</td>
		<td>
			<button type="button" class="btn btn-link jq_detail" data-year="${timeStats.year}" data-month="${timeStats.month}">상세보기</button>
		</td>
	</tr>
	</c:forEach>
</tbody>
</table>
<script>
$J(document).ready(function(){
	$J('.jq_detail').click(function(){
		location.href="/timecard/MyInfo/"+$J(this).data('year') +"/" + $J(this).data('month');
	});
});
</script>
</body>
</html>