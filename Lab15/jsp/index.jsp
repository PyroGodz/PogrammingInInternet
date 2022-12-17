<%@ page import="lab15.EmailAdmin" %>
<%@ page import="javax.mail.MessagingException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Messages</title>
</head>
<style>
    a {
        display: block;
        width: 90px;
        color: black;
        font-size: 19px;
        text-decoration: none;
        border: 2px solid black;
        border-radius: 10px;
        text-align: center;
        font-weight: bold;
        padding: 8px;
        margin: 10px;
    }

    a:hover {
        color: blue;
    }
</style>
<body>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.0/jquery.min.js"></script>
<a href="sendmail.html">Send Message</a>
<h1>Messages:</h1>
<script>
    $(document).ready(function() {
            <%
                String inbox = EmailAdmin.showMessages(application.getInitParameter("UserEmail"), application.getInitParameter("UserPassword"));
            %>
            $("#result").innerHTML="<%=inbox%>";
        });
</script>
<h2 id="result"/>
</body>
</html>