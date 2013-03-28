<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://github.com/datatables4j" prefix="datatables"  %>
<spring:url value="/" var="baseUrl" />
<html>
<head>
    <title><spring:message code="label.users"/></title>
    <link href="${baseUrl}/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="${baseUrl}/css/gstyle_buttons.css" rel="stylesheet" type="text/css" />
</head>
<style type="text/css" title="currentStyle">
    @import "${baseUrl}/media/css/demo_page.css";
    @import "${baseUrl}/media/css/demo_table.css";
    @import "${baseUrl}/media/css/jquery.dataTables.css";
</style>
<script type="text/javascript" language="javascript" src="${baseUrl}/media/js/jquery.js"></script>
<script type="text/javascript" language="javascript" src="${baseUrl}/media/js/jquery.dataTables.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $('#usersTable').dataTable({
            "oLanguage": {
                "sLengthMenu": "<spring:message code="datatables.sLengthMenu"/>",
                "sZeroRecords": "<spring:message code="datatables.sZeroRecords"/>",
                "sInfo": "<spring:message code="datatables.sInfo"/>",
                "sInfoEmpty": "<spring:message code="datatables.sInfoEmpty"/>",
                "sInfoFiltered": "<spring:message code="datatables.sInfoFiltered"/>",
                "sSearch": "<spring:message code="datatables.sSearch"/>",
                "sProcessing": "<spring:message code="datatables.sProcessing"/>",
                "oPaginate": {
                    "sPrevious": "<spring:message code="datatables.sPrevious"/>",
                    "sNext": "<spring:message code="datatables.sNext"/>"
                }
            },
            "bProcessing": true,
            "sAjaxSource" : '/quest/admin/usersTable'
        });
    });
    $(document).ready(function() {
        $('#usersTable tbody').on( 'click', 'td', function () {
            var cells=$(this).parent('tr').children('td');
            $('#inputUser :input[id="userId"]').val($(cells[0]).text().trim());
            $('#inputUser :input[id="username"]').val($(cells[1]).text().trim());
            $('#inputUser :input[id="password"]').val($(cells[2]).text().trim());
            var type = document.getElementById('userType');
            for(var i = 0, j = type.options.length; i < j; ++i) {
                if(type.options[i].innerHTML === $(cells[3]).text().trim()) {
                    type.selectedIndex = i;
                    break;
                }
            }
            var lang = document.getElementById('userLang');
            for(var i = 0, j = lang.options.length; i < j; ++i) {
                if(lang.options[i].innerHTML === $(cells[4]).text().trim()) {
                    lang.selectedIndex = i;
                    break;
                }
            }

        });
        $('#usersTable tbody').on( 'click', 'tr', function () {
            if ($(this).hasClass("row_selected")) {
                $(this).removeClass("row_selected");
                var inputForm = document.getElementById('inputUser');
                inputForm.style.display = "none";
            } else {
                if($(this).parent().find('tr').hasClass("row_selected")) {
                    $(this).parent().find('tr').removeClass("row_selected");
                    $(this).addClass("row_selected");
                    $(this).removeClass("mouse_over");
                    var inputForm = document.getElementById('inputUser');
                    inputForm.style.display = "block";
                } else {
                    $(this).addClass("row_selected");
                    $(this).removeClass("mouse_over");
                    var inputForm = document.getElementById('inputUser');
                    inputForm.style.display = "block";
                }
            }
        });
        $('#usersTable tbody').on( 'mouseover', 'tr', function () {
            if (!$(this).hasClass("row_selected")) {
                $(this).addClass("mouse_over");
            }
        });
        $('#usersTable tbody').on( 'mouseout', 'tr', function () {
            $(this).removeClass("mouse_over");
        });
    });
    function deleteUser() {
        window.location = "deleteUserAction?userId=" + document.getElementById("userId").value;
    }
</script>

<body>
<h2><spring:message code="label.users"/></h2>
<br>
<br>
<div>
    <form action="main">
        <button class="action bluebtn" type="submit" style="margin: 5px" id="usersToMainLink"><span class="label"><spring:message code="label.page.main"/></span></button>
    </form>
    <form action="addUser">
        <button class="action bluebtn" type="submit" style="margin: 5px" id="addUserLink"><span class="label"><spring:message code="label.user.add"/></span></button>
    </form>
</div>
<br>
<br>
<br>
<br>
<table id="usersTable" class="display">
    <thead>
    <tr>
        <th>ID</th>
        <th><spring:message code="label.username"/></th>
        <th><spring:message code="label.password"/></th>
        <th><spring:message code="label.user.type"/></th>
        <th><spring:message code="label.language"/></th>
    </tr>
    </thead>
    <tbody>
    </tbody>
</table>
<br>
<br>
<form:form method="post" id="inputUser" commandName="user" action="updateUserAction" style="display:none">
    <table>
        <tr>
            <td>ID:</td>
            <td><form:input path="userId" id="userId" readonly="true" size="40" maxlength="40"/></td>
        </tr>
        <tr>
            <td><spring:message code="label.username"/>:</td>
            <td><form:input path="username" id="username" size="40" maxlength="40"/></td>
            <td><span class="error"><form:errors path="username"/></span></td>
        </tr>
        <tr>
            <td><spring:message code="label.password"/>:</td>
            <td><form:input path="password" id="password" size="40" maxlength="40"/></td>
            <td><span class="error"><form:errors path="password"/></span></td>
        </tr>
        <tr>
            <td><spring:message code="label.user.type"/>:</td>
            <td><form:select path="userType" id="userType">
                <option value="ROLE_ADMIN"><spring:message code="label.ROLE_ADMIN"/></option>
                <option value="ROLE_USER"><spring:message code="label.ROLE_USER"/></option>
            </form:select>
            </td>
        </tr>
        <tr>
            <td><spring:message code="label.language"/>:</td>
            <td><form:select path="userLang" id="userLang">
                <option value=""><spring:message code="label.language"/></option>
                <option value="en"><spring:message code="label.language.en"/></option>
                <option value="ru"><spring:message code="label.language.ru"/></option>
            </form:select>
            </td>
        </tr>
        <tr>
            <td colspan="3"></td>
        </tr>
        <tr>
            <td><button class="action redbtn" style="width: 100px" type="button" id="deleteUserLink" onclick="deleteUser()" /><span class="label"><spring:message code="label.delete"/></span></td>
            <td><button class="action bluebtn" style="width: 100px" type="submit" id="updateUserSubmit" /><span class="label"><spring:message code="label.update"/></span></td>
        </tr>

    </table>
</form:form>
<br>
</body>
</html>