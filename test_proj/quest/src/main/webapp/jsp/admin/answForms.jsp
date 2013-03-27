<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<spring:url value="/" var="baseUrl" />
<html>
<head>
    <title>Filled Forms</title>
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
        $('#answFormsTable').dataTable({
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
            "sAjaxSource" : '/quest/admin/answFormsTable'
        });
    });
    $(document).ready(function() {
        $('#answFormsTable tbody').on( 'click', 'td', function () {
            var cells=$(this).parent('tr').children('td');
            $('#answForm :input[id="answId"]').val($(cells[0]).text().trim());
            $('#answForm :input[id="username"]').val($(cells[2]).text().trim());
            $('#answForm :input[id="formName"]').val($(cells[1]).text().trim());
        });
        $('#answFormsTable tbody').on( 'click', 'tr', function () {
            if ($(this).hasClass("row_selected")) {
                $(this).removeClass("row_selected");
                var inputForm = document.getElementById('answForm');
                inputForm.style.display = "none";
            } else {
                if($(this).parent().find('tr').hasClass("row_selected")) {
                    $(this).parent().find('tr').removeClass("row_selected");
                    $(this).addClass("row_selected");
                    $(this).removeClass("mouse_over");
                    var inputForm = document.getElementById('answForm');
                    inputForm.style.display = "block";
                } else {
                    $(this).addClass("row_selected");
                    $(this).removeClass("mouse_over");
                    var inputForm = document.getElementById('answForm');
                    inputForm.style.display = "block";
                }
            }
        });
        $('#answFormsTable tbody').on( 'mouseover', 'tr', function () {
            if (!$(this).hasClass("row_selected")) {
                $(this).addClass("mouse_over");
            }
        });
        $('#answFormsTable tbody').on( 'mouseout', 'tr', function () {
            $(this).removeClass("mouse_over");
        });
    });
    function deleteAnswForm() {
        window.location = "deleteAnswForm?answId=" + document.getElementById("answId").value;
    }
    function answFormQuestions() {
        window.location = "answFormQuestions?answId=" + document.getElementById("answId").value + "&fName=" +
                document.getElementById("formName").value + "&uname=" + document.getElementById("username").value;
    }
</script>
<body>
<h2>Filled Forms</h2>
<br>
<br>
<form action="main">
    <button class="action bluebtn" type="submit" style="margin: 5px" name="toMainLink"><span class="label">Main page</span></button>
</form>
<br>
<br>
<br>
<br>
<table id="answFormsTable" class="display">
    <thead>
    <tr>
        <th>ID</th>
        <th>Form</th>
        <th>Username</th>
        <th>Date and time</th>
    </tr>
    </thead>
    <tbody>
    </tbody>
</table>
<br>
<br>
<form id="answForm" style="display:none">
    <table>
        <tr>
            <td><button class="action redbtn" style="width: 100px" type="button" id="deleteAnswFormLink" onclick="deleteAnswForm()" /><span class="label">Delete</span></td>
            <td><button class="action bluebtn" style="width: 100px" type="button" id="answFormQuestionsLink" onclick="answFormQuestions()" /><span class="label">Look</span></td>
        </tr>
        <tr>
            <td><input id="answId" readonly="true" style="display:none"/></td>
        </tr>
        <tr>
            <td><input id="username" readonly="true" style="display:none"/></td>
        </tr>
        <tr>
            <td><input id="formName" readonly="true" style="display:none"/></td>
        </tr>
    </table>
</form>
</body>
</html>