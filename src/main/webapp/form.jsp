<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Meal</title>
</head>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h1>Create(update) form</h1>
<jsp:useBean id="meal" type="ru.javawebinar.topjava.model.Meal" scope="request" />
<form action="meals" method="post">
    <input type="hidden" name="id" value="${meal.id}">
    <p>Дата и время: <input type="datetime-local" value="${meal.dateTime}" name="date"/></p>
    <p>Описание: <input type="text" lang="ru" value="${meal.description}" name="description"/></p>
    <p>Калории: <input type="number" value="${meal.calories}" name="calories"/></p>
    <button type="submit">Отправить</button>
    <button onclick="window.history.back()">Назад</button>
</form>
</body>
</html>