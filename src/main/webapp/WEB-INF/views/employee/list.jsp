<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<html>
<head>

    <%--<!-- Latest compiled and minified CSS -->--%>
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">--%>
    <%--<!-- jQuery library -->--%>
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>--%>
    <%--<!-- Latest compiled JavaScript -->--%>
    <%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <title>Employee list</title>
</head>
<body>






<div class="container">

    <a style="float: right" href="${pageContext.request.contextPath}/course">All Courses</a>
    <br>

            <a style="float: right" href="${pageContext.request.contextPath}/publication">All Publications</a>
<br>

    <p><a style="float: right" href="${pageContext.request.contextPath}/expenditure">All Expenditures</a>
    </p>


    <div style="position: relative">
        <span style="font-size: 50px"><b>Employees</b></span>
        <p style="position: absolute; bottom: 0; right: 600"><a href="${pageContext.request.contextPath}/employee/form" >Add Employee</a></p>
        <p style="position: absolute; bottom: 0; right: 400"><a href="${pageContext.request.contextPath}/course/form" >Add Course</a></p>
        <p style="position: absolute; bottom: 0; right: 200"><a href="${pageContext.request.contextPath}/publication/form" >Add Publication</a></p>
        <p style="position: absolute; bottom: 0; right: 0"><a href="${pageContext.request.contextPath}/expenditure/form" >Add Expenditure</a></p>
    </div>

    <table class="table table-striped table-bordered table-hover ">
            <thead class="thead-dark">
            <tr>
                <th> Name </th>
                <th> Department </th>
                <%--<th> Birthdate </th>--%>
                <th> Courses </th>
                <th>  </th>
                <th>  </th>
                <th>  </th>
                <th>  </th>
            </tr>
            </thead>

            <c:forEach items="${employees}" var="employee">
            <tr>
                <td>
                    <c:forEach items="${employee.degrees}" var="degree">
                        ${degree.title}
                    </c:forEach>
                        ${employee.name}
                        ${employee.surname}
                </td>
                <td>${employee.department.name}</td>

                <%--<td> ${fn:substring(employee.birthdate, 0, 10) } </td>--%>
                <td>
                <c:forEach items="${employee.courses}" var="course">
                    <ul>
                        <li> ${course.subject}, ${course.dayOfWeek} ${course.startTime} - ${course.endTime}, Room ${course.room}</li>
                    </ul>

                </c:forEach>
                </td>
                <td> <a href="${pageContext.request.contextPath}/publication/employee/${employee.id}" > Publications </a> </td>
                <td> <a href="${pageContext.request.contextPath}/expenditure/employee/${employee.id}" > Expenditures </a> </td>
                <td> <a href="${pageContext.request.contextPath}/employee/edit/${employee.id}" >Edit </a> </td>
                <td> <a href="${pageContext.request.contextPath}/employee/delete/${employee.id}" onclick="return confirm('Are you sure you want to delete this degree');" >Delete </a> </td>
            </tr>
            </c:forEach>
        </table>




    <table class="table table-striped table-bordered table-hover ">
        <thead class="thead-dark">
        <tr>
            <th> Department </th>
            <th>  </th>
            <th>  </th>
        </tr>
        </thead>

        <c:forEach items="${departments}" var="department">
            <tr>
                <td>${department.name}</td>
                <td><a href="${pageContext.request.contextPath}/publication/department/${department.id}" >Publications </a></td>
                <td><a href="${pageContext.request.contextPath}/expenditure/department/${department.id}" > Expenditures </a></td>
            </tr>
        </c:forEach>
    </table>



    </div>

    <td><a href="${pageContext.request.contextPath}/retention" >Calculate retention index </a>

</body>
</html>
