<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<html>
<head>
    <meta charset="utf-8">
    <title>Department Form</title>
</head>
<body>

    <form:form method="post" modelAttribute="department">
        <form:errors path="*"/>

        <form:input path="name" placeholder="name" />
        <form:errors path="name"/>

        <input type="submit" value="Save" />

    </form:form>

</body>
</html>
