<%--
  Created by IntelliJ IDEA.
  User: pr0jectf3
  Date: 5/10/2018
  Time: 8:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>McNugget Clicker</title>
    <link rel="stylesheet" href="app.css">
</head>

<body class = "body">


<div class = "title">
    <h1> McNugget Clicker</h1>
</div>
<main>
    <div class = "story">
        <game-story-book></game-story-book>
    </div>
    <div class ="jj">

        <game-generator data-id="0"></game-generator>
        <game-generator data-id="1"></game-generator>
        <game-generator data-id="2"></game-generator>
        <game-generator data-id="3"></game-generator>
        <game-generator data-id="4"></game-generator>
        <game-generator data-id="5"></game-generator>
        <game-generator data-id="6"></game-generator>

        <div class = "function">
            <game-button></game-button>
            <game-counter></game-counter>

        </div>
    </div>
</main>
</body>

<script type="text/javascript">
    generators = ${generator};
    for(i = 0 ; i < generators.length ; i++){
        generators[i].type = 'autonomous';
        generators[i].unlockValue = generators[i].unlockAt;
        generators[i].quantity = 0;
        delete generators[i].unlockAt;
        delete generators[i].id;
    }
    stories = ${stories};
    for(i = 0 ; i < stories.length ; i++){
        stories[i].triggeredAt = stories[i].triggerAt;
        stories[i].state = 'hidden';
        delete stories[i].triggerAt;
        delete stories[i].id;
    }
    var backInfo = {};
    backInfo.counter = 0;
    backInfo.generators = generators;
    backInfo.story = stories;
</script>


</html>
