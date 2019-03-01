<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Page</title>
</head>
<body>
<h1><c:out value="${product.name}"/></h1> 
<div class="cat">
    <h4>Categories</h4>
    <ul>
        <c:forEach items="${product.categories}" var="cat">
            <li><c:out value="${cat.name}"/></li>
        </c:forEach>
    </ul>
</div>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<form:form action="/product/prodCat/process/" method="post" modelAttribute="categoryProduct">
    <p>
        <form:label path="product">Add Category:</form:label>
        <input type="hidden" name="prodID" value="${ product.id }"/>
        <form:select path="category">
        <c:forEach items="${categories}" var="cat">
           	<form:option value="${ cat.id }"> <c:out value="${cat.name}"/></form:option>
        </c:forEach>
        </form:select>
    </p>
    <input type="submit" value="Add"/>
</form:form> 

</body>
</html>