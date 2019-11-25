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
<form name="cards" method="get" action="<c:url value='/add_card'/>">
<select name="Events">
<option value="0" selected>Выберите карту</option>
<c:forEach var="card" items="${requestScope.cardlist}">
    <option name="cid" value="${card.id}">${card.cardName}</option>
</c:forEach>
</select>

   CUSTOMER
   <input type="text" name="id" value="${requestScope.id}">
   <input type="submit" name="Submit" value="Search">
  </p>
</p>
        <br><br><br><br><br><br><br><br><br><br><br>
</form>



<table>
<tbody>
<tr>
        <th>Название карты</th>
        <th>Международная</th>
        <th>Накопление милей</th>
        <th>10 при покупке от суммы (руб)</th>
        <th>Кэшбэк на АЗС</th>
        <th>Процент кэшбэка</th>
        <th>Беспроцентный перевод валют при оплате</th>
        <th>Бесплатное использование</th>
        <th>Кэшбэк с покупок</th>
        <th>Процент кэшбэка</th>

</tr>
<tr>

<form method="post" action="<c:url value='/add_card'/>">
<td>${requestScope.CardName}</td>
<c:if test="${requestScope.International == true}">
   <td>Да</td>
</c:if>
<c:if test="${requestScope.International != true}">
   <td>Нет</td>
</c:if>

<c:if test="${requestScope.isMiles == true}">
   <td>Да</td>
</c:if>
<c:if test="${requestScope.isMiles != true}">
   <td>Нет</td>
</c:if>
<td>${requestScope.MilesCount}</td>


<c:if test="${requestScope.isFuelCashback == true}">
   <td>Да</td>
</c:if>
<c:if test="${requestScope.isFuelCashback != true}">
   <td>Нет</td>
</c:if>
<td>${requestScope.FuelCashbackCount}</td>


<c:if test="${requestScope.isFreeExchange == true}">
   <td>Да</td>
</c:if>
<c:if test="${requestScope.isFreeExchange != true}">
   <td>Нет</td>
</c:if>


<c:if test="${requestScope.isFreetoUse == true}">
   <td>Да</td>
</c:if>
<c:if test="${requestScope.isFreetoUse != true}">
   <td>Нет</td>
</c:if>

<c:if test="${requestScope.isCashBack == true}">
   <td>Да</td>
</c:if>
<c:if test="${requestScope.isCashBack!= true}">
   <td>Нет</td>
</c:if>
<td>${requestScope.CashBackValue}</td>

<input type="text" hidden name="CardName" value="${requestScope.CardName}">
<input type="text" hidden name="International" value="${requestScope.International}">
<input type="text" hidden name="isMiles" value="${requestScope.isMiles}">
<input type="text" hidden name="MilesCount" value="${requestScope.MilesCount}">
<input type="text" hidden name="isFuelCashback" value="${requestScope.isFuelCashback}">
<input type="text" hidden name="FuelCashbackCount" value="${requestScope.FuelCashbackCount}">
<input type="text" hidden name="isFreeExchange" value="${requestScope.isFreeExchange}">
<input type="text" hidden name="isFreetoUse" value="${requestScope.isFreetoUse}">
<input type="text" hidden name="isCashBack" value="${requestScope.isCashBack}">
<input type="text" hidden name="CashBackValue" value="${requestScope.CashBackValue}">
<td><input type="text" hidden name="cardid" value="${requestScope.cardid}"></td>
<input type="text" hidden name="id" value="${requestScope.id}">
</tr>

<tr>
<td> Deposit</td>
<td> Credit</td>
</tr>
</tbody>
</table>

<input type="submit" value="Оформить">
</form>


</body>
</html>