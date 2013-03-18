<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Successfull Login</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2>Success</h2>
Welcome, ${username}
<p>Congratulations! Your admin login was successful</p>
<table>
<c:forEach var="users" items="${users}">
    <tr>
        <td>${users.getUsername()}<td>
        <td>${users.getPassword()}<td>
    </tr>
</c:forEach>
</table>
<br>
<a href=main>Main page</a>
</body>
</html>