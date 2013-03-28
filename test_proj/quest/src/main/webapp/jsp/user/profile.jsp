<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/" var="baseUrl" />
<html>
<head>
    <title><spring:message code="label.profile"/></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${baseUrl}/css/style.css" rel="stylesheet" type="text/css" />
    <link href="${baseUrl}/css/gstyle_buttons.css" rel="stylesheet" type="text/css" />
</head>
<script>
    function toMain() {
        window.location = "main";
    }
</script>
<body>
<h2><spring:message code="label.profile"/></h2>
<br>
<br>
<br>
<form:form method="post" commandName="user" action="updateProfileAction">
    <table>
        <tr>
            <td>ID:</td>
            <td><form:input path="userId" readonly="true"/></td>
        </tr>
        <tr>
            <td><spring:message code="label.username"/>:</td>
            <td><form:input path="username" /></td>
            <td><span class="error"><form:errors path="username" /></span></td>
        </tr>
        <tr>
            <td><spring:message code="label.password"/>:</td>
            <td><form:password path="password" /></td>
            <td><span class="error"><form:errors path="password" /></span></td>
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
            <td><button class="action bluebtn" type="submit" /><span class="label"><spring:message code="label.update"/></span></td>
            <td>
                <button class="action bluebtn" type="button" id="formsToMainLink" onclick="toMain()"><span class="label"><spring:message code="label.page.main"/></span></button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>

