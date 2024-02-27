<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Добавить новый магазин</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            font-family: "Times New Roman", serif;
        }
        form {
            display: flex;
            flex-direction: column;
            width: 50%;
        }
        input {
            margin-bottom: 10px;
            padding: 10px;
            font-size: 16px;
        }
        .button {
            padding: 5px 10px;
            color: white;
            background-color: #007BFF;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<form action="add-store-servlet" method="post">
    <input type="text" name="city" placeholder="Город" required>
    <input type="text" name="street" placeholder="Улица" required>
    <input type="text" name="building" placeholder="Дом" required>
    <input type="submit" value="Добавить новый магазин" class="button">
</form>
</body>
</html>
