<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	
	<title>Events</title>
</head>

<body>
	<h1>Welcome, <c:out value="${user.firstName}" /></h1><a href="/logout">Logout</a>
	<h3>Event name</h3>	
	
<h5>Edit Event</h5>
<%--  <p class="error"><form:errors path="user.*"/></p> --%>
    <form:form method="POST" action="/events/3" modelAttribute="eventFrom">
		<p class="form-group">
            <form:label path="name">Name:</form:label>
            <form:input path="name"/>
        </p>
        <p class="form-group">
            <form:label path="date">Date:</form:label>
            <form:input type = "date" path="date"/>
        </p>
        <p class="form-group">
            <form:label path="location">Location:</form:label>
            <form:input path="location"/>
        </p>
	    <p class="form-group">
	        <form:label path="state">State:</form:label>
	        <form:select path="state">    
	           <form:option value="CA"> CA </form:option>
	           <form:option value="NV"> NV </form:option>
	           <form:option value="AZ"> AZ </form:option>
	           <form:option value="WA"> WA </form:option>
	         </form:select>
	    </p>
        <input type="submit" value="Edit"/>
    </form:form>
</body>
</html>