<!DOCTYPE html>
<html lang="en">
<head>
    <title>Admin Product Search</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<%--Title--%>
<div class="container">
    <div class="jumbotron">
        <h1>Search for Products Here</h1>
    </div>
</div>

<%--Advanced Query Form--%>
<div class="container">
    <%--Form Border--%>
    <div class="border col p-5 m-2">
        <div class="row d-flex justify-content-center"><h2>Advanced Search</h2></div>
        <%--Bad Input Handler--%>
        <%  // Check if the input was valid
            String prod     ;
            String price_min;
            String price_max;
            String qty_min  ;
            String qty_max  ;
            String errormsg = (String) request.getAttribute("errormsg");
            if (errormsg != null) {
        %> <p class="text-info"> <%=errormsg%></p><%
            }
            // Preprocess the prior form submission
            prod      = request.getParameter("prod");
            price_min = request.getParameter("price_min");
            price_max = request.getParameter("price_max");
            qty_min   = request.getParameter("qty_min");
            qty_max   = request.getParameter("qty_max");

            prod      = prod      == null ? "" : prod      ;
            price_min = price_min == null ? "" : price_min ;
            price_max = price_max == null ? "" : price_max ;
            qty_min   = qty_min   == null ? "" : qty_min   ;
            qty_max   = qty_max   == null ? "" : qty_max   ;
        %>

        <%--Input Form--%>
        <form method="post" action="prodsearch" class="row">
            <%--Form Sections--%>
            <div class="col">
            <%--Prod Name & Supplier--%>
            <div class="row">
                <div class="form-group col">
                    <label for="prod">Product Name:</label>
                    <input type="text" class="form-control"
                           id="prod" placeholder="Enter Product Name"
                           name="prod" value="<%=prod%>"
                    >
                </div>
            </div>
            <%--Price & Quantity--%>
            <div class="row">
                <div class="form-group col">
                    <label for="price_min">Price ppax (Min.):</label>
                    <input type="text"
                           class="form-control"
                           id="price_min"
                           placeholder="Minimum Price"
                           name="price_min"
                           value="<%=price_min%>">
                </div>
                <div class="form-group col">
                    <label for="price_max">Price ppax (Max.):</label>
                    <input type="text"
                           class="form-control"
                           id="price_max"
                           placeholder="Maximum Price"
                           name="price_max"
                           value="<%=price_max%>">
                </div>

                <div class="form-group col">
                    <label for="qty_min">Quantity (Min.):</label>
                    <input type="text"
                           class="form-control"
                           id="qty_min"
                           placeholder="Minimum Quantity"
                           name="qty_min"
                           value="<%=qty_min%>">
                </div>
                <div class="form-group col">
                    <label for="qty_max">Quantity (Max.):</label>
                    <input type="text"
                           class="form-control"
                           id="qty_max"
                           placeholder="Maximum Quantity"
                           name="qty_max"
                           value="<%=qty_max%>">
                </div>
            </div>
            <%--Submit Button--%>
            <div class="row">
                <button type="submit" class="btn btn-primary">Search</button>
            </div>
        </form>

    </div>
</div>

<jsp:include page="quick_access/select/table_displayer.jsp">
    <jsp:param name="sql" value="${requestScope.sql}"/>
</jsp:include>

</body>
</html>