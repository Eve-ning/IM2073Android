<!DOCTYPE html>
<html lang="en">
<head>
    <title>Registered User</title>
</head>
<body>

<div class="container">
    <div class="jumbotron">
        <h1>User <%=(boolean)(request.getAttribute("success")) ? "Successfully" : "Not"%> Added</h1>
        <p><%=request.getParameter("username")%>,
           <%=request.getParameter("password")%>
        </p>
    </div>
</div>
</body>
</html>