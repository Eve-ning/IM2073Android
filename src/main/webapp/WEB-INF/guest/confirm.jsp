<!DOCTYPE html>
<html lang="en">
<head>
    <title>SG Stationary Stationery Supplies Pte. Ltd.</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <div class="jumbotron">
        <h1>Order Confirmation.</h1>
    </div>
</div>

<div class="container">

    <div class="col border text-center py-5">
        <h2>Your order is</h2>
        <p><em><%=request.getParameter("item")%></em> <%=request.getParameter("qty")%></p>
        <a class="btn btn-default" href="guestOrder" role="button">Go Back</a>
    </div>

</div>

</body>
</html>