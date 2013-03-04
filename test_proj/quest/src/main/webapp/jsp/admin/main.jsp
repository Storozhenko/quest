<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<spring:url value="/" var="baseUrl" />
<html>
<head>
    <title>Quest</title>
    <link href="${baseUrl}/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2>Quest</h2>
<spring:message code="label.welcome"/>, ${username}
<br>
<sec:authorize access="isAuthenticated()">
    <a href="<c:url value="/logout"/>">Logout</a>
</sec:authorize>
<span style="float: right">
    <select onchange="window.location=this.options[this.selectedIndex].value">
        <option value=""><spring:message code="label.language"/></option>
        <option value="main?locale=en"><spring:message code="label.language.english"/></option>
        <option value="main?locale=ru"><spring:message code="label.language.russian"/></option>
    </select>
</span>
<br><br>
<br>
<a href="forms"><spring:message code="label.forms"/></a>
<br>
<a href="answForms"><spring:message code="label.forms.filled"/></a>
<br>
<a href="users"><spring:message code="label.users"/></a>
</body>
</html>