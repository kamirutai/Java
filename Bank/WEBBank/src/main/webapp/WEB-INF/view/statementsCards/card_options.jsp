<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <style><%@include file="/WEB-INF/css/credit_style.css"%></style>
    <title></title>
</head>
<body>


<br>
<br>
<br>
<br>



<table>
<tbody>
<tr>
        <th>Накопление бонусов</th>
        <th>Накоплено</th>

        <th>Кэшбэк</th>
        <th>Количество %</th>

        <th>Кэшбэк на АЗС</th>
        <th>Количество %</th>

        <th>Бесплатный обмен валют</th>
        <th>Абонентская плата</th>
</tr>

<tr>
                <c:if test="${requestScope.options.isMiles() == true}">
                    <td> Да </td>
                    <td> <c:out value="${requestScope.options.getMilesIncrementValue()}"/> </td>
                </c:if>
                <c:if test="${requestScope.options.isMiles() != true}">
                     <td> Нет </td>
                     <td> - </td>
                </c:if>

                <c:if test="${requestScope.options.isCashBack() == true}">
                    <td> Да </td>
                    <td> <c:out value="${requestScope.options.getCashBackValue()}"/> </td>
                </c:if>
                <c:if test="${requestScope.options.isCashBack() != true}">
                     <td> Нет </td>
                     <td> - </td>
                </c:if>


                <c:if test="${requestScope.options.isFuelCashback() == true}">
                    <td> Да </td>
                    <td> <c:out value="${requestScope.options.getFuelCashbackValue()}"/> </td>
                </c:if>
                <c:if test="${requestScope.options.isFuelCashback() != true}">
                     <td> Нет </td>
                     <td> - </td>
                </c:if>


                <c:if test="${requestScope.options.isFreeExchange() == true}">
                    <td> Да </td>
                </c:if>
                <c:if test="${requestScope.options.isFreeExchange() != true}">
                     <td> Нет </td>
                </c:if>



                <c:if test="${requestScope.options.isFreetoUse() == true}">
                    <td> Да </td>
                </c:if>
                <c:if test="${requestScope.options.isFreetoUse() != true}">
                     <td> Нет </td>
                </c:if>

</tr>

</tbody>
</table>


</body>
</html>