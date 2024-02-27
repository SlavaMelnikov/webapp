<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главная страница</title>
    <style>
        body {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
            font-family: "Times New Roman", serif;
        }
        h1 {
            color: #333;
        }
        .button {
            margin-top: 20px;
            padding: 20px 40px;
            color: white;
            background-color: #0060f1;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<h1>Что будем читать?</h1>
<a href="books-servlet"><button class="button">Выбрать по названию</button></a>
<a href="authors-servlet"><button class="button">Выбрать по автору</button></a>
<a href="stores-servlet"><button class="button">Выбрать по магазину</button></a>
</body>
</html>
