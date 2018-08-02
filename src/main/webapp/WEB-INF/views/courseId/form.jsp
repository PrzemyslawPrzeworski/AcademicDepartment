<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Course Form</title>
</head>
<body>

    <form:form method="post" modelAttribute="courseId">
        <form:errors path="*"/>

        <form:input path="subject" placeholder="subject" />
        <form:errors path="subject"/>

        <form:input path="student_group" placeholder="group" />
        <form:errors path="student_group"/>

        <form:input path="faculty" placeholder="faculty" />
        <form:errors path="faculty"/>

        <form:input path="major" placeholder="major" />
        <form:errors path="major"/>

        <form:input path="year" type="number" placeholder="year" />
        <form:errors path="year"/>

        <form:input path="semester" type="number" placeholder="semester" />
        <form:errors path="semester"/>

        <form:select path="course.id"
                     items="${courses}"
                     itemValue="id"
                     itemLabel="subject" />





        <%--<form:input path="lastName" placeholder="Last Name" />--%>
        <%--<form:errors path="lastName"/>--%>

        <%--<form:input path="yearOfBirth" placeholder="Year of birth" />--%>
        <%--<form:errors path="yearOfBirth"/>--%>

        <%--<form:input path="pesel" placeholder="PESEL" />--%>
        <%--<form:errors path="pesel"/>--%>

        <%--<form:input path="email" placeholder="E-mail" />--%>
        <%--<form:errors path="email"/>--%>



        <%--&lt;%&ndash;<form:select path="books"&ndash;%&gt;--%>
                     <%--&lt;%&ndash;items="${books}"&ndash;%&gt;--%>
                     <%--&lt;%&ndash;itemValue="id"&ndash;%&gt;--%>
                     <%--&lt;%&ndash;itemLabel="title" />&ndash;%&gt;--%>

        <input type="submit" value="Save" />

    </form:form>

</body>
</html>
