<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/images/shortcut_icon.png">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/shortcut_icon.png">
    <title>User-Book</title>
    <meta charset="utf-8">
</head>
<body>

<div id="container">
    <div class="userBookForm">
        <h1>User '${userDto.firstName} ${userDto.lastName}' has: </h1>
        <c:choose>
            <c:when test="${userBookSize=='0'}">
                <h1>No one bookEntity</h1>
                <br />
            </c:when>
            <c:otherwise>
                <c:forEach items="${userDto.simpleBookDtoList}" var="simpleBookDto">
                    <h1> - '${simpleBookDto.name}' book, '${simpleBookDto.author}' author</h1>
                </c:forEach>
                <br />
            </c:otherwise>
        </c:choose>
    </div>
</div>
<div>
    <form method="get" action="${pageContext.request.contextPath}/main">
        <input type="submit" name="back" value="Back"/>
    </form>
</div>

</body>

</html>

