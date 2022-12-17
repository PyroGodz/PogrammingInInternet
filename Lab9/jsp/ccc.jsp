<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="lab9.CBean" %>
<html>
<head>
    <title>ccc</title>
</head>
<body>
<h2>atrCBean</h2>
<%
    CBean objFromReq = (CBean) request.getAttribute("atrCBean");
    CBean objFromSess = (CBean) request.getSession().getAttribute(request.getSession().getId());
    String sessionId = request.getSession().getId();
%>
<h2>Values from attribute of request</h2>
<h2>Session ID: <%= sessionId %></h2>
<div>
    <h3><%=objFromReq != null? objFromReq.getValue1() : null %></h3>
    <h3><%=objFromReq != null? objFromReq.getValue2() : null %></h3>
    <h3><%=objFromReq != null? objFromReq.getValue3() : null %></h3>
</div>
<h2>Values from attribute of session</h2>
<div>
    <h3><%=objFromSess != null? objFromSess.getValue1() : null %></h3>
    <h3><%=objFromSess != null? objFromSess.getValue2() : null %></h3>
    <h3><%=objFromSess != null? objFromSess.getValue3() : null %></h3>
</div>
</body>
</html>