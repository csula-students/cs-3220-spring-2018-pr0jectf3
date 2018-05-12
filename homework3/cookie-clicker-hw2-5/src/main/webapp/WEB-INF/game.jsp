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
    <style>
        .button-buy button{
            background-color: firebrick;
            border: 2px solid wheat;
            color: white;
            cursor: pointer;
            width: 100%;
            height: 100px;
            display: block;

        }

        .button-buy button:hover{
            background-color: firebrick;
            transform: translateX(20px);
            color: ghostwhite;

        }

        .button-buy button:hover .tooltiptext {
            visibility: visible;
        }

        .button-buy button:active{
            transform: translateY(10px);
            background-color: wheat;
        }

        .story{
            background-color: transparent;
            color: wheat;
            overflow-y: scroll;
            margin-right: 500px;
            margin-left: 525px;
            margin-bottom: 50px;
            margin-top: 10px;

        }

        .title{
            border: none;
            margin: 20px;
            margin-left: 450px;
            color: wheat;
            font-family: fantasy;
            font-size: 30pt;



        }


        .jj{
            display: flex;

        }

        .count{
            margin-left: 450px;
            font-size: 75pt;
            font-family: fantasy;
            color: wheat;
            border: 0;
            backface-visibility: hidden;
        }

        .clicker{
            background-size: 500px 500px;
            background-color: firebrick;
            height: 500px;
            width: 500px;
            display: block;
            margin-left: 250px;
            background-repeat: no-repeat;
            border: 0;
        }

        .clicker:active{
            transform: translateY(5px);

        }

        .body{;
            background-color: aqua;
        }

        .top-row{
            display: flex;
            justify-content: space-between;
            font-family: cursive;
        }

        .tooltiptext {
            visibility: hidden;
            width: 320px;
            height: 85px;
            background-color: darkgray;
            color: #fff;
            text-align: center;
            border-radius: 6px;
            padding: 5px 0;

            /* Position the tooltip */
            position:absolute;
            z-index: 1;
        }

        .cost{
            display: flex;
            justify-content: flex-end;
            margin-bottom: 5px;
            color: yellow;
        }
    </style>
    <script type = "text/javascript" src= "app.bundle.js">
        generators = ${generator};
        for(i = 0 ; i < generators.length ; i++){
            generators[i].type = 'generators';
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

<script type = "text/javascript" src= "app.bundle.js">

</script>


</html>
