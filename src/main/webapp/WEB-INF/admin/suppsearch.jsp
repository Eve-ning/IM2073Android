<!DOCTYPE html>
<html lang="en">
<head>
    <title>Admin Supplier Search</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<%--Title--%>
<div class="container">
    <div class="jumbotron">
        <h1>Search for Suppliers Here</h1>
    </div>
</div>

<%--Advanced Query Form--%>
<div class="container">
    <%--Form Border--%>
    <div class="border col p-5 m-2">
        <div class="row d-flex justify-content-center"><h2>Advanced Search</h2></div>
        <%--Bad Input Handler--%>
        <%  // Check if the input was valid
            String supp   ;
            String contact;
            String address;
            // Don't have any error messages for this but we'll keep it
            String errormsg = (String) request.getAttribute("errormsg");
            if (errormsg != null) {
        %> <p class="text-info"> <%=errormsg%></p><%
            }
            // Preprocess the prior form submission
            supp    = request.getParameter("supp");
            contact = request.getParameter("contact");
            address = request.getParameter("address");

            supp    = supp    == null ? "" : supp;
            contact = contact == null ? "" : contact;
            address = address == null ? "" : address;
        %>

        <%--Input Form--%>
        <form method="post" action="suppsearch" class="row">
            <%--Form Sections--%>
            <div class="col">
            <%--Prod Name & Supplier--%>
            <div class="row">
                <div class="form-group col">
                    <label for="supp">Supplier Name:</label>
                    <input type="text" class="form-control"
                           id="supp" placeholder="Enter Supplier Name"
                           name="supp" value="<%=supp%>"
                    >
                </div>
                <div class="form-group col">
                    <label for="contact">Supplier Contact:</label>
                    <input type="text" class="form-control"
                           id="contact" placeholder="Enter Supplier Contact"
                           name="contact" value="<%=contact%>"
                    >
                </div>
                <div class="form-group col">
                    <label for="address">Supplier Address:</label>
                    <input type="text" class="form-control"
                           id="address" placeholder="Enter Supplier Address"
                           name="address" value="<%=address%>"
                    >
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