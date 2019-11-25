<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <style><%@include file="/WEB-INF/css/style.css"%></style>
    <title></title>
</head>
<body>

<form method="post" action="<c:url value='/change_result_count'/>">
Отображать результатов:
<input type="number" min="10" name="result" value="${requestScope.resultCount}"></td>
<input type="submit" value="Применить">
</form>


<table>
<tbody>
<tr>
        <th>№</th>
        <th>Имя</th>
        <th>Отчество</th>
        <th>Фамилия</th>
        <th>Возраст</th>
        <th>Адрес</th>
        <th>Баланс</th>
</tr>

<c:set var="counter" value="0"/>
<c:forEach var="user" items="${requestScope.userList}">

<tr>
    <c:set var="counter" value="${counter + 1}"/>
    <td> <c:out value="${counter}"/> </td>
    <td> <c:out value="${user.firstName}"/> </td>
    <td> <c:out value="${user.patronumic}"/> </td>
    <td> <c:out value="${user.lastName}"/> </td>
    <td> <c:out value="${user.age}"/> </td>
    <td> <c:out value="${user.adress}"/> </td>

    <td>
        <form method="get" action="<c:url value='/customer_credists'/>">
             <input type="number" hidden name="customer" value="${user.id}">
             <input type="submit" value="Кредиты">
        </form>
    </td>

</tr>
</c:forEach>
</tbody>
</table>


<br>
<br>
<br>

   <form method="post" action="<c:url value='/select_customer'/>">
         <input type="number" name="forEachTag"></td>
         <input type="submit" value="Назад">
   </form>

   <form method="post" action="<c:url value='/select_customer'/>">
         <input type="number" name="forEachTag"></td>
         <input type="submit" value="Далее">
   </form>

</c:set>

</body>
</html>