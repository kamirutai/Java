<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <style><%@include file="/WEB-INF/css/transaction_style.css"%></style>
    <title></title>
</head>
<body>

<table>
<tbody>
<tr>

        <th>Отправитель</th>
        <th>Дата</th>
        <th>Сумма</th>
</tr>

  <c:forEach var="transact" items="${requestScope.transactions}">
<tr>
        <td>  <c:out value="${transact.sender}"/>  </td>
        <td>  <c:out value="${transact.dateTime}"/>  </td>
        <td>  <c:out value="${transact.value}"/>  </td>
</tr>

</c:forEach>
</tbody>
</table>

<br>
<br>
<br>
                <form method="post" action="<c:url value='/add_transaction'/>">
                   <label>Сумма</label>
                   <input type="number" min="1" name="value">

                 <form method="post" action="<c:url value='/select_customer'/>">
                    <input type="number" hidden name="senderId" value="${requestScope.id}">
                    <input type="submit" value="Получатель">
                 </form>


                   <input type="number" hidden name="senderId" value="${requestScope.id}">
                   <input type="submit" value="Перевести">
                </form>
</body>
</html>