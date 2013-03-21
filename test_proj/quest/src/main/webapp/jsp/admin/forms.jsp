<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://github.com/datatables4j" prefix="datatables"  %>
<spring:url value="/" var="baseUrl" />
<html>
<head>
    <title>Forms</title>
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
        $('#formsTable').dataTable({
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
            "sAjaxSource" : '/quest/admin/formsTable',
            "aoColumnDefs": [
                {   /*
                    "fnRender": function ( oObj,sVal ) {
                        return '<a href="fillForm?formId=' + sVal + '">fill</a>';
                    },
                    "bUseRendered": false,
                    "aTargets": [ 2 ] */
                    "bSearchable": true,
                    "bVisible": true,
                    "aTargets": [ 0 ]
                }
            ]
        });
    });
    $(document).ready(function() {
        $('#formsTable tbody').on( 'click', 'td', function () {
            var cells=$(this).parent('tr').children('td');
            $('#inputForm :input[id="formId"]').val($(cells[0]).text().trim());
            $('#inputForm :input[id="formName"]').val($(cells[1]).text().trim());
            $('#inputForm :input[id="formDescr"]').val($(cells[2]).text().trim());
        });
        $('#formsTable tbody').on( 'click', 'tr', function () {
            if ($(this).hasClass("row_selected")) {
                $(this).removeClass("row_selected");
                var inputForm = document.getElementById('inputForm');
                inputForm.style.display = "none";
            } else {
                if($(this).parent().find('tr').hasClass("row_selected")) {
                    $(this).parent().find('tr').removeClass("row_selected");
                    $(this).addClass("row_selected");
                    $(this).removeClass("mouse_over");
                    var inputForm = document.getElementById('inputForm');
                    inputForm.style.display = "block";
                } else {
                    $(this).addClass("row_selected");
                    $(this).removeClass("mouse_over");
                    var inputForm = document.getElementById('inputForm');
                    inputForm.style.display = "block";
                }
            }
        });
        $('#formsTable tbody').on( 'mouseover', 'tr', function () {
            if (!$(this).hasClass("row_selected")) {
                $(this).addClass("mouse_over");
            }
        });
        $('#formsTable tbody').on( 'mouseout', 'tr', function () {
            $(this).removeClass("mouse_over");
        });
    });
    function fillForm() {
        window.location = "fillForm?formId=" + document.getElementById("formId").value;
    }
    function deleteForm() {
        window.location = "deleteFormAction?formId=" + document.getElementById("formId").value;
    }
    function formQuestions() {
        window.location = "formQuestions?formId=" + document.getElementById("formId").value;
    }
</script>

<body>
<h2>Forms</h2>
<br>
<br>
<div>
    <form action="main">
        <button class="action bluebtn" type="submit" style="margin: 5px" id="formsToMainLink" /><span class="label">Main page</span></button>
    </form>
    <form action="addForm">
        <button class="action bluebtn" type="submit" style="margin: 5px" id="addFormLink" /><span class="label">Add form</span></button>
    </form>
</div>
<br>
<br>
<br>
<br>
<table id="formsTable" class="display">
    <thead>
    <tr>
        <th>Form ID</th>
        <th>Form name</th>
        <th>Description</th>
        <th>Username</th>
        <th>Create date</th>
    </tr>
    </thead>
    <tbody>
    </tbody>
</table>
<br>
<br>
<form:form method="post" id="inputForm" commandName="form" action="updateFormAction" style="display:none">
    <table>
        <tr>
            <td>Form ID:</td>
            <td><form:input path="formId" id="formId" readonly="true"/></td>
        </tr>
        <tr>
            <td>Form name:</td>
            <td><form:input path="formName" id="formName"/></td>
            <td><span class="error"><form:errors path="formName"/></span></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><form:input path="formDescr" id="formDescr"/></td>
        </tr>
        <tr>
            <td colspan="3"></td>
        </tr>
        <tr>
            <td><button class="action redbtn" style="width: 100px" type="button" id="deleteFormLink" onclick="deleteForm()" /><span class="label">Delete</span></td>
            <td><button class="action bluebtn" style="width: 100px" type="submit" id="updateFormSubmit" /><span class="label">Update</span></td>
        </tr>
        <tr>
            <td><button class="action bluebtn" style="width: 100px" type="button" id="formQuestionsLink" onclick="formQuestions()" /><span class="label">Questions</span></td>
            <td><button class="action bluebtn" style="width: 100px" type="button" id="fillFormLink" onclick="fillForm()" /><span class="label">Fill form</span></td>
        </tr>
    </table>
</form:form>
<br>
</body>
</html>