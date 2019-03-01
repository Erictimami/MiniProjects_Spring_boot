<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Dojo Survey Index</title>
	    <!-- Bootstrap CSS -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	            <!-- my own css file link in the last position to be priority-->
	    <link rel="stylesheet" type="text/css" href="css/index.css">   
    </head>
    <body>
            <div class="container">
                    <form action = "/process" method = "POST">
                    	<p><c:out value="${ errorName }"/></p>
                        <div class="form-group row">
                            <label for="inputEmail3" class="col-sm-2 col-form-label">Name:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputEmail3" name="name" placeholder="Please, enter your full name">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="inputEmail3" class="col-sm-2 col-form-label">Dojo Location:</label>
                            <div class="col-sm-10">
                                <select id="inputState" class="form-control" name = "location">
                                    <option selected>San Jose</option>
                                    <option>San Francisco</option>
                                    <option>Bellevue</option>
                                    <option>Pittsburg</option>
                                    <option>Fremont</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label">Favorite Language:</label>
                            <div class="col-sm-10">
                                <select id="inputState" class="form-control" name = "language">
                                    <option selected>Python</option>
                                    <option>JavaScript</option>
                                    <option>html</option>
                                    <option>CSS</option>
                                    <option>BootStrap</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                                <label for="exampleFormControlTextarea1" >Comments (optional):</label>
                                <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="comment"></textarea>
                        </div>
                        <button type="submit" class="btn btn-primary">Button</button>
                    </form>
            </div>


    </body>
</html>