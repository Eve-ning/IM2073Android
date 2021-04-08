<%@ page import="DBHandler.DBHandler" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Ingoing Entry</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<%--Title--%>
<div class="container">
    <div class="jumbotron">
        <h1>Insert an Ingoing Entry</h1>
    </div>
</div>

<%--Advanced Query Form--%>
<div class="container">
    <%--Form Border--%>
    <div class="border col p-5 m-2">
        <div class="row d-flex justify-content-center"><h2>Insert Ingoing</h2></div>
        <%--Bad Input Handler--%>
        <%
            String supp_id;
            String item_id;
            String qty    ;
            String price  ;
            String errormsg = (String) request.getAttribute("errormsg");

            if (errormsg != null) {
        %> <p class="text-info"> <%=errormsg%></p><%
            }
            // Preprocess the prior form submission
            supp_id = request.getParameter("supp_id");
            item_id = request.getParameter("item_id");
            qty     = request.getParameter("qty");
            price   = request.getParameter("price");

            supp_id = supp_id == null ? "" : supp_id;
            item_id = item_id == null ? "" : item_id;
            qty     = qty     == null ? "" : qty;
            price   = price   == null ? "" : price;
        %>

        <%--Generates Dynamic <options> using DB calling --%>
        <%
            Map<String, String> supp = new HashMap<>();
            Map<String, String> item = new HashMap<>();
            try {
                DBHandler dbHandler = new DBHandler();

                ResultSet supp_qry = dbHandler.executeQuery(
                        "SELECT DISTINCT supplier_id, name FROM supplier"
                );
                ResultSet item_qry = dbHandler.executeQuery(
                        "SELECT DISTINCT item_id, name FROM itemdetails"
                );

                while (supp_qry.next()) {
                    supp.put(supp_qry.getString("supplier_id"),
                             supp_qry.getString("name"));
                }
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
        <form method="post" action="insertingoing" class="row">

            <%--Form Sections--%>
            <div class="col">

                <%--Supplier--%>
                <div class="row">
                    <div class="form-group col">
                        <label for="supp">Supplier:</label>
                        <select class="form-control" id="supp" name="supp">
                            <%
                                for (Map.Entry<String, String> s : supp.entrySet()){
                            %>
                            <option <%=s.getKey().equals(supp_id) ? "selected" : ""%>
                                    value="<%=s.getKey()%>"><%=s.getKey()%>. <%=s.getValue()%>
                            </option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                </div>

                <%--Item--%>
                <div class="row">
                    <div class="form-group col">
                        <label for="item_id">Item:</label>
                        <select class="form-control" id="item_id" name="item_id">
                            <%
                                for (Map.Entry<String, String> i : item.entrySet()){
                            %>
                            <option <%=i.getKey().equals(item_id) ? "selected" : ""%>
                                    value="<%=i.getKey()%>"><%=i.getKey()%>. <%=i.getValue()%>
                            </option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                </div>

                <%--Quantity & Price--%>
                <div class="row">

                    <%--Quantity--%>
                    <div class="form-group col">
                        <label for="qty">Quantity:</label>
                        <input type="text"
                               class="form-control"
                               id="qty"
                               placeholder="Quantity"
                               name="qty"
                               value="<%=qty%>">
                    </div>

                    <%--Price--%>
                    <div class="form-group col">
                        <label for="price">Price per pax:</label>
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="price-pre">$</span>
                            </div>
                            <input type="text"
                                   class="form-control"
                                   id="price"
                                   placeholder="Price per pax"
                                   name="price"
                                   value="<%=price%>">
                            <div class="input-group-append">
                                <span class="input-group-text">per pax</span>
                            </div>
                        </div>
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