<%@ page import="DBHandler.DBHandler" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Outgoing Entry</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<%--Title--%>
<div class="container">
    <div class="jumbotron">
        <h1>Insert an Outgoing Entry</h1>
    </div>
</div>

<%--Advanced Query Form--%>
<div class="container">
    <%--Form Border--%>
    <div class="border col p-5 m-2">
        <div class="row d-flex justify-content-center"><h2>Insert Outgoing</h2></div>
        <%--Bad Input Handler--%>
        <%  // Check if the input was valid
            String item_id;
            String qty    ;
            String errormsg = (String) request.getAttribute("errormsg");
            if (errormsg != null) {
        %> <p class="text-info"> <%=errormsg%></p><%
            }
            // Preprocess the prior form submission
            item_id     = request.getParameter("item_id");
            qty         = request.getParameter("qty");

            item_id     = item_id     == null ? "" : item_id    ;
            qty         = qty         == null ? "" : qty        ;
        %>

        <%--Generates Form <options> dynamically--%>
        <%
            Map<String, String> item = new HashMap<>();
            try {
                DBHandler dbHandler = new DBHandler();

                ResultSet item_qry = dbHandler.executeQuery(
                        "SELECT DISTINCT item_id, name FROM itemdetails"
                );

                while (item_qry.next()) {
                    item.put(item_qry.getString("item_id"),
                             item_qry.getString("name"));
                }

                dbHandler.closeConnection();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        %>

        <%--Input Form--%>
        <form method="post" action="insertoutgoing" class="row">

            <%--Form Sections--%>
            <div class="col">

                <%--Item Name--%>
                <div class="row">
                    <div class="form-group col">
                        <label for="item_id">Item:</label>
                        <select class="form-control" id="item_id" name="item_id">
                            <%
                                for (Map.Entry<String, String> i : item.entrySet()){
                            %>
                            <option <%=i.getKey().equals(item_id) ? "selected" : ""%>
                                    value="<%=i.getKey()%>"><%=i.getKey()%>. <%=i.getValue()%></option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                </div>

                <%--Quantity--%>
                <div class="row">
                    <div class="form-group col">
                        <label for="qty">Quantity:</label>
                        <input type="text"
                               class="form-control"
                               id="qty"
                               placeholder="Quantity"
                               name="qty"
                               value="<%=qty%>">
                    </div>
                </div>
            <%--Submit Button--%>
            <div class="row">
                <button type="submit" class="btn btn-primary">Insert Entry</button>
            </div>
        </form>

    </div>
</div>

<jsp:include page="quick_access/select/table_displayer.jsp">
    <jsp:param name="sql" value="${requestScope.sql}"/>
</jsp:include>

</body>
</html>