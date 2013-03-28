<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/" var="baseUrl" />
<html>
<head>
    <title><spring:message code="label.success"/></title>
    <link href="${baseUrl}/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="${baseUrl}/css/gstyle_buttons.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2><spring:message code="label.congratulations"/>!</h2>
<br>
<spring:message code="label.fill.success"/>
<br>
<br>
<form action="main">
    <button class="action bluebtn" type="submit" name="toMainLink" /><span class="label"><spring:message code="label.page.main"/></span></button>
</form>
</body>
</html>