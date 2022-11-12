<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Register Account</title>
    <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="img">
    <div class="regbox box">
        <img class="avatar" src="img/register.png">
        <h1>
            Register Account</h1>
        <form action="Register" method="post">
            <p>
                Username</p>
            <input type="text" placeholder="Username" name="name" required>
            <p>
                Useremail</p>
            <input type="email" placeholder="Useremail" name="username" required>
            <p>
                Password</p>
            <input type="password" placeholder="Password" name="password" required>
            <input type="submit" value="Register">
            <a href="Login.jsp">Already have Account?</a>
        </form>
    </div>
</div>
</body>
</html>
