<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <title>Fill form</title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2>Fill form</h2>
<c:choose>
    <c:when test="${questType == 1}">
        <form:form method="post" commandName="answQuestion" action="addAnswerAction">
            <table>
                <tr>
                    <td><b>Question № ${questNum}:</b></td>
                    <td colspan="5"><b>${currentQuest.questionName}</b></td>
                </tr>
                <tr>
                    <td>Description:</td>
                    <td colspan="5">${currentQuest.questionDescr}</td>
                </tr>
                <tr>
                    <td colspan="6"><form:input path="questionAnswer" size="60"/></td>
                    <td><span class="error"><form:errors path="questionAnswer" /></span></td>
                </tr>
                <tr>
                    <td colspan="6"><input type="submit" value="Submit" /></td>
                </tr>
            </table>
        </form:form>
    </c:when>
    <c:when test="${questType == 2}">
        <form:form method="post" commandName="answQuestion" action="addAnswerAction">
            <table>
                <tr>
                    <td><b>Question № ${questNum}:</b></td>
                    <td colspan="5"><b>${currentQuest.questionName}</b></td>

                </tr>
                <tr>
                    <td>Description:</td>
                    <td colspan="5">${currentQuest.questionDescr}</td>
                </tr>
                <tr>
                    <td><form:radiobuttons items="${questOptions}" path="questionAnswer" delimiter="<br/>"/></td>
                    <td><span class="error"><form:errors path="questionAnswer" /></span></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit" /></td>
                </tr>
            </table>
        </form:form>
    </c:when>
    <c:when test="${questType == 3}">
        <form:form method="post" commandName="answQuestion" action="addAnswerAction">
            <table>
                <tr>
                    <td><b>Question № ${questNum}:</b></td>
                    <td colspan="5"><b>${currentQuest.questionName}</b></td>

                </tr>
                <tr>
                    <td>Description:</td>
                    <td colspan="5">${currentQuest.questionDescr}</td>
                </tr>
                <tr>
                    <td><form:checkboxes items="${questOptions}" path="questionAnswer" delimiter="<br/>"/></td>
                    <td><span class="error"><form:errors path="questionAnswer" /></span></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit" /></td>
                </tr>
            </table>
        </form:form>
    </c:when>
</c:choose>

</body>
</html>