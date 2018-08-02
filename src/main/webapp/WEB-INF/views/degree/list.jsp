<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Author list</title>
</head>
<body>

    <p><a href="${pageContext.request.contextPath}/degree/form" >Add Degree</a></p>

    <ul>
        <c:forEach items="${degrees}" var="degree">
            <li>${degree.title}    <a href="${pageContext.request.contextPath}/degree/edit/${degree.id}" >Edit Degree</a>    <a href="${pageContext.request.contextPath}/degree/delete/${degree.id}" onclick="return confirm('Are you sure you want to delete this degree');">Delete Degree</a>    </li>
        </c:forEach>
    </ul>

</body>
</html>
