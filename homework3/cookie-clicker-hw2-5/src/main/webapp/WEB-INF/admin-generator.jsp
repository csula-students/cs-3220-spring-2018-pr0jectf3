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
    <title>Generators</title>
</head>
<body>
    <link rel = "stylesheet" type=" text/css" href="<c:url value="/app.css" />"/>
    <h1>Generators</h1>
    <ul>
        <li><a href="<c:url value="/admin"/>"> Game</a></li>
        <li><a href="<c:url value="/admin/events"/>"> Events</a></li>
        <li><a href="<c:url value="/admin/generators"/>"> Generators</a></li>
    </ul>

    <div class="container">

        <form method="POST">
            <h4>Generator Name:</h4>
            <input type="text" name="name" value="<c:if test="${index != -1}">${generators.get(index).name}</c:if>"/>
            <h4>Generator Rate:</h4>
            <input type="text" name="rate" value="<c:if test="${index != -1}">${generators.get(index).rate}</c:if>"/>
            <h4>Generator Cost:</h4>
            <input type="text" name="cost" value="<c:if test="${index != -1}">${generators.get(index).baseCost}</c:if>"/>
            <h4>Generator Unlock:</h4>
            <input type="text" name="unlockAt" value="<c:if test="${index != -1}">${generators.get(index).unlockAt}</c:if>"/>
            <h4>Generator Description:</h4>
            <input type="text" name="description" value="<c:if test="${index != -1}">${generators.get(index).description}</c:if>"/>
            <button>Add/Edit</button>
        </form>

    </div>

    <table>
        <tr>
            <th>Name</th>
            <th>Rate</th>
            <th>Cost</th>
            <th>Unlock At</th>
            <th>Add | Edit</th>
        </tr>
        <c:forEach items="${generators}" var="generator">
        <tr>
            <td><div class="table">${generator.name}</div></td>
            <td><div class="table">${generator.rate}</div></td>
            <td><div class="table">${generator.baseCost}</div></td>
            <td><div class="table">${generator.unlockAt}</div></td>
            <td><a href="generators?id=${generator.id}">Edit</a> | <a href="generators?deleteId=${generator.id}">Edit</a></td>

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

