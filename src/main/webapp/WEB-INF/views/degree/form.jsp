<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Degree Form</title>
</head>
<body>

    <form:form method="post" modelAttribute="degree">
        <form:errors path="*"/>

        <form:input path="title" placeholder="Title" />
        <form:errors path="title"/>
        <%--<form:input path="lastName" placeholder="Last Name" />--%>
        <%--<form:errors path="lastName"/>--%>

        <%--<form:input path="yearOfBirth" placeholder="Year of birth" />--%>
        <%--<form:errors path="yearOfBirth"/>--%>

        <%--<form:input path="pesel" placeholder="PESEL" />--%>
        <%--<form:errors path="pesel"/>--%>

        <%--<form:input path="email" placeholder="E-mail" />--%>
        <%--<form:errors path="email"/>--%>

        <%--&lt;%&ndash;<form:select path="publisher.id"&ndash;%&gt;--%>
                     <%--&lt;%&ndash;items="${publishers}"&ndash;%&gt;--%>
                     <%--&lt;%&ndash;itemValue="id"&ndash;%&gt;--%>
                     <%--&lt;%&ndash;itemLabel="name" />&ndash;%&gt;--%>

        <%--&lt;%&ndash;<form:select path="books"&ndash;%&gt;--%>
                     <%--&lt;%&ndash;items="${books}"&ndash;%&gt;--%>
                     <%--&lt;%&ndash;itemValue="id"&ndash;%&gt;--%>
                     <%--&lt;%&ndash;itemLabel="title" />&ndash;%&gt;--%>

        <input type="submit" value="Save" />

    </form:form>

</body>
</html>
