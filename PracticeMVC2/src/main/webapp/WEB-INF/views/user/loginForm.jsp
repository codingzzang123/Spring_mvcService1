<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
 <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    
    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }
      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
      	body {
		  height: 100%;
		}
		body {
		  display: flex;
		  align-items: center;
		  padding-top: 40px;
		  padding-bottom: 40px;
		  background-color: #f5f5f5;
		}
		
		.form-signin {
		  width: 100%;
		  max-width: 330px;
		  padding: 15px;
		  margin: auto;
		}
		
		.form-signin .checkbox {
		  font-weight: 400;
		}
		
		.form-signin .form-floating:focus-within {
		  z-index: 2;
		}
		
		.form-signin input[type="email"] {
		  margin-bottom: -1px;
		  border-bottom-right-radius: 0;
		  border-bottom-left-radius: 0;
		}
		
		.form-signin input[type="password"] {
		  margin-bottom: 10px;
		  border-top-left-radius: 0;
		  border-top-right-radius: 0;
		}
    </style>

    <title><spring:message code="login.title"/></title>
</head>
<body class="text-center">
	<main class="form-signin mt-5">
	  <form:form modelAttribute="userLoginCommand">
	  
	    <img class="mb-4" src="https://w7.pngwing.com/pngs/339/876/png-transparent-login-computer-icons-password-login-black-symbol-subscription-business-model.png" width="200" height="200" alt="">
	    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
		
		<span style="color :red; margin-left:10px; font: italic bold 1em Georgia, serif ;"><form:errors /></span>
		<br><br>
	    <div class="form-floating">
	      <form:input path="id" type="text" class="form-control" id="floatingInput" placeholder="Id"/>
	      <span style="color :red; margin-left:10px; font: italic bold 1em Georgia, serif ;"><form:errors path="id"/></span>
	      <label for="floatingInput">ID</label>
	    </div><br>
	    
	    <div class="form-floating">
	      <form:input path="pw" type="password" class="form-control" id="floatingPassword" placeholder="Password"/>
	      <span style="color :red; margin-left:10px; font: italic bold 1em Georgia, serif ;"><form:errors path="pw"/></span>
	      <label for="floatingPassword">Password</label>
	    </div>
		
	    <div class="checkbox mb-3">
	      <label>
	      	<input type="checkbox" name="remember" value="remember" > Remember me
	      </label>
	    </div>
	    
	    <input type="submit" value="<spring:message code="login.btn"/>"  class="w-100 btn btn-lg btn-primary">
	    <a href="join">
	    	<button class="w-100 btn btn-lg btn-primary" type="button" style="margin-top:10px;">Join</button>
	    </a>
	    <p class="mt-5 mb-3 text-muted">&copy; made by hosun</p>
	  </form:form>
	</main>

</body>
</html>