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
	<jsp:include page="BootStrapTemplate.jsp"></jsp:include>
	
	<div class="p-5 mb-4 bg-light rounded-3 text-center">
        <div class="container-fluid py-5">
            <h1 class="display-5 fw-bold"> ๐ฌ Hosun Page </h1>
            <c:choose>
            	<c:when test="${empty authInfo }">
            		<p class="fs-4">Login is Essential โ</p>
            		<a href="user/login"><button class="btn btn-dark btn-lg" type="button" style="font-weight: bold;">LOGIN</button></a>
            	</c:when>
            	<c:when test="${!empty authInfo }">
            		<p class="fs-4">Welcome ${authInfo.name } โ</p>
            		<a href="<c:url value='/user/changePassword'/>"><button class="btn btn-dark btn-lg" type="button" style="font-weight: bold;">[๋น๋ฐ๋ฒํธ ๋ณ๊ฒฝ]</button></a>
            		<a href="<c:url value='/user/logout'/>"><button class="btn btn-dark btn-lg" type="button" style="font-weight: bold;">[๋ก๊ทธ์์]</button></a>
            	</c:when>
            </c:choose>
        </div>
	</div>
	<a href="<c:url value='/user/detail?num=3'/>">number=3</a>
</body>
</html>