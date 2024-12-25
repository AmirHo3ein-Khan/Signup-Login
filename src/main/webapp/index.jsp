<%@ page import="javax.validation.ConstraintViolation" %><%--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
  Created by IntelliJ IDEA.
  User: Asus
  Date: 12/23/2024
  Time: 12:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Signup</title>
    <style>
        .btn-primary {
            cursor: pointer;
            color: #ffffff;
            background-color: #52a883;
            border: none;
        }

        .btn-primary:hover {
            background-color: #444444;
        }

        .input-color {
            background-color: #c5c5c5;
        }
        .h3-color{
            color: #52a883;
        }
    </style>
</head>

<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header text-center">
                    <h3 class="h3-color">Sign Up</h3>
                </div>
                <div class="card-body">
                    <form action="signup" method="post">
                        <div class="form-group">
                            <label for="username">Username</label>
                            <input type="text" name="username" class="form-control input-color" id="username"
                                   aria-describedby="usernameHelp" placeholder="Enter username...">
                            <small id="usernameHelp" class="form-text text-muted">Please remember your username.</small>
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" name="password" class="form-control input-color" id="password"
                                   placeholder="Enter password...">
                            <small id="passwordHelp" class="form-text text-muted">Please remember your password.</small>
                        </div>
                        <button type="submit" class="btn btn-primary btn-block">Sign Up</button>
                        <div class="container">
                            <small style="color: #d32727"><%=(request.getAttribute("errors") != null ?  request.getAttribute("errors") : "") %>
                            </small>
                            <small style="color: #d32727"><%=(request.getAttribute("usernameIsExist") != null ? request.getAttribute("usernameIsExist") : "") %>
                            </small>
                        </div>
                    </form>
                </div>
                <div class="card-footer text-center">
                    <a href="login" style="color: #52a883">Already have an account? Login</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
