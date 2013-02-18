<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Forms</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2>Forms</h2>
<br>
<table>
    <c:forEach var="forms" items="${forms}">
        <tr>
            <td>${forms.formName}<td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="createForm">Create form</a>
</body>
</html>