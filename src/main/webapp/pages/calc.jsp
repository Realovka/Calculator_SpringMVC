<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Calc</title>
</head>
<body>
<form action="/calculator/calc" method="post">
    Number 1<input type="number" name="num1" value="${num1}"/>
    Action <select name="type">
    <option>add</option>
    <option>sub</option>
    <option>mult</option>
    <option>div</option>
        <c:forEach items="${operations}" var="item">
            <c:if test="${type.equals(item)}">
                <option selected="selected">${item}</option>
            </c:if>
            <c:if test="${!type.equals(item)}">
                <option>${item}</option>
            </c:if>
        </c:forEach>
    </select>
    Number 2<input type="number" name="num2" value="${num2}"/>
    <input type="submit"/>
    Result <input type="number" name="result" value="${result}">
    ${message}
</form>
</body>
</html>
