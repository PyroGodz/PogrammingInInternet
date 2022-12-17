<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<style>
    a {
        width: 90px;
        color: black;
        font-size: 19px;
        text-decoration: none;
        border: 2px solid black;
        border-radius: 10px;
        text-align: center;
        font-weight: bold;
        padding: 8px;
    }

    a:hover {
        color: blue;
    }

    label {
        font-size: 15px;
    }

    input {
        display: block;
        width: 300px;
        height: 40px;
        background-color: #FFFFFF;
        border-radius: 4px;
        color: #000000;
        font-size: 16px;
        padding: 5px;
        margin-right: 100px;
        cursor: pointer;
    }

    input[type=submit] {
        display: block;
        width: 300px;
        height: 35px;
        background-color: #000000;
        border-radius: 4px;
        color: #FFFFFF;
        font-size: 16px;
        font-weight: bold;
        cursor: pointer;
        margin: 10px 0;
    }

    .container {
        display: flex;
        flex-direction: column;
    }
</style>
<body>
<div>
    <div class="container">
        <label>File Name</label>
        <form action="/Lab13/files?file=" method="get">
            <input type="text" name="file"/>
            <input type="submit" value="Download File By Name"/>
        </form>
        <a href="${pageContext.request.contextPath}/files">All Links</a>
    </div>
</div>
</body>
</html>