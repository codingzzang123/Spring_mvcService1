<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="ls" items="${ls }">
		이름:${ls.memberName } <br>
		아이디:${ls.memberId } <br>
		비밀번호:${ls.memberPw } <br>
		 <br><br><hr>
	</c:forEach>
</body>
</html>