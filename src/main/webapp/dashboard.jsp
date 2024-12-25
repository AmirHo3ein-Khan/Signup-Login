<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 12/20/2024
  Time: 4:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Dashboard</title>
    <style>
        .btn-primary {
            cursor: pointer;
            color: #ffffff;
            background-color: #52a883;
            border: none;
        }

        .btn-primary:hover {
            background-color: #6b6b6b;
        }

        .h3-color {
            color: #52a883;
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <h1 class="text-center">Welcome</h1>
                <div class="card-header text-center">
                    <h3 class="h3-color">Logout</h3>
                </div>
                <div class="card-body">
                    <form action="logout" method="post">
                        <button type="submit" class="btn btn-primary btn-block">Logout</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
