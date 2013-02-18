<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <title>Add Question</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2>Add Question</h2>
<br>
<c:choose>
    <c:when test="${iUserInfo.identification_card_type == 0}">
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
                        <select name='questionType'>
                            <c:forEach items="${types}" var="types">
                                <option value="${types}">${types}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Submit" /></td>
                </tr>
            </table>
        </form:form>
    </c:when>

    <c:when test="${iUserInfo.identification_card_type == 1}">
        <form:form method="post" commandName="option" action="addOptionAction">
            <table>
                <tr>
                    <td>Question name:</td>
                    <td><form:input path="questionName"/></td>
                    <td><span class="error"><form:errors path="questionName" /></span></td>
                </tr>
                <tr>
                    <td>Description:</td>
                    <td><form:input path="questionDescr"/></td>
                </tr>
                <tr>
                    <td>Question Type:</td>
                    <td>
                        <select name='questionType'>
                            <c:forEach items="${types}" var="types">
                                <option value="${types}">${types}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Submit" /></td>
                </tr>
            </table>
        </form:form>
    </c:when>
</c:choose>
</body>
</html>