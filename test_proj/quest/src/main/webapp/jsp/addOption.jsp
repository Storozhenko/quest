<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/" var="baseUrl" />
<html>
<head>
    <title>Add Option</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${baseUrl}/css/style.css" rel="stylesheet" type="text/css" />
    <link href="${baseUrl}/css/gstyle_buttons.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2>Add Option</h2>
<br>
<c:choose>
    <c:when test="${type == 1}">
        <form:form method="post" commandName="option" action="addOptionAction">
            <table>
                <tr>
                    <td>Option number:</td>
                    <td><form:input path="optionNum" readonly="true"/></td>
                </tr>
                <tr>
                    <td>Question data:</td>
                    <td><form:input path="optionData"/></td>
                    <td><span class="error"><form:errors path="optionData" /></span></td>
                </tr>
                <tr>
                    <td colspan="2"></td>
                </tr>
                <tr>
                    <td colspan="2"><button class="action bluebtn" type="submit" id="addTextQuestionFinish" /><span class="label">Finish</span></td>
                </tr>
            </table>
        </form:form>
    </c:when>
    <c:when test="${type >= 2}">
        <form:form method="post" commandName="option" action="addOptionAction">
            <table>
                <tr>
                    <td>Option number:</td>
                    <td><form:input path="optionNum" readonly="true"/></td>
                </tr>
                <tr>
                    <td>Option data:</td>
                    <td><form:input path="optionData"/></td>
                    <td><span class="error"><form:errors path="optionData" /></span></td>
                </tr>

                <tr>
                    <td colspan="2"></td>
                </tr>
                <tr>
                    <td colspan="2"><button class="action bluebtn" type="submit" id="addOptionSubmit" /><span class="label">OK</span></td>
                </tr>
            </table>
        </form:form>
        <c:if test="${option.optionNum >= 3}">
            <table>
                <tr>
                    <td colspan="2">
                        <form action="addQuestion">
                            <button class="action redbtn" type="submit" id="addQuestionFinish" /><span class="label">Finish</span>
                        </form>
                    </td>
                </tr>
            </table>
        </c:if>
    </c:when>
</c:choose>

</body>
</html>