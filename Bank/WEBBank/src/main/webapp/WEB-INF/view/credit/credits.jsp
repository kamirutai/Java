<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <style><%@include file="/WEB-INF/css/credit_style.css"%></style>
    <title></title>
</head>
<body>

<br><br><br><br><br><br>
<form name="credits" method="get" action="<c:url value='/add_credit'/>">
<select name="Events">
<option value="0" selected>Выберите кредит</option>
<c:forEach var="credit" items="${requestScope.creditList}">
    <option name="cid" value="${credit.id}">${credit.getCreditName()}</option>
</c:forEach>
</select>

   <input type="text" hidden name="id" value="${requestScope.id}">
   <input type="submit" name="Submit" value="Search">
  </p>
</p>
        <br><br><br><br><br><br><br><br><br><br><br>
</form>



<table>
<tbody>
<tr>
        <th>Название кредита</th>
        <th>Возможный максимум</th>
        <th>Процентная ставка</th>
        <th>Длительность дней</th>
        <th>Желаемая сумма</th>
</tr>
<tr>

<form method="post" action="<c:url value='/add_credit'/>">

<td><input type="text" name="creditName" value="${requestScope.creditName}"></td>
<td><input type="text" name="max" value="${requestScope.maxValue}"></td>
<td><input type="text" name="rate" value="${requestScope.Rate}"></td>
<td><input type="text" name="dl" value="${requestScope.DLong}"></td>
<td><input type="number" name="value" min="1" max="${requestScope.maxValue}" value="0"></td>
<td><input type="text" name="creditid" value="${requestScope.creditid}"></td>
<input type="text" name="id" value="${requestScope.id}">
</tr>
</tbody>
</table>

<input type="submit" value="Оформить">
</form>


</body>
</html>