<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <title>Event name ???</title>
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
 <h1>Event name</h1>
	<div class="reg">
<p>Host: Musk Johson</p>
<p>Date: November 10, 2018</p>
<p>Location: Phoenix, AZ</p>
<p>People who are attending this event: 3</p>
<br><br>
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Location</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td> John Doe </td>
      <td>Burbank</td>
    </tr>
    <tr>
      <td>James Doe</td>
      <td>Los Angeles</td>
    </tr>
        <tr>
      <td>James Doe</td>
      <td>Los Angeles</td>
    </tr>
  </tbody>
</table>
	</div>
	
	<div class="log">
		<h2>Message Wall</h2>
		<div>
		<p>Ninja says: Hello Everyone</p>
		<p>..............</p>
		<p>Ninja says: Hello Everyone</p>
		<p>..............</p>
		<p>Ninja says: Hello Everyone</p>
		<p>..............</p>
		</div>
<%--     <p class="error"><form:errors path="user.*"/></p> --%>
    <form:form method="POST" action="/events/message" modelAttribute="messageFrom">
		<p class="form-group">
            <form:label path="message">Add Comment:</form:label>
            <form:input path="firstName"/>
        </p>
        <input type="submit" value="Submit"/>
    </form:form>  
	</div>

</body>
</html>