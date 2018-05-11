<%--
  Created by IntelliJ IDEA.
  User: pr0jectf3
  Date: 4/14/2018
  Time: 5:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Events</title>
</head>
<body>

<h1>Hello events servlet!</h1>
<h1>Incremental Game</h1>
<link rel='stylesheet' type='text/css' href='/app.css'/>
<p>
<h4>Event Name:</h4>
<form method='POST' action="">
    <input name='name' type="text" id="event name">
    </p>
    <p>
    <h4>Event Description:</h4>
    <input name='description' type="text" id="event description"></p>
    <p>
    <h4>Trigger At:</h4>
    <input name='triggerAt' type="text" id="trigger at">
    <button>Add/Edit</button>
</form>
</p>
<table>
    <tr>
        <td>Name</td>
        <td>Description</td>
        <td>Trigger At</td>
        <td>Edit</td>
    </tr>

    <c:forEach items = "${entries}" var = "entry">
        <tr>
            <td>${entry.getName()}</td>
            <td>${entry.getDescription()}</td>
            <td>${entry.getTriggerAt()}</td>
            <td>eed</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

