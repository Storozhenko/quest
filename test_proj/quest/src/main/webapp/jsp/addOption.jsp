<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/" var="baseUrl" />
<html>
<head>
    <title><spring:message code="label.option.add"/></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${baseUrl}/css/style.css" rel="stylesheet" type="text/css" />
    <link href="${baseUrl}/css/gstyle_buttons.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2><spring:message code="label.option.add"/></h2>
<br>
<c:choose>
    <c:when test="${type >= 2}">
        <form:form method="post" commandName="option" action="addOptionAction">
            <table>
                <tr>
                    <td><spring:message code="label.option.num"/>:</td>
                    <td><form:input path="optionNum" readonly="true"/></td>
                </tr>
                <tr>
                    <td><spring:message code="label.option.data"/>:</td>
                    <td><form:input path="optionData"/></td>
                    <td><span class="error"><form:errors path="optionData" /></span></td>
                </tr>

                <tr>
                    <td colspan="2"></td>
                </tr>
                <tr>
                    <td colspan="2"><button class="action bluebtn" type="submit" id="addOptionSubmit"><span class="label">OK</span></button></td>
                </tr>
            </table>
        </form:form>
        <c:if test="${option.optionNum >= 3}">
            <table>
                <tr>
                    <td colspan="2">
                        <form action="addQuestion">
                            <button class="action redbtn" type="submit" id="addQuestionFinish"><span class="label"><spring:message code="label.finish"/></span></button>
                        </form>
                    </td>
                </tr>
            </table>
        </c:if>
    </c:when>
</c:choose>

</body>
</html>