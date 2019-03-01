<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category Page</title>
</head>
<body>
<h1><c:out value="${category.name}"/></h1> 
<div class="cat">
    <h4>Products:</h4>
    <ul>
        <c:forEach items="${category.products}" var="prod">
            <li><c:out value="${prod.name}"/></li>
        </c:forEach>
    </ul>
</div>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<form:form action="/category/prodCat/process/" method="post" modelAttribute="categoryProduct">
    <p>
        <form:label path="category">Add Product:</form:label>
        <input type="hidden" name = "catID" value="${category.id}"/>
        <form:select path="product">
        <c:forEach items="${products}" var="prod">
         	<form:option value="${ prod.id }"> <c:out value="${prod.name}"/></form:option>
        </c:forEach>
         </form:select>
    </p>
    <input type="submit" value="Add"/>
</form:form> 

</body>
</html>