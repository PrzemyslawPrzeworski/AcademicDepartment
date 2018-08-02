<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/2.6.0/fullcalendar.css' />

    <script src='http://code.jquery.com/jquery-1.11.3.min.js'></script>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.1/moment.min.js'></script>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/2.6.0/fullcalendar.min.js'></script>
    <script type="text/javascript" src="../../../js/app.js"></script>

    <title>Leave list</title>
</head>
<body>

    <div id='calendar'></div>

    <p><a href="${pageContext.request.contextPath}/holiday/form" >Add Holiday</a></p>

    <ul>
        <c:forEach items="${holidays}" var="holiday">
            <li>${holiday.holiday_start}  ${holiday.holiday_end}  <a href="${pageContext.request.contextPath}/holiday/edit/${holiday.id}" >Edit Holiday</a>    <a href="${pageContext.request.contextPath}/holiday/delete/${holiday.id}" onclick="return confirm('Are you sure you want to delete this holiday');">Delete Holiday</a>    </li>
        </c:forEach>
    </ul>

</body>
</html>
