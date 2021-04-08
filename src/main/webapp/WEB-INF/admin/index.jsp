<%@ page import="java.util.function.Consumer" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<%--Title--%>
<div class="container">
    <div class="jumbotron">
        <h1>Welcome Back Admin.</h1>
    </div>
</div>

<%--Quick Access Queries--%>
<div class="container">
    <div class="row pt-5">
        <div class="col">
            <a href="home" role="button" class="btn btn-primary w-100">Home</a>
        </div>
    </div>
    <div class="row">
        <%--Current Stocks--%>
        <div class="col py-3">
            <div class="row d-flex justify-content-center"><h2>Current Stocks</h2></div>
            <div class="row d-flex justify-content-center">
                <a href="stocks" class="btn btn-info px-4" role="button">View</a>
            </div>
        </div>
        <%--Ingoing Records--%>
        <div class="col py-3">
            <div class="row d-flex justify-content-center"><h2>Ingoing Records</h2></div>
            <div class="row d-flex justify-content-center">
                <a href="ingoing" class="btn btn-info px-4" role="button">View</a></div>
        </div>
        <%--Suppliers--%>
        <div class="col py-3">
            <div class="row d-flex justify-content-center"><h2>Suppliers</h2></div>
            <div class="row d-flex justify-content-center">
                <a href="suppliers" class="btn btn-info px-4" role="button">View</a></div>
        </div>
    </div>
</div>

<%--Advanced Query Form--%>
<div class="container">
    <div class="row py-5">

        <div class="col">
            <a href="prodsearch" role="button" class="btn btn-info px-4 col">Product Search</a>
        </div>
        <div class="col">
            <a href="suppsearch" role="button" class="btn btn-info px-4 col">Supplier Search</a>
        </div>
        <div class="col">
            <a href="insertingoing" role="button" class="btn btn-info px-4 col">Insert Ingoing</a>
        </div>
        <div class="col">
            <a href="insertoutgoing" role="button" class="btn btn-info px-4 col">Insert Outgoing</a>
        </div>
    </div>
</div>
</body>
</html>