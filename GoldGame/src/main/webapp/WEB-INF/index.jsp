<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Ninja Gold Game</title>
	      <!-- Bootstrap CSS -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	            <!-- my own css file link in the last position to be priority-->
	    <link rel="stylesheet" type="text/css" href="css/index.css">   
	    <!-- <script src="js/index.js"></script> -->
    </head>
    <body class="container">
        <div>
            <div class="form-group row" id="score">
                <label for="inputEmail3" class="col-sm-2 col-form-label" id="your_gold">Your Gold:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputEmail3" name="your gold:" placeholder=0 value="${ count }">
                </div>
            </div>
            <div class="group_form">
                <form action="/farm" method="POST">
                    <h3 >Farm</h3>
                    <p> (earns 10-20 golds) </p>   
                    <button  type="submit" class="btn btn-primary">Find Gold!</button>
                </form>
                <form action="/cave" method="POST">
                    <h3 >Cave</h3>
                    <p> (earns 5-10 golds) </p>   
                    <button  type="submit" class="btn btn-primary">Find Gold!</button> 
                </form>    
                <form action="/house" method="POST">
                    <h3 >House</h3>
                    <p> (earns 2-5 golds) </p>   
                    <button  type="submit" class="btn btn-primary">Find Gold!</button> 
                </form>          
                <form action="/casino" method="POST">
                    <h3 >Casino</h3>
                    <p> (earns/takes 0-50 golds) </p>   
                    <button  type="submit" class="btn btn-primary">Find Gold!</button> 
                </form>
            </div>
            <div class="form-group">
                    <label for="exampleFormControlTextarea1" class="activities_name">Activities:</label>
                    <div class="activities"> ${ activities }</div>
                    <!-- <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="Activities:">{{ activities|safe }}</textarea> -->
            </div>      
        </div>
 
    </body>
</html>