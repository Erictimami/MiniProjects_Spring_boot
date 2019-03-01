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

<h1>Information</h1>
<table>
    <thead>
        <tr>
            <th>Dojo Name</th>
            <th>Ninja Count</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${dojos}" var="dojo">
        <tr>
            <td><c:out value="${dojo.name}"/></td>
            <td><c:out value="${dojo.ninjas.size()}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<a href="/licenses/new">New License</a>

</body>
</html>