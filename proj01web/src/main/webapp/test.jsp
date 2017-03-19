<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>
</head>
<body>
<ul>
  <li><a href='ListAllSVC.jsp'>List</a> all Emps. </li>
  <li>
  	<form method="post" action="/proj01web/Controller">
		  <b>輸入服務代號(如1000)</b>
		  <input type="text" name="servno">
		  <input type="submit" value="送出" >
		  <input type="hidden" name="action" value="get_one_for_display">
  	</form>
  	</li>
  </ul>
</body>
</html>