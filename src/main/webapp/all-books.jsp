<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Список книг</title>
    <style>
        body {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
            font-family: "Times New Roman", serif;
        }
        table {
            border-collapse: collapse;
            width: 50%;
        }
        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 15px;
        }
        tr:nth-child(even) {
            background-color: #dddddd;
        }
        .button {
            padding: 5px 10px;
            color: white;
            background-color: #007BFF;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .home-link {
            position: absolute;
            top: 10px;
            left: 10px;
        }
    </style>
</head>
<body>
    <div class="home-link">
        <a href="index.jsp">На главную страницу</a>
    </div>
    </br>
    </br>
    <a href="add-book.jsp" class="button">Добавить новую книгу</a>
    </br>
    </br>
    <table>
        <tr>
            <th>Название</th>
            <th>Автор</th>
            <th>Цена</th>
        </tr>
        <c:forEach var="book" items="${listOfBooks}">
            <tr>
                <td><a href="book/${book.bookId}">${book.title}</a></td>
                <td><a href="book/${book.bookId}">${book.author}</a></td>
                <td>${book.price}</td>
                <td><button class="button">Изменить</button></td>
                <td>
                    <form action="delete-book" method="get">
                        <input type="hidden" name="bookId" value="${book.bookId}" />
                        <input type="submit" value="Удалить" />
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

