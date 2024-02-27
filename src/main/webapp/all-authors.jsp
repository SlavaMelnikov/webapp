<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Список авторов</title>
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
<h1>Нажмите на автора чтобы увидеть его доступные книги</h1>
</br>
</br>
<table>
    <tr>
        <th>Автор</th>
    </tr>
    <c:forEach var="author" items="${listOfAuthors}">
        <tr>
            <td><a href="author/${author.authorId}">${author}</a></td>
            <td>
                <form action="delete-author" method="get">
                    <input type="hidden" name="authorId" value="${author.authorId}" />
                    <input type="submit" value="Удалить" />
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
