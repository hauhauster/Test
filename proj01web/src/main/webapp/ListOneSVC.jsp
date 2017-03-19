<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ListOneSVC</title>
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
	<tr>
	<td>${svcVO.servno}</td>
	<td>${svcVO.servclassno}</td>
	<td>${svcVO.servname }</td>
	<td>${svcVO.servdiscribe }</td>
	<td>${svcVO.servimage }</td>
	<td>${svcVO.servupdate }</td>
	<td>${svcVO.status }</td>
	</tr>
	</table>
</body>
</html>