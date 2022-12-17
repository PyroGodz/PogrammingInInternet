<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>index</title>
</head>
<body>

<a style="color: #000000; font-size: 20px" href="ccc?scope=request&cBean=old&access=true&value1=1&value2=2&value3=3"><b>GET with old parameter</b></a>
<br/>
<hr/>

<h2>GET with CBean and values parameters from request attributes</h2>
<a style="color: #000000; font-size: 20px" href="ccc?scope=request&cBean=new&access=true&value1=1&value2=2&value3=3"><b>GET with new parameter (has access)</b></a>
<br/>
<a style="color: #000000; font-size: 20px" href="ccc?scope=request&cBean=new&value1=1&value2=2&value3=3"><b>GET with new parameter (filter 1)</b></a>
<br/>
<a style="color: #000000; font-size: 20px" href="ccc?scope=request&cBean=new&access=true&value1=4&value2=2&value3=3"><b>GET with new parameter (filter 2)</b></a>
<br/>
<a style="color: #000000; font-size: 20px" href="ccc?scope=request&cBean=new&access=true&value1=1&value2=4&value3=3"><b>GET with new parameter (filter 3)</b></a>
<br/><br/>
<hr/>

<h2>GET with CBean and values parameters from session attributes</h2>
<a style="color: #000000; font-size: 20px" href="ccc?scope=session&cBean=new&access=true&value1=1&value2=2&value3=3"><b>GET with new parameter (has access)</b></a>
<br/>
<a style="color: #000000; font-size: 20px" href="ccc?scope=session&cBean=new&value1=1&value2=2&value3=3"><b>GET with new parameter (filter 1)</b></a>
<br/>
<a style="color: #000000; font-size: 20px" href="ccc?scope=session&cBean=new&access=true&value1=4&value2=2&value3=3"><b>GET with new parameter (filter 2)</b></a>
<br/>
<a style="color: #000000; font-size: 20px" href="ccc?scope=session&cBean=new&access=true&value1=1&value2=4&value3=3"><b>GET with new parameter (filter 3)</b></a>
<br/><br/>
<hr/>

</body>
</html>