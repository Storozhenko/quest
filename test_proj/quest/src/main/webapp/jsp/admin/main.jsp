<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<spring:url value="/" var="baseUrl" />
<html>
<head>
    <title>Quest</title>
    <link href="${baseUrl}/css/style.css" rel="stylesheet" type="text/css" />
    <link href="${baseUrl}/css/gstyle_buttons.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2>Quest</h2>
<spring:message code="label.welcome"/>, ${username}
<br>
<sec:authorize access="isAuthenticated()">
    <a href="<c:url value="/logout"/>"><spring:message code="label.logout"/></a>
</sec:authorize>
<span style="float: right">
    <select onchange="window.location=this.options[this.selectedIndex].value">
        <option value=""><spring:message code="label.language"/></option>
        <option value="?locale=en"><spring:message code="label.language.english"/></option>
        <option value="?locale=ru"><spring:message code="label.language.russian"/></option>
    </select>
</span>
<br><br>
<br>
<div>
    <form action="forms">
        <button class="action bluebtn" type="submit" id="adminFormsLink" /><span class="label"><spring:message code="label.forms"/></span></button>
    </form>
    <form action="answForms">
        <button class="action bluebtn" type="submit" id="adminAnswFormsLink" /><span class="label"><spring:message code="label.forms.filled"/></span></button>
    </form>
    <form action="users">
        <button class="action bluebtn" type="submit" id="adminUsersLink" /><span class="label"><spring:message code="label.users"/></span></button>
    </form>
</div>
</body>
</html>