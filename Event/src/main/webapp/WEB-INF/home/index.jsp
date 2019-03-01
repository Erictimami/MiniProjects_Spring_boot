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
	<h4>Here are some of the events in your state:</h4>	
	<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Date</th>
      <th scope="col">Location</th>
      <th scope="col">Host</th>
      <th scope="col">Action / Status</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><a href=""> Cooking Lesson </a></td>
      <td>November 30, 2018</td>
      <td>Los Angeles</td>
      <td>Kevin</td>
      <td><a href="">Join</a></td>
    </tr>
    <tr>
      <td><a href=""> Cooking Lesson </a></td>
      <td>November 30, 2018</td>
      <td>Los Angeles</td>
      <td>Kevin</td>
      <td>Joining <a>Cancel</a> </td>
    </tr>
    <tr>
      <td><a href=""> Cooking Lesson </a></td>
      <td>November 30, 2018</td>
      <td>Los Angeles</td>
      <td>Kevin</td>
      <td><a>Delete</a> <a>Delete</a> </td>
    </tr>
  </tbody>
</table>
<br> <br>
	<h4>Here are some of the events in other states:</h4>	
		<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Date</th>
      <th scope="col">Location</th>
      <th scope="col">Host</th>
      <th scope="col">Action / Status</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><a href=""> Cooking Lesson </a></td>
      <td>November 30, 2018</td>
      <td>Los Angeles</td>
      <td>Kevin</td>
      <td><a href="">Join</a></td>
    </tr>
    <tr>
      <td><a href=""> Cooking Lesson </a></td>
      <td>November 30, 2018</td>
      <td>Los Angeles</td>
      <td>Kevin</td>
      <td><a href="">Join</a></td>
    </tr>
    <tr>
      <td><a href=""> Cooking Lesson </a></td>
      <td>November 30, 2018</td>
      <td>Los Angeles</td>
      <td>Kevin</td>
      <td><a href="">Join</a></td>
    </tr>
  </tbody>
</table>
<br> <br>

<h3>Create an Event</h3>
    <form:form >
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
        <input type="submit" value="Create"/>
    </form:form>
</body>
</html>