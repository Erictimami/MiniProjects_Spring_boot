<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New License</title>
</head>
<body>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<h1>New License</h1>
<% if(request.getAttribute("errors") != null){ %>
<fieldset>
	<legend>Errors</legend>
	<c:forEach items="${ errors }" var="error">
		<p><c:out value="${ error.getDefaultMessage()}"/></p>
		</c:forEach>
</fieldset>
<% } %>
<form:form action="/licenses/new/process" method="post" modelAttribute="license">
    <p>
        <form:label path="person">Person:
        <form:select path="person">
         <c:forEach items="${persons}" var="pers">
           <form:option value="${ pers }"> <c:out value="${pers.firstName} ${pers.lastName}"/> </form:option>
         </c:forEach>
         </form:select>
         </form:label>
    </p>
    <p>
        <form:label path="state">State:
        <form:errors path="state"/>
        <form:input type="text" path="state"/>
        </form:label>
    </p>
  	<p>
        <form:label path="expirationDate">Expiration Date
        <form:errors path="expirationDate"/>
        <form:input type="text" path="expirationDate"/>
        </form:label>
    </p>
    <input type="submit" value="Create"/>
</form:form> 
</body>
</html>