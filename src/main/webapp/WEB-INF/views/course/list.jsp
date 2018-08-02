<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <title>Course list</title>
</head>
<body>

    <p><a href="${pageContext.request.contextPath}/course/form" >Add Course</a></p>
    <p><a href="${pageContext.request.contextPath}/employee" >Employees</a></p>

    <table class="table table-striped table-bordered table-hover ">
        <thead class="thead-dark">
        <tr>
            <th> Subject </th>
            <th> Employee </th>
            <th> Day of week </th>
            <th> Start </th>
            <th> End </th>
            <th> Room </th>
            <th> Edit </th>
            <th> Delete </th>
        </tr>
        </thead>


        <c:forEach items="${courses}" var="course">
            <tr>
                <td>${course.subject}</td>
                <td>${course.employee.surname}</td>
                <td>${course.dayOfWeek}</td>
                <td>${course.startTime}</td>
                <td>${course.endTime}</td>
                <td>${course.room}</td>
                <td><a href="${pageContext.request.contextPath}/course/edit/${course.id}" >Edit Course</a></td>
                <td><a href="${pageContext.request.contextPath}/course/delete/${course.id}" onclick="return confirm('Are you sure you want to delete this course');">Delete Course</a></td>
            </tr>
        </c:forEach>


    </table>
    <%--<ul>--%>
        <%--<c:forEach items="${courses}" var="course">--%>
            <%--<li>${course.subject}  ${course.dayOfWeek} ${course.startTime} ${course.endTime}  ${course.room}  <a href="${pageContext.request.contextPath}/course/edit/${course.id}" >Edit Course</a>    <a href="${pageContext.request.contextPath}/course/delete/${course.id}" onclick="return confirm('Are you sure you want to delete this course');">Delete Course</a>    </li>--%>
        <%--</c:forEach>--%>
    <%--</ul>--%>
</body>
</html>
