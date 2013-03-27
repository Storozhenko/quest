<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/" var="baseUrl" />
<html>
<head>
    <title>Success</title>
    <link href="${baseUrl}/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="${baseUrl}/css/gstyle_buttons.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2>Congratulations!</h2>
<br>
Form was filled successfully.
<br>
<br>
<form action="main">
    <button class="action bluebtn" type="submit" name="toMainLink" /><span class="label">Main page</span></button>
</form>
</body>
</html>