<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/" var="baseUrl" />
<html>
<head>
    <title>Add Question</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${baseUrl}/css/style.css" rel="stylesheet" type="text/css" />
    <link href="${baseUrl}/css/gstyle_buttons.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2>Add Question №${questionNum}</h2>
<br>
<form:form method="post" commandName="question" action="addQuestionAction">
    <table>
        <tr>
            <td>Question name:</td>
            <td><form:input path="questionName" size="40"/></td>
            <td><span class="error"><form:errors path="questionName" /></span></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><form:input path="questionDescr" size="40" /></td>
        </tr>
        <tr>
            <td>Question Type:</td>
            <td>
                <form:select path="questionType">
                    <c:forEach items="${types}" var="types">
                        <option value="${types}"><spring:message code="${types}"/></option>
                    </c:forEach>
                </form:select>
            </td>
        </tr>
        <tr>
            <td colspan="2"></td>
        </tr>
        <tr>
            <td colspan="2"><button class="action bluebtn" type="submit" id="addQuestionSubmit" /><span class="label">OK</span></td>
        </tr>
    </table>
</form:form>
<br>
<a href="forms">Finish</a>
</body>
</html>