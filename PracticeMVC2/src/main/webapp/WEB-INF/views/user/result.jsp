<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Done!</h1>
<h2>${formData.name }님 환영합니다!!</h2>
<br><br><hr><br><br>
<h1>Done(Spring:message code="register.done" argument={formData.name})</h1>
<h2><spring:message code="register.done" arguments="${formData.name }" /></h2>
</body>
</html>