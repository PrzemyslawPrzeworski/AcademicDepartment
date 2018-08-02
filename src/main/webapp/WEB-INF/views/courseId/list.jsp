<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Course list</title>
</head>
<body>

    <p><a href="${pageContext.request.contextPath}/course/form" >Add Course</a></p>

    <ul>
        <c:forEach items="${courses}" var="course">
            <li>${course.subject} ${course.student_group} ${course.faculty}  ${course.major}  ${course.year}  ${course.semester}   <a href="${pageContext.request.contextPath}/course/edit/${course.id}" >Edit Course</a>    <a href="${pageContext.request.contextPath}/course/delete/${course.id}" onclick="return confirm('Are you sure you want to delete this course');">Delete Course</a>    </li>
        </c:forEach>
    </ul>

</body>
</html>
