<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/" var="baseUrl" />
<html>
<head>
    <title><spring:message code="label.login"/></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${baseUrl}/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2><spring:message code="label.login"/></h2>
<br/>
<span style="float: right">
    <select onchange="window.location=this.options[this.selectedIndex].value">
        <option value=""><spring:message code="label.language"/></option>
        <option value="login?locale=en"><spring:message code="label.language.english"/></option>
        <option value="login?locale=ru"><spring:message code="label.language.russian"/></option>
    </select>
</span>
<form:form method="post" commandName="loginForm" action="loginAction">
    <table>
        <tr>
            <td><spring:message code="label.username"/>:</td>
            <td><input id="j_username" name="j_username" size="20" maxlength="50" type="text" /></td>
            <td><span class="error"><form:errors path="j_username" /></span></td>
        </tr>
        <tr>
            <td><spring:message code="label.password"/>:</td>
            <td><input id="j_password" name="j_password" size="20" maxlength="50" type="password" /></td>
            <td><span class="error"><form:errors path="j_password" /></span></td>
        </tr>
        <tr>
            <td colspan="2"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" id="loginSubmit" value="OK" /></td>
        </tr>
    </table>
</form:form>

</body>
</html>