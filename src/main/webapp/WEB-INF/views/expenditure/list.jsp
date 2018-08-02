<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<html>
<head>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <title>Course list</title>
</head>
<body>

    <p><a href="${pageContext.request.contextPath}/expenditure/form" >Add Expenditure</a></p>
    <p><a href="${pageContext.request.contextPath}/employee" >Employees</a></p>



    <table class="table table-striped table-bordered table-hover ">
        <thead class="thead-dark">
        <tr>
            <th> Value </th>
            <th> Employee </th>
            <%--<th> Date </th>--%>
            <th> Note </th>
            <th> Edit </th>
            <th> Delete </th>
        </tr>
        </thead>


        <c:forEach items="${expenditures}" var="expenditure">
            <tr>
                <td>${expenditure.value}</td>
                <td>${expenditure.employee.surname}</td>

                <%--<td>${fn:substring(expenditure.expenditureDate, 0, 10) }</td>--%>
                <td>${expenditure.note}</td>
                <td><a href="${pageContext.request.contextPath}/expenditure/edit/${expenditure.id}" >Edit Expenditure</a></td>
                <td><a href="${pageContext.request.contextPath}/expenditure/delete/${expenditure.id}" onclick="return confirm('Are you sure you want to delete this expenditure');">Delete Expenditure</a></td>
            </tr>
        </c:forEach>


    </table>

    <h1>Sum: ${sum}</h1>

</body>
</html>
