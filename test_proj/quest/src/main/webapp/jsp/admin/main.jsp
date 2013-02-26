<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <title>Successfull Login</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2>Success</h2>
<spring:message code="label.welcome"/>, ${username}
<p>Congratulations! Your admin login was successful</p>
<span style="float: right">
    <a href="admin/adminMain?locale=en">en</a>
    |
    <a href="admin/adminMain?locale=ru">ru</a>
</span>
<br>
<a href="forms">Forms</a>
<br>
<a href="users">Users</a>
<br>
<br>
<a href="${pageContext.request.contextPath}/" title="Home">Home</a>
</body>
</html>