<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meals</title>
</head>
<body>
<table>

<c:forEach var="num" items="${list}">
    <tr>
    <c:if test="${num.isExceed()}"><td bgcolor="red">${num}</td></c:if>
    <c:if test="${!num.isExceed()}"><td bgcolor="blue">${num}</td></c:if>
    </tr>
</c:forEach>

</table>
</body>
</html>
