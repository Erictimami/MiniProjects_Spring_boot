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
            <th>First Name</th>
            <th>Last Name</th>
            <th>License #</th>
            <th>State</th>
            <th>Expiration Date</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${licenses}" var="License">
        <tr>
            <td><c:out value="${License.person.firstName}"/></td>
            <td><c:out value="${License.person.lastName}"/></td>
            <td><c:out value="${License.number}"/></td>
            <td><c:out value="${License.state}"/></td>
            <td><c:out value="${License.expirationDate}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<a href="/licenses/new">New License</a>

</body>
</html>