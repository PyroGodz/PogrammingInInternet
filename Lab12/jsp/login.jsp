<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<style>
    body {
        padding: 5px;
    }
    h3 {
        margin-bottom: 5px;
        text-align: center;
    }
    a {
        display: block;
        color: black;
        text-decoration: none;
        font-size: 20px;
        font-weight: bold;
    }
    a:hover {
        color: blue;
    }
    label {
        font-size: 13px;
    }
    input {
        display: block;
        width: 150px;
        height: 30px;
        background-color: #FFFFFF;
        border-radius: 3px;
        color: #000000;
        font-size: 16px;
        padding: 5px;
        cursor: pointer;
    }
    input[type=submit] {
        display: block;
        width: 150px;
        height: 35px;
        background-color: #000000;
        border-radius: 3px;
        color: #FFFFFF;
        font-size: 16px;
        font-weight: bold;
        cursor: pointer;
        margin: 10px 0;
    }
    .center {
        display: flex;
        justify-content: center;
        align-items: center;
    }
</style>
<body>
    <form method="post" action="j_security_check">
        <div class="center">
            <div>
                <h3>Login</h3>
                <label>username</label>
                <input type="text" name="j_username" />
                <label>password</label>
                <input type="password" name="j_password" />
                <input type="submit" />
            </div>
        </div>
    </form>
</body>
</html>