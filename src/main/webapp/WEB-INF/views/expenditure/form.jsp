<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<html>
<head>
    <title>Expenditure Form</title>
</head>
<body>

    <h1>Add Expenditure</h1>

    <form:form method="post" modelAttribute="expenditure">
        <form:errors path="*"/>

    <div class="form-group">
        <label>Value</label>
        <form:input path="value" placeholder="Value" type="number" />
        <form:errors path="value"/>
    </div>

    <div class="form-group">
        <label>Note</label>
        <form:input path="note" placeholder="note" />
        <form:errors path="note"/>
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
