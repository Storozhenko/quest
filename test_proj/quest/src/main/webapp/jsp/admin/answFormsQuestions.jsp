<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://github.com/datatables4j" prefix="datatables"  %>
<spring:url value="/" var="baseUrl" />
<html>
<head>
    <title>Filled Forms</title>
    <link rel="stylesheet" type="text/css" href="${baseUrl}/css/style.css"/>
    <link rel="stylesheet" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.2/css/jquery.dataTables.css">
    <link rel="stylesheet" href="${baseUrl}/css/jquery.dataTables.css">
</head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="//ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.2/jquery.dataTables.min.js"></script>


<body>
<h2>Filled Forms</h2>
<br>
<table border="1">
    <thead>
    <tr>
        <th>Question</th>
        <th>Answer</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="quests" items="${answQuests}">
        <tr>
            <td>${quests.questionName}<td>
            <td>${quests.userAnswer}<td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>