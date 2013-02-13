<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Successfull Login</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2>Success</h2>
${username}
<p>Congratulations! Your admin login was successful</p>
<br>
<a href="admin/tests">Tests</a> <a href="admin/users">Users</a>

<a href="${pageContext.request.contextPath}/" title="Home">Home</a>
</body>
</html>