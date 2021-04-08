<!DOCTYPE html>
<html lang="en">
<head>
    <title>SG Stationary Stationery Supplies Pte. Ltd.</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <div class="jumbotron">
        <h1>SG Stationary Stationery Supplies Pte. Ltd.</h1>
        <h2>(S. S. S.)</h2>
        <p>Providing for Singapore Education since 1994</p>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-6">
            <h2>Admin Login</h2>
            <form method="get" action="auth">
                <div class="form-group">
                    <label for="auser">Username:</label>
                    <input type="text" class="form-control"
                           id="auser" placeholder="Enter Username"
                           name="username">
                </div>
                <div class="form-group">
                    <label for="apass">Password:</label>
                    <input type="password" class="form-control"
                           id="apass" placeholder="Enter Password"
                           name="password">
                </div>
                <button type="submit" class="btn btn-primary">Enter as Admin</button>
            </form>
        </div>
        <div class="col-md-6">
            <h2>Guest Login</h2>
            <form method="get" action="authguest">
                <div class="form-group">
                    <label for="guser">Username:</label>
                    <input type="text" class="form-control"
                           id="guser" placeholder="Enter Nickname"
                           name="name">
                </div>
                <button type="submit" class="btn btn-primary">Enter as Guest</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>