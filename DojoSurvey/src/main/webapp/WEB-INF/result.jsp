<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Survey Index</title>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" >
        <link rel="stylesheet" type="text/css" href="css/result.css">   
        <!-- <script src="js/result.js"></script> -->

    </head>
    <body>
            <div class="container">                   
                <h1>Submitted Info</h1>
                <ul class="list-group" id="list-group_1">
                    <li class="list-group-item">Name:</li>
                    <li class="list-group-item">Dojo Location:</li>
                    <li class="list-group-item">Favorite Language:</li>
                    <li class="list-group-item">Comment:</li>
                </ul>

                <ul class="list-group" id="list-group_2">
                    <li class="list-group-item"><c:out value="${ name }"/></li>
                    <li class="list-group-item"><c:out value="${ location }"/></li>
                    <li class="list-group-item"><c:out value="${ language }"/></li>
                    <li class="list-group-item"><c:out value="${ comment }"/></li>
                </ul>
            </div>
            <form action='/'>
                <button type="submit" class="btn btn-primary">Go Back</button>
            </form> 
    </body>
</html>