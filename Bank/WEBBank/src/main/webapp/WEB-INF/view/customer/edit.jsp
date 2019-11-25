<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <style><%@include file="/WEB-INF/css/style.css"%></style>
    <title></title>
</head>
<body>

<table>
<tbody>
<tr>
        <th>Имя</th>
        <th>Отчество</th>
        <th>Фамилия</th>
        <th>Возраст</th>
        <th>Адрес</th>
        <th>*Статус*</th>
</tr>

<tr>
    <td> <c:out value="${requestScope.customer.firstName}"/> </td>
    <td> <c:out value="${requestScope.customer.patronymic}"/> </td>
    <td> <c:out value="${requestScope.customer.lastName}"/> </td>
    <td> <c:out value="${requestScope.customer.age}"/> </td>
    <td> <c:out value="${requestScope.customer.adress}"/> </td>
    <c:if test="${requestScope.customer.status == 0}">
        <td> Обычный </td>
    </c:if>
    <c:if test="${requestScope.customer.status == 1}">
        <td> VIP </td>
    </c:if>

</tr>

</tbody>
</table>



                   <form method="post" action="<c:url value='/edit_customer'/>">
                   <td> <input type="number" hidden name="id" value="${requestScope.customer.id}"></td>

                   <td> <input type="text" name="firstName" value="${requestScope.customer.firstName}"></td>
                   <td> <input type="text" name="patronymic" value="${requestScope.customer.patronymic}"></td>
                   <td> <input type="text" name="lastName" value="${requestScope.customer.lastName}"></td>
                   <td> <input type="number" min="16" max="120" name="age" value="${requestScope.customer.age}"></td>
                   <td> <input type="text" name="adress" value="${requestScope.customer.adress}"></td>
                   <td> <input type="number" min="0" max="1" name="status" value="${requestScope.customer.status}"></td>
                   </tr>
                   </tbody>
                   </table>
                   <br>
                   <input type="submit" value="Изменить">
                 </form>

</body>
</html>