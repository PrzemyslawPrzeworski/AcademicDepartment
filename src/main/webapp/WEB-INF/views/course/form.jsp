<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Course Form</title>
</head>
<body>

    <h1>Add Course</h1>

    <form:form method="post" modelAttribute="course">
        <form:errors path="*"/>

    <div class="form-group">
        <label>Subject</label>
        <form:input path="subject" placeholder="subject" />
        <form:errors path="subject"/>
    </div>

    <div class="form-group">
        <label> Day of week</label>
        <select id="dayOfWeek" name="dayOfWeek">
            <option value="Monday">Monday</option>
            <option value="Tuesday">Tuesday</option>
            <option value="Wednesday">Wednesday</option>
            <option value="Thursday">Thursday</option>
            <option value="Friday">Friday</option>
            <option value="Saturday">Saturday</option>
            <option value="Sunday">Sunday</option>
        </select>
    </div>

    <div class="form-group">
        <label for="startTime" class="sr-only">Start</label>
        <form:input path="startTime" name="startTime" placeholder="Start" type="time" />
    </div>
    <div class="form-group">
        <label for="endTime" class="sr-only">End</label>
        <form:input path="endTime" name="endTime" placeholder="End" type="time" />
    </div>

    <div class="form-group">
        <label>Room</label>
        <form:input path="room" placeholder="room" />
        <form:errors path="room"/>
    </div>

    <div class="form-group">
        <label>Employee</label>
        <form:select path="employee.id"
                     items="${employees}"
                     itemValue="id"
                     itemLabel="surname" />
    </div>


        <%--<form:input path="group" placeholder="group" />--%>
        <%--<form:errors path="group"/>--%>

        <%--<form:input path="faculty" placeholder="faculty" />--%>
        <%--<form:errors path="faculty"/>--%>

        <%--<form:input path="major" placeholder="major" />--%>
        <%--<form:errors path="major"/>--%>

        <%--<form:input path="year" type="number" placeholder="year" />--%>
        <%--<form:errors path="year"/>--%>

        <%--<form:input path="semester" type="number" placeholder="semester" />--%>
        <%--<form:errors path="semester"/>--%>





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
