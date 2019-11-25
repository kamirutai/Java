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
<form method="post" action="<c:url value='/change_result_count'/>">
Отображать результатов:
<input type="number" min="10" name="result" value="${requestScope.resultCount}"></td>
<input type="submit" value="Применить">
</form>

<br>
<br>



<form method="get" action="<c:url value='/add_customer'/>">
<input type="submit" value="Добавить клиента">
</form>


<br>
<br>
<br>


<table>
<tbody>
<tr>

        <th>№</th>
        <th>Имя</th>
        <th>Отчество</th>
        <th>Фамилия</th>
        <th>Возраст</th>
        <th>Адрес</th>
        <th>Подробнее</th>

</tr>


<c:set var="counter" value="${requestScope.startIndex}"/>
<c:forEach var="user" items="${requestScope.userList}">

<tr>
    <c:set var="counter" value="${counter + 1}"/>
    <td> <c:out value="${counter}"/> </td>

    <td> <c:out value="${user.firstName}"/> </td>
    <td> <c:out value="${user.patronymic}"/> </td>
    <td> <c:out value="${user.lastName}"/> </td>
    <td> <c:out value="${user.age}"/> </td>
    <td> <c:out value="${user.adress}"/> </td>

   <td>
        <form method="get" action="<c:url value='/customer_about'/>">
             <input type="number" hidden name="id" value="${user.id}">
             <input type="submit" value="Подробнее">
        </form>
    </td>



</tr>
</c:forEach>


</tbody>
</table>


<br>
<br>
<br>



                <c:if test="${requestScope.stop == 0}">
                           <form method="get" action="<c:url value='/'/>">
                                <input type="number" hidden name="startIndex" value="${requestScope.startIndex}">
                                <input type="submit" value="Назад">
                           </form>
                           <form method="post" action="<c:url value='/'/>">
                                <input type="number" hidden name="startIndex" value="${requestScope.startIndex}">
                                <input type="submit" value="Вперед">
                           </form>
                </c:if>

                <c:if test="${requestScope.stop == 1}">
                           <form method="get" action="<c:url value='/'/>">
                                <input type="number" hidden name="startIndex" value="${requestScope.startIndex}">
                                <input type="submit" value="Назад">
                           </form>
                </c:if>



</body>
</html>