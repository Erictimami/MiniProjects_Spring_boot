<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All the licenses and Persons</title>
</head>
<body>

<h1>Products</h1>
<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Category Count</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${products}" var="prod">
        <tr>
            <td><c:out value="${prod.name}"/></td>
            <td><c:out value="${prod.description}"/></td>
            <td><c:out value="${prod.price}"/></td>
            <td><c:out value="${prod.categories.size()}"/> categories</td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<h1>Categories</h1>
<table>
    <thead>
        <tr>
            <th>Category Name</th>
            <th>Product Count</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${categories}" var="cat">
        <tr>
            <td><c:out value="${cat.name}"/></td>
            <td><c:out value="${cat.products.size()}"/> products</td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>