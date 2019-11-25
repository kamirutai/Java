<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <style><%@include file="/WEB-INF/css/style.css"%></style>
    <title></title>
</head>
<body>

<br>
<br>
<br>

<table>
<tbody>
<tr>

        <th>Имя</th>
        <th>Отчество</th>
        <th>Фамилия</th>
        <th>Возраст</th>
        <th>Адрес</th>

</tr>
<tr>
<form method="post" action="<c:url value='/add_customer'/>">
    <td><input type="text" name="firstName"></td>
    <td><input type="text" name="patronymic"></td>
    <td><input type="text" name="lastName"></td>
    <td><input type="number" min="16" max="120" name="age"></td>
    <td><input type="text" name="adress"></td>
    <td><input type="submit" value="Добавить"></td>
</form>

</tr>

</tbody>
</table>






</body>
</html>