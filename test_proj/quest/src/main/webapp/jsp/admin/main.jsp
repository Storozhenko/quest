<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<html>
<head>
    <title>Successful Login</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2>Success</h2>
<spring:message code="label.welcome"/>, ${username}
<br>
<sec:authorize access="isAuthenticated()">
    <a href="<c:url value="/logout"/>">Logout</a>
</sec:authorize>
<span style="float: right">
    <a href="?locale=en">en</a>
    |
    <a href="?locale=ru">ru</a>
</span>
<br><br>
<br>
<a href="forms">Forms</a>
<br>
<a href="answForms">Filled Forms</a>
<br>
<a href="users">Users</a>
<br>
<br>
<a href="${pageContext.request.contextPath}/" title="Home">Home</a>
</body>
</html>