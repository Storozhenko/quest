<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <title>Registration</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2>Registration</h2>
<span style="float: right">
    <a href="?locale=en">en</a>
    |
    <a href="?locale=ru">ru</a>
</span>
<br>
<br>
<form:form method="post" commandName="regForm" action="registrationAction">
    <table>
        <tr>
            <td>Username:</td>
            <td><form:input path="username" /></td>
            <td><span class="error"><form:errors path="username" /></span></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><form:password path="password" /></td>
            <td><span class="error"><form:errors path="password" /></span></td>
        </tr>
        <tr>
            <td>Confirm Password:</td>
            <td><form:password path="confirmPassword" /></td>
            <td><span class="error"><form:errors path="confirmPassword" /></span></td>
        </tr>
        <tr>
            <td>Language:</td>
            <td><form:password path="language" /></td>
        </tr>
        <tr>
            <td colspan="2"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Submit" /></td>
        </tr>
    </table>
</form:form>

</body>
</html>