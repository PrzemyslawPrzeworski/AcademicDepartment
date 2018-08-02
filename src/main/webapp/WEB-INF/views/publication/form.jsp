<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<html>
<head>
    <title>Publication Form</title>
</head>
<body>

    <h1>Add Publication</h1>

    <form:form method="post" modelAttribute="publication">
        <form:errors path="*"/>

    <div class="form-group">
        <label>Title</label>
        <form:input path="title" placeholder="title" />
        <form:errors path="title"/>
    </div>

    <div class="form-group">
        <label>Date</label>
        <form:input path="publicationDateAsString" type="date" />
        <form:errors path="publicationDateAsString"/>
    </div>

    <div class="form-group">
        <label>Journal</label>
        <form:input path="journal" placeholder="journal" />
        <form:errors path="journal"/>
    </div>

    <div class="form-group">
        <label>Employee</label>
        <form:select path="employee.id"
                     items="${employees}"
                     itemValue="id"
                     itemLabel="surname" />
    </div>

        <input type="submit" value="Save" />

    </form:form>

</body>
</html>
