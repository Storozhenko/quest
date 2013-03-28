<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/" var="baseUrl" />
<html>
<head>
    <title><spring:message code="label.user.add"/></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${baseUrl}/css/style.css" rel="stylesheet" type="text/css" />
    <link href="${baseUrl}/css/gstyle_buttons.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2><spring:message code="label.user.add"/></h2>
<br>
<br>
<form:form method="post" commandName="user" action="addUserAction">
    <table>
        <tr>
            <td><spring:message code="label.username"/>:</td>
            <td><form:input path="username" /></td>
            <td><span class="error"><form:errors path="username" /></span></td>
        </tr>
        <tr>
            <td><spring:message code="label.password"/>:</td>
            <td><form:input path="password" /></td>
            <td><span class="error"><form:errors path="password" /></span></td>
        </tr>
        <tr>
            <td><spring:message code="label.user.type"/>:</td>
            <td><form:select path="userType">
                <option value="ROLE_ADMIN"><spring:message code="label.ROLE_ADMIN"/></option>
                <option value="ROLE_USER"><spring:message code="label.ROLE_USER"/></option>
            </form:select>
            </td>
        </tr>
        <tr>
            <td><spring:message code="label.language"/>:</td>
            <td><form:select path="userLang">
                <option value=""><spring:message code="label.language"/></option>
                <option value="en"><spring:message code="label.language.en"/></option>
                <option value="ru"><spring:message code="label.language.ru"/></option>
            </form:select>
            </td>
        </tr>
        <tr>
            <td colspan="2"></td>
        </tr>
        <tr>
            <td colspan="2"><button class="action bluebtn" type="submit" /><span class="label">OK</span></td>
        </tr>
    </table>
</form:form>
</body>
</html>