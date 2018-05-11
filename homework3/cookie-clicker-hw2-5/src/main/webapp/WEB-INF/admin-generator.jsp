<%--
  Created by IntelliJ IDEA.
  User: pr0jectf3
  Date: 5/10/2018
  Time: 8:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Generators</title>
</head>
<body>
    <link rel='stylesheet' type='text/css' href='/app.css'/>
    <h1>Generators</h1>
    <ul>
        <li><a href="<c:url value='/admin/auth' />">Game Info</a></li>
        <li><a href="<c:url value='/admin/events' />">Events</a></li>
        <li><a href="<c:url value='/admin/generators' />">Generators</a></li>
    </ul>

    <div class="container">

        <form method="POST">
            <h4>Generator Name:</h4>
            <input type="text" name="name"/>
            <h4>Generator Rate:</h4>
            <input type="text" name="rate"/>
            <h4>Generator Cost:</h4>
            <input type="text" name="cost"/>
            <h4>Generator Unlock:</h4>
            <input type="text" name="unlockAt"/>
            <h4>Generator Description:</h4>
            <input type="text" name="description"/>
            <button>ADD</button>
        </form>

    </div>

    <table>
        <tr>
            <th>Name</th>
            <th>Rate</th>
            <th>Cost</th>
            <th>Unlock At</th>
            <th>Edit | Delete</th>
        </tr>
        <c:forEach items="${generators}" var="generator">
        <tr>
            <td><div class="table">${generator.name}</div></td>
            <td><div class="table">${generator.rate}</div></td>
            <td><div class="table">${generator.baseCost}</div></td>
            <td><div class="table">${generator.unlockAt}</div></td>
            <td><a href="../admin/generators/?id=${generator.getId()}">Edit</a> | <a href="../admin/generator/?id=${generator.getId()}">Delete</a></td>

        </tr>
        </c:forEach>

        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>

    </table>
</body>
</html>

