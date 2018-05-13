<%--
  Created by IntelliJ IDEA.
  User: pr0jectf3
  Date: 5/10/2018
  Time: 8:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>User Login</h1>
<link rel='stylesheet' type='text/css' href='<c:url value="/app.css"/>>'/>
<form method = 'POST'>
    Username:
    <input name = 'username' type = \"text\" /><br/><br/>
    </br/>
    Password:
    <input name = 'password'type = \"password\" />
    </br/><br/>
    <button>Login</button>
</form>
</body>
</html>
