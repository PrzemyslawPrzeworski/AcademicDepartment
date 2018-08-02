<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Terpenoids</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>

    <h1>Obtained Retention Index: ${obtainedRetentionIndex}</h1>

    <table class="table table-striped table-bordered table-hover ">
        <thead class="thead-dark">

            <tr>
                <th> Chemical name</th>
                <th> Retention Index</th>
            </tr>
        </thead>


        <c:forEach items="${terpenoids}" var="terpenoid">
            <tr>
                <td> <a href="${terpenoid.link}"> ${terpenoid.chemical_name} </a> </td> </a>
                <td>${terpenoid.retention_index}</td>
            </tr>
        </c:forEach>




    </table>

    <%--<c:forEach items="${terpenoids}" var="terpenoid">--%>
        <%--<li>${terpenoid.chemical_name} ${terpenoid.retention_index}</li>--%>
    <%--</c:forEach>--%>

</body>
</html>
