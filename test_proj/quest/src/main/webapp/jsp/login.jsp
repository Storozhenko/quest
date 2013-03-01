<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <title>Login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2>Login</h2>
<br/>
<span style="float: right">
    <a href="?locale=en">en</a>
    |
    <a href="?locale=ru">ru</a>
</span>
<form:form method="post" commandName="loginForm" action="loginAction">
    <table>
        <tr>
            <td>Username:</td>
            <td><input id="j_username" name="j_username" size="20" maxlength="50" type="text" /></td>
            <td><span class="error"><form:errors path="j_username" /></span></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input id="j_password" name="j_password" size="20" maxlength="50" type="password" /></td>
            <td><span class="error"><form:errors path="j_password" /></span></td>
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