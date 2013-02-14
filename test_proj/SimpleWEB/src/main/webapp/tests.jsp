<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Tables</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2>Success</h2>
Welcome, ${username}
<p>Congratulations! Your admin login was successful</p>
<br>
<a href="${pageContext.request.contextPath}/" title="Home">Home</a>
</body>
</html>