<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="../../js/app.js" type="text/javascript"></script>
    <title>Enter Time</title>
</head>
<body>

    <form method="post">
        <input type="text" name="time" placeholder="Measured Retention Time" id="time">
        <input type="submit" value="Calculate" id="submit" disabled>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <p style="color:red", style="font-size: 10px"></p>
    </form>

</body>
</html>
