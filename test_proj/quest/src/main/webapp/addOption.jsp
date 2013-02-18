<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <title>Add Option</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2>Add Option</h2>
<br>
<form:form method="post" commandName="option" action="addOptionAction">
    <table>
        <tr>
            <td>Option number:</td>
            <td><form:input path="optionNum" readonly="true"/></td>
        </tr>
        </tr>
        <td>Option data:</td>
        <td><form:input path="optionData"/></td>
        <td><span class="error"><form:errors path="optionData" /></span></td>
        </tr>

        <tr>
            <td colspan="2"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Submit" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>