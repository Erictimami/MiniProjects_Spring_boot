<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
       <style>
   	.error{
   		color: red;
   	}
	form{
		width: 20%;
		border: solid 2px;
	}
	#email{
		float: right;
	}
	#password{
		float: right;
	}
   </style>
</head>
<body>
    <h1>Login</h1>
    <p><c:out value="${error}" /></p>
    <form method="post" action="/login">
    <p class="error">${ errorLog }</p>
        <p>
            <label class="lab" for="email">Email</label>
            <input type="text" id="email" name="email"/>
        </p>
        <p>
            <label class="lab" for="password">Password</label>
            <input type="password" id="password" name="password"/>
        </p>
        <input type="submit" value="Login!"/>
    </form>    
</body>
</html>