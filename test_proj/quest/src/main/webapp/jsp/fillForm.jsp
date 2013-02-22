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
<table>
    <c:forEach var="quests" items="${quests}">
        <tr>
            <td>${quests.questionName}<td>
        </tr>
    </c:forEach>
</table>
<c:choose>
    <c:when test="${questType == 1}">
        <form:form method="post" commandName="answQuestion" action="addAnswerAction">
            <table>
                <tr>
                    <td><b>Question № ${answQuestion.questionNumber}:</b></td>
                    <td><b>${currentQuest.questionName}</b></td>
                    <td>${currentQuest.questionDescr}</td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Question:</td>
                    <td colspan="2">${questOptions}</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td colspan="6"><form:input path="questionAnswer" size="60"/></td>
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
                    <td><form:radiobuttons items="${questOptions}" path="questionAnswer" delimiter="<br/>"/></td>
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
                    <td><form:checkboxes items="${questOptions}" path="questionAnswer" delimiter="<br/>"/></td>
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