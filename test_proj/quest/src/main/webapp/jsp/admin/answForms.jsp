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
        <th>Form</th>
        <th>Username</th>
        <th>Date and time</th>
        <th>Look</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="forms" items="${answForms}">
        <tr>
            <td>${forms.formName}<td>
            <td>${forms.username}<td>
            <td>${forms.answDatetime}<td>
            <td><a href="answFormsQuestions?answId=${forms.answId}">Look</a><td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>