<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>MyQuestions</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="style.css"/>
    <head/>
</head>
<body>
<h1>MyQuestions</h1>
<br/>
<hr size="2"/>
<fieldset>
    <legend><b>Please Login</b></legend>
    <form:form action="login" method="post">
        <table>
            <tr>
                <td><textfield label="Username" size="30" name="username"/></td>
            </tr>
            <tr>
                <td><password label="Password" size="30" name="password"/></td>
            </tr>
        </table>
        <br/>
        <submit value="  Login  " align="left"> <submit>
    </form:form>
</fieldset>
</body>
</html>