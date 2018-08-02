<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Holiday Form</title>
</head>
<body>

    <form:form method="post" modelAttribute="holiday">
        <form:errors path="*"/>

        <form:input path="holiday_start_as_string" placeholder="Leave Start" type="date"/>
        <form:errors path="holiday_start_as_string"/>

        <form:input path="holiday_end_as_string" placeholder="Leave End" type="date"/>
        <form:errors path="holiday_end_as_string"/>


        <form:select path="employee.id"
                     items="${employees}"
                     itemValue="id"
                     itemLabel="surname"/>

        <%--&lt;%&ndash;<form:select path="books"&ndash;%&gt;--%>
                     <%--&lt;%&ndash;items="${books}"&ndash;%&gt;--%>
                     <%--&lt;%&ndash;itemValue="id"&ndash;%&gt;--%>
                     <%--&lt;%&ndash;itemLabel="title" />&ndash;%&gt;--%>

        <input type="submit" value="Save" />

    </form:form>

</body>
</html>
