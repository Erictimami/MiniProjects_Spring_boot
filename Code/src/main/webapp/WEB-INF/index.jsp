<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Secret Code</title>
<style>
	form{
		margin: 100px 0px 0px 30%;
	}
	.error{
		color: red;
	}
</style>
</head>
<body>
<form action="/process" method="post">
  <div class="form-group">
  	<p class="error"> <c:out value="${errorName}"/> </p>
    <p >What is the code?</p>
    <input type="text" class="form-control" id="exampleDropdownFormEmail2" name="code" placeholder="Enter the code">
  </div>
  <button type="submit" class="btn btn-primary">Try Code</button>
</form>
</body>
</html>