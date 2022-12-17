<%@ page import="java.io.FileWriter" %>
<%@ page import="java.io.BufferedWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Morning</title>
</head>
<body>
<%
    BufferedWriter writer = new BufferedWriter(new FileWriter(request.getContextPath() + "./src/main/logs/stdout.txt", true));
    writer.write("Morning");
    writer.append("\n");
    writer.close();
%>
<h1>Morning</h1>
</body>
</html>
