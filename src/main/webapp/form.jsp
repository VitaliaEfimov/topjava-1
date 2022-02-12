<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Meals</title>
</head>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h1>Create(update) form</h1>
<form action="meals" method="post">
    <p>Дата и время: <input type="datetime-local" name="date"/></p>
    <p>Описание: <input type="text" lang="ru" name="description"/></p>
    <p>Калории: <input type="number" name="calories"/></p>
    <input type="submit" value="Отправить">
</form>
</body>
</html>