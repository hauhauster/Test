<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="service_model.*"%>
<%ServiceDAOsvc svc=new ServiceDAOsvc();
	List<ServiceVO> list = svc.getAll();
	pageContext.setAttribute("list",list);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List all</title>
</head>
<body>
	<table border='1' bordercolor='#CCCCFF' width='800'>
	<tr>
	<th>服務代號</th>
	<th>服務分類編號</th>
	<th>服務項目名稱</th>
	<th>服務描述</th>
	<th>服務照片</th>
	<th>服務上架時間</th>
	<th>服務狀態</th>
	</tr>

	<c:forEach var="serviceVO" items="${list}">
	<tr>
	<td>${serviceVO.servno}</td>
	<td>${serviceVO.servclassno }</td>
	<td>${serviceVO.servname}</td>
	<td>${serviceVO.servdiscribe }</td>
	<td>${serviceVO.servimage }
	<td>${serviceVO.servupdate }</td>
	<td>${serviceVO.status }</td>
	</tr>
	</c:forEach>

	</table>
</body>
</html>