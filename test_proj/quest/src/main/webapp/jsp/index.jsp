<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/" var="baseUrl" />
<html>
<head>
    <title>Welcome!</title>
    <link href="${baseUrl}/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2>Quest</h2>
<br>
<br>
<a id="loginLink" href="login">Login</a>
<br>
<a id="regLink" href="registration">Registration</a>
</body>
</html>