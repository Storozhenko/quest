<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/" var="baseUrl" />
<html>
<head>
    <title><spring:message code="label.form.create"/></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${baseUrl}/css/style.css" rel="stylesheet" type="text/css" />
    <link href="${baseUrl}/css/gstyle_buttons.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2><spring:message code="label.form.create"/></h2>
<br>
<form:form method="post" commandName="form" action="addFormAction">
    <table>
        <tr>
            <td><spring:message code="label.form.name"/>:</td>
            <td><form:input path="formName" size="50" maxlength="100"/></td>
            <td><span class="error"><form:errors path="formName" /></span></td>
        </tr>
        <tr>
            <td><spring:message code="label.description"/>:</td>
            <td><form:input path="formDescr" size="50" maxlength="100"/></td>
        </tr>
        <tr>
            <td colspan="2"></td>
        </tr>
        <tr>
            <td colspan="2"><button class="action bluebtn" type="submit" id="addFormSubmit" /><span class="label">OK</span></td>
        </tr>
    </table>
</form:form>
</body>
</html>