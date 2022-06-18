<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title> <spring:message code="member.register"/> </title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/main/BootStrapTemplate.jsp"></jsp:include>
	
	<div class="p-5 mb-4 bg-light rounded-3">
        <div class="container-fluid py-5">
			<form:form action="result" modelAttribute="formData">
				<div class="container mt-5 mb-5" style="width: 60%; font-weight: bold; font-size: 20px;">
					<h1><b>회원가입</b></h1>
					
					<div class="mb-3 mt-5 form-group">
						<label class="form-label"><spring:message code="id"/><br>
						<form:input path="id" type="text" class="form-control" placeholder="ID" size="50"/>
						<span style="color :red; margin-left:10px; font: italic bold 1em Georgia, serif ;"><b><form:errors path="id"/></b></span>
						</label>
					</div>
					
					<div class="mb-3">
						<label class="form-label"><spring:message code="name"/><br>
						<form:input path="name" type="text" class="form-control" placeholder="Name" size="50"/>
						<span style="color :red; margin-left:10px; font: italic bold 1em Georgia, serif ;"><form:errors path="name"/></span>
						</label>
					</div>	
						
					<div class="mb-3">
						<label class="form-label"><spring:message code="password" /><br>
						<form:input path="pw" type="password" class="form-control" placeholder="password" size="50"/>
						<span style="color :red; margin-left:10px; font: italic bold 1em Georgia, serif ;"><form:errors path="pw"/></span>
						</label>
					</div>	
					<div class="mt-4 text-end">
						<a href="<c:url value='/main'/>"><input type="button" class="btn btn-danger" style="font-weight: bold;" value="<spring:message code="go.main"/>"></a>
						<input type="submit" class="btn btn-dark" style="font-weight: bold; margin-left:3px;" value="<spring:message code="register.btn"/> ">
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>