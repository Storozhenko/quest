<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Fill form</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2>Fill form</h2>
<table>
    <c:forEach var="quests" items="${quests}">
        <tr>
            <td>${quests.questionName}<td>
        </tr>
    </c:forEach>
</table>
</body>
</html>