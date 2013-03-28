<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/" var="baseUrl" />
<html>
<head>
    <title><spring:message code="label.question.add"/></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${baseUrl}/css/style.css" rel="stylesheet" type="text/css" />
    <link href="${baseUrl}/css/gstyle_buttons.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2><spring:message code="label.question.add"/> №${questionNum}</h2>
<br>
<form:form method="post" commandName="question" action="addQuestionAction">
    <table>
        <tr>
            <td><spring:message code="label.question.name"/>:</td>
            <td><form:input path="questionName" size="50" maxlength="100"/></td>
            <td><span class="error"><form:errors path="questionName" /></span></td>
        </tr>
        <tr>
            <td><spring:message code="label.description"/>:</td>
            <td><form:input path="questionDescr" size="50" maxlength="100" /></td>
        </tr>
        <tr>
            <td><spring:message code="label.question.type"/>:</td>
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
            <td colspan="2"><button class="action bluebtn" type="submit" id="addQuestionSubmit"><span class="label">OK</span></button></td>
        </tr>
    </table>
</form:form>
<br>
<br>
<br>
<form action="forms">
    <button class="action redbtn" type="submit" id="addFormFinish"><span class="label"><spring:message code="label.finish"/></span></button>
</form>
</body>
</html>