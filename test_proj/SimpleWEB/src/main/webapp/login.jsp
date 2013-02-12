<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Contracts</title>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    <link rel="stylesheet" type="text/css" href="style.css"/>
    <s:head/>
</head>
<body>
<h1>Contracts</h1>
<br/>
<hr size="2"/>
<fieldset>
    <legend><b>Please Login</b></legend>
    <s:form action="loginAction" method="post">
        <table>
            <tr>
                <td><s:textfield label="Username" size="30" name="username"/></td>
            </tr>
            <tr>
                <td><s:password label="Password" size="30" name="password"/></td>
            </tr>
            <tr>
                <td><s:combobox label="Language" value="default" headerValue="select" readonly="true" size="5" headerKey="-1" name="request_locale" list="#{'ru':'RU', 'by':'BY', 'en':'EN'}"/></td>
            </tr>
        </table>
        <br/>
        <s:submit value="  Login  " align="left"> </s:submit>
    </s:form>
</fieldset>
</body>
</html>