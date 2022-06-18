<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Change Password</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/main/BootStrapTemplate.jsp"></jsp:include>
	
	<div class="p-5 mb-4 bg-light rounded-3">
        <div class="container-fluid py-5">
			<form:form>
				<div class="container mt-5 mb-5" style="width: 60%; font-weight: bold; font-size: 20px;">
					<h1><b>비밀번호 변경</b></h1>
					<div class="mb-3">
						<label class="form-label">현재 비밀번호<br>
						<form:input path="currentPassword" type="text" class="form-control" placeholder="currentPassword" size="50"/>
						<span style="color :red; margin-left:10px; font: italic bold 1em Georgia, serif ;"><form:errors path="currentPassword"/></span>
						</label>
					</div>	
						
					<div class="mb-3">
						<label class="form-label">새로운 비밀번호<br>
						<form:input path="newPassword" type="password" class="form-control" placeholder="password" size="50"/>
						<span style="color :red; margin-left:10px; font: italic bold 1em Georgia, serif ;"><form:errors path="newPassword"/></span>
						</label>
					</div>	
					<div class="mt-4 text-end">
						<a href="<c:url value='/main'/>"><input type="button" class="btn btn-danger" style="font-weight: bold;" value="<spring:message code="go.main"/>"></a>
						<input type="submit" class="btn btn-dark" style="font-weight: bold; margin-left:3px;" value="[비밀번호 변경]">
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>