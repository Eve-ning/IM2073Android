<%@ page import="DBHandler.DBHandler" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>${param.title}</title><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <div class="row pt-5">
        <div class="col">
            <a href="auth" role="button" class="btn btn-primary w-100">Go Back</a>
        </div>
    </div>
    <div class="row py-1">
        <div class="col">
            <h2>SQL Statement Executed</h2>
            <code>${param.sql}</code>
        </div>
    </div>
    <div class="row">
        <table class="table table-striped table-hover">
        <%
            try {
                DBHandler dbHandler = new DBHandler();
                ResultSet resultSet = dbHandler.executeQuery(request.getParameter("sql"));
                ResultSetMetaData rsmd = resultSet.getMetaData();
                int cols = rsmd.getColumnCount();
        %>

        <tr>
            <%
                for (int i = 1; i <= cols; i++) {
            %>      <td><%=rsmd.getColumnName(i)%></td><%}%>
        </tr>

        <%
            while (resultSet.next()) {
        %>
        <tr>
            <%
                for (int i = 1; i <= cols; i++) {
            %>      <td><%=resultSet.getString(i)%></td>
                <%}%>
        </tr>

        <%
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        %>
        </table>
    </div>
</div>
</body>
</html>