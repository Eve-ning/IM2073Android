<!DOCTYPE html>
<html lang="en">
<head>
    <title>Added Choice</title>
</head>
<body>

<div class="container">
    <div class="jumbotron">
        <h1>Choice <%=(boolean)(request.getAttribute("success")) ? "Successfully" : "Not"%> Added</h1>
        <p><%=request.getParameter("userId")%>,
           <%=request.getParameter("choice")%>,
           <%=request.getParameter("qNo")%>
        </p>
    </div>
</div>
</body>
</html>