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
        <th>Дата регистрации</th>
</tr>

<tr>
    <td> <c:out value="${requestScope.customer.firstName}"/> </td>
    <td> <c:out value="${requestScope.customer.patronymic}"/> </td>
    <td> <c:out value="${requestScope.customer.lastName}"/> </td>
    <td> <c:out value="${requestScope.customer.age}"/> </td>
    <td> <c:out value="${requestScope.customer.adress}"/> </td>
    <td> <c:out value="${requestScope.customer.getTextRegistrationDate()}"/> </td>
</tr>

</tbody>
</table>
                   <form method="post" action="<c:url value='/delete_user'/>">
                     <input type="number" hidden name="id" value="${requestScope.customer.id}">

                     <input type="submit" value="Удалить клиента">
                   </form>


                   <form method="get" action="<c:url value='/edit_customer'/>">
                     <input type="number" hidden name="id" value="${requestScope.customer.id}">

                     <input type="submit" value="Изменить данные клиента">
                   </form>
<br>
<br>











КРЕДИТЫ
<br>
Открытые

<table>
<tbody>
<tr>
<th>№</th>
        <th>Название кредита</th>
        <th>Длительность</th>
        <th>Процентная ставка</th>
        <th>Сумма</th>
        <th>Погашено</th>
        <th>Взят</th>
</tr>

<c:set var="counter" value="0"/>
<c:forEach var="credit" items="${requestScope.creditCustomer}">

 <c:if test="${credit.closed != true}">

<tr>
    <c:set var="counter" value="${counter + 1}"/>
    <td> <c:out value="${counter}"/> </td>
    <td> <c:out value="${credit.getCredit().getCreditName()}"/> </td>
    <td> <c:out value="${credit.getCredit().getDaysLong()}"/> </td>
    <td> <c:out value="${credit.getCredit().getRate()}"/> </td>
    <td> <c:out value="${credit.value}"/> </td>
    <td> <c:out value="${credit.repaidValue}"/> </td>
    <td> <c:out value="${credit.getTextTaken()}"/> </td>
</tr>
</c:if>

</c:forEach>
</tbody>
</table>


<br>
<br>
Кредитная история (закрытые кредиты)
<table>
<tbody>
<tr>
<th>№</th>
        <th>Название кредита</th>
        <th>Длительность</th>
        <th>Процентная ставка</th>
        <th>Сумма</th>
        <th>Погашено</th>
        <th>Взят</th>
</tr>

<c:set var="counter" value="0"/>
<c:forEach var="credit" items="${requestScope.creditCustomer}">

 <c:if test="${credit.closed == true}">


<tr>
    <c:set var="counter" value="${counter + 1}"/>
    <td> <c:out value="${counter}"/> </td>
    <td> <c:out value="${credit.getCredit().getCreditName()}"/> </td>
    <td> <c:out value="${credit.getCredit().getDaysLong()}"/> </td>
    <td> <c:out value="${credit.getCredit().getRate()}"/> </td>
    <td> <c:out value="${credit.value}"/> </td>
    <td> <c:out value="${credit.repaidValue}"/> </td>
    <td> <c:out value="${credit.getTextTaken()}"/> </td>
</tr>
</c:if>

</c:forEach>
</tbody>
</table>
                   <form method="get" action="<c:url value='/add_credit'/>">
                     <input type="number" hidden name="id" value="${requestScope.customer.id}">

                     <input type="submit" value="Оформить кредит">
                   </form>



<br>
<br>





<table>
<tbody>
<tr>
        <th>№</th>
        <th>Карта</th>
        <th>Тип</th>
        <th>Номер карты</th>
        <th>Доступная сумма</th>
        <th>Дата оформления</th>

</tr>
















КАРТЫ
<c:set var="counter" value="0"/>
<c:forEach var="statement" items="${requestScope.customerStatementsCards}">
<tr>

            <c:if test="${statement.getCard() != null}">

                <c:set var="counter" value="${counter + 1}"/>
                <td> <c:out value="${counter}"/>  </td>

                <td> <c:out value="${statement.getCard().getCardName()}"/>  </td>

                <c:if test="${statement.isDeposit() == true}">
                   <td>Депозитная </td>
                </c:if>
                <c:if test="${statement.isDeposit() == false}">
                   <td>Кредитная </td>
                </c:if>

                <td> <c:out value="${statement.getCardNumber()}"/> </td>
                <td> <c:out value="${statement.getStatement().getValue()}"/> </td>
                <td> <c:out value="${statement.getTextRegistrationDate()}"/> </td>
                <td>
                   <form method="get" action="<c:url value='/card_options'/>">
                     <input type="number" hidden name="id" value="${statement.getCard().getOptions().getId()}">

                     <input type="submit" value="Подробнее">
                   </form>
                </td>

            </c:if>

</tr>
</c:forEach>
</tbody>
</table>
                   <form method="get" action="<c:url value='/add_card'/>">
                     <input type="number" hidden name="id" value="${requestScope.customer.id}">

                     <input type="submit" value="Оформить карту">
                   </form>
<br>
<br>














СЧЕТА
<table>
<tbody>
<tr>
<tr>
        <th>№</th>
        <th>Тип</th>
        <th>Номер счета</th>
        <th>Доступная сумма</th>
        <th>Дата оформления</th>

</tr>

<c:set var="counter" value="0"/>
<c:forEach var="statement" items="${requestScope.customerStatementsCards}">
<tr>
            <c:if test="${statement.getCard() == null}">
                <c:set var="counter" value="${counter + 1}"/>
                <td> <c:out value="${counter}"/> </td>

                <c:if test="${statement.isDeposit() == true}">
                   <td>Депозитный </td>
                </c:if>
                <c:if test="${statement.isDeposit() == false}">
                   <td>Кредитный </td>
                </c:if>

                <td> <c:out value="${statement.getStatement().getStatementNumber()}"/> </td>
                <td> <c:out value="${statement.getStatement().getValue()}"/> </td>
                <td> <c:out value="${statement.getTextRegistrationDate()}"/> </td>
            </c:if>


</tr>
</c:forEach>
</tbody>
</table>
                   <form method="get" action="<c:url value='/add_statement'/>">
                     <input type="number" hidden name="id" value="${requestScope.customer.id}">

                     <input type="submit" value="Открыть счет">
                   </form>











</body>
</html>