<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="/" var="baseUrl" />
<html>
<head>
    <title>Welcome!</title>
    <link href="${baseUrl}/css/style.css" rel="stylesheet" type="text/css" />
    <link href="${baseUrl}/css/gstyle_buttons.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2>Quest</h2>
<br>
<br>
<div>
    <form action="login">
        <button class="action bluebtn" style="margin: 5px" type="submit" id="loginLink" /><span class="label">Login</span></button>
    </form>
    <form action="registration">
        <button class="action redbtn" style="margin: 5px" type="submit" id="regLink" /><span class="label">Registration</span></button>
    </form>
</div>
</body>
</html>