<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


    <title>Employee Form</title>
    <style>
        input, select {display: block;}
    </style>
</head>
<body>
    <h1>Add Employee</h1>

<form:form method="post" modelAttribute="employee">
    <form:errors path="*"/>

    <div class="form-group">
        <label for="degrees">Degrees</label>
        <form:select path="degrees"
            items="${allDegrees}"
            itemValue="id"
            itemLabel="title"/>
        <form:errors path="degrees"/>
    </div>

    <div class="form-group">
        <label>Name</label>
        <form:input path="name" placeholder="Name" />
        <form:errors path="name"/>
    </div>

    <div class="form-group">
        <label>Surname</label>
        <form:input path="surname" placeholder="Surname" />
        <form:errors path="surname"/>
    </div>

        <%--<form:textarea path="note" placeholder="Note" />--%>
        <%--<form:errors path="note"/>--%>

        <%--<form:input path="birthdateAsString" type="date" placeholder="Birthdate"/>--%>
        <%--<form:errors path="birthdateAsString"/>--%>
    <div class="form-group">
        <label>E-mail</label>
            <form:input path="email" placeholder = "Email"/>
            <form:errors path="email"/>
    </div>

    <div class="form-group">
        <label>Department</label>
            <form:select path="department.id"
                items="${departments}"
                itemValue="id"
                itemLabel="name"/>
    </div>
        <%--<form:select path="degrees">--%>
        <%--<c:forEach var="item" items="${allDegrees}">--%>
        <%--<c:choose>--%>
        <%--<c:when test="${employee.getDegrees()==item.getDegrees()}">--%>
        <%--<form:option selected="true" value="${item.getDegrees()}">--%>
        <%--<fmt:message key="degree.${item.getDegrees()}" />--%>
        <%--</form:option>--%>
        <%--</c:when>--%>

        <%--<c:otherwise>--%>
        <%--<form:option value="${item.getDegrees()}">--%>
        <%--<fmt:message key="degree.${item.getDegrees()}" />--%>
        <%--</form:option>--%>
        <%--</c:otherwise>--%>
        <%--</c:choose>--%>
        <%--</c:forEach>--%>
        <%--</form:select>--%>
        <%--<form:form method="post" modelAttribute="employee">--%>
        <%--<form:select path="degrees" id="companyName" items="${allDegrees}" itemValue="id" itemLabel="title" />--%>
        <%--</form:form>--%>


        <%--<form:select path="degrees"--%>
                     <%--items="${allDegrees}"--%>
                     <%--itemValue="id"--%>
                     <%--itemLabel="title"/>--%>
        <%--<select>--%>
            <%--<option value="dr" selected></option>--%>
        <%--</select>--%>
        <%--<form:errors path="degrees"/>--%>

        <%--<form:select path="courses"--%>
                     <%--items="${courses}"--%>
                     <%--itemValue="id"--%>
                     <%--itemLabel="subject"/>--%>
        <%--<form:errors path="courses"/>--%>

        <input type="submit" value="Save" />

    </form:form>

</body>
</html>
