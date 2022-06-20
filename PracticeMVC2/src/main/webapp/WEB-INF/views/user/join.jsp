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
						<div class="check_font" id="id_check"></div>
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
	<script>
// 아이디 유효성 검사(1 = 중복 / 0 != 중복)
	$("#id").blur(function() {
		// id = "id_reg" / name = "userId"
		var user_id = $('#id').val();
		$.ajax({
			url : '${pageContext.request.contextPath}/user/idCheck?userId='+ user_id,
			type : 'get',
			success : function(data) {
				console.log("1 = 중복o / 0 = 중복x : "+ data);							
				
				if (data == 1) {
						// 1 : 아이디가 중복되는 문구
						$("#id_check").text("사용중인 아이디입니다 :p");
						$("#id_check").css("color", "red");
						$("#reg_submit").attr("disabled", true);
					} else {
						
						if(idJ.test(user_id)){
							// 0 : 아이디 길이 / 문자열 검사
							$("#id_check").text("");
							$("#reg_submit").attr("disabled", false);
				
						} else if(user_id == ""){
							
							$('#id_check').text('아이디를 입력해주세요 :)');
							$('#id_check').css('color', 'red');
							$("#reg_submit").attr("disabled", true);				
							
						} else {
							
							$('#id_check').text("아이디는 소문자와 숫자 4~12자리만 가능합니다 :) :)");
							$('#id_check').css('color', 'red');
							$("#reg_submit").attr("disabled", true);
						}
						
					}
				}, error : function() {
						console.log("실패");
				}
			});
		});
</script>
</body>
</html>