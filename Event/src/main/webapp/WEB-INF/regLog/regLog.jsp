<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
    <style>
    	.reg{
    		width: 45%;
    		display: inline-block;
    		vertical-align: top;
    		margin-left: 3%;
    	}
    	.log{
    		width: 45%;
    		display: inline-block;
    		vertical-align: top;
    		margin-left: 3%;
    	}
    	.error{
    		color: red;
    		font-size: 12px;
    	}
		form{
			width: 50%;
			border: solid 2px;
			
		}
		input{
			float: right;
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
	<div class="reg">
		<h1>Register!</h1>
    
    <p class="error"><form:errors path="user.*"/></p>
    <form:form method="POST" action="/registration" modelAttribute="user">
<%--         <p class="error">${ errorReg }</p> --%>
		<p>
            <form:label path="firstName">First Name:</form:label>
            <form:input path="firstName"/>
        </p>
        <p>
            <form:label path="lastName">Last Name:</form:label>
            <form:input path="lastName"/>
        </p>
        <p>
            <form:label path="email">Email:</form:label>
            <form:input path="email"/>
        </p>
        <p>
            <form:label path="location">Location:</form:label>
            <form:input path="location"/>
        </p>
	    <p>
	        <form:label path="state">State:</form:label>
	        <form:select path="state">    
	           <form:option value="CA"> CA </form:option>
	           <form:option value="NV"> NV </form:option>
	           <form:option value="AZ"> AZ </form:option>
	           <form:option value="WA"> WA </form:option>
	         </form:select>
	    </p>
        <p>
            <form:label path="password">Password:</form:label>
            <form:password path="password"/>
        </p>
        <p>
            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
            <form:password path="passwordConfirmation"/>
        </p>
        <input type="submit" value="Register!"/>
    </form:form>
	</div>
	
	<div class="log">
		<h1>Login</h1>
    <p class="error">${ errorLog }</p>
    <form method="post" action="/login">
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
	</div>

</body>
</html>