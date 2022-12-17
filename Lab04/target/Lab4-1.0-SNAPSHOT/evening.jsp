<%@ page import="java.io.BufferedWriter" %>
<%@ page import="java.io.FileWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Evening</title>
</head>
<body>
<%
    BufferedWriter writer = new BufferedWriter(new FileWriter(request.getContextPath() + "./src/main/logs/stdout.txt", true));
    writer.write("Evening");
    writer.append("\n");
    writer.close();
%>
<h1>Evening</h1>
</body>
</html>
