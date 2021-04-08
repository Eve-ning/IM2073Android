<!DOCTYPE html>
<html lang="en">
<head>
    <title>SG Stationary Stationery Supplies Pte. Ltd.</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <div class="jumbotron">
        <h1>Welcome <%=session.getAttribute("name") == null ? "" : session.getAttribute("name")%>.</h1>
    </div>
</div>

<div class="container">

    <div class="col border text-center py-5">
        <h1>Available Stationery</h1>
        <div class="row pt-5">
            <div class="col">
                <a href="home" role="button" class="btn btn-primary w-100">Home</a>
            </div>
        </div>
        <div class="row border py-5">

            <%
                String[] colours = {
                        "Red", "Blue", "Green", "Black"
                };
                String[] types = {
                        "Pen", "Pencil"
                };

                for (String colour : colours) {
            %>
            <div class="col">
                <%
                    for (String type : types) {
                        String name = colour + " " + type;
                        String fname = colour.toLowerCase() + type.toLowerCase();
                %>
                <div class="row text-center border-top border-bottom py-4">
                    <h2 class="w-100 text-center"><%=name%></h2>
                    <div class="w-100">
                    <img src="img/<%=fname%>.png" width="200"
                         alt="<%=name%>" class="img-thumbnail my-2 py-4">
                    </div>
                    <form method="post" action="guestOrder" class="w-100">
                        <div class="form-group">
                            <label for="<%=name%>">Quantity:</label>
                            <input type="text" class="form-control"
                                   id="<%=name%>" placeholder="Enter Quantity"
                                   name="qty">
                            <input type="hidden" value="<%=name%>" name="item" readonly>
                        </div>
                        <button type="submit" class="btn btn-primary">Place Order</button>
                    </form>
                </div>
                <%
                    }
                %>
            </div>
            <%
                }
            %>
        </div>
    </div>

</div>

</body>
</html>