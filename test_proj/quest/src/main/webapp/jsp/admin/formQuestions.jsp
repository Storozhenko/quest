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
        $('#questsTable').dataTable({
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
            "sAjaxSource" : '/quest/admin/formQuestsTable?formId=' + ${formId}
        });
    });
    $(document).ready(function() {
        $('#questsTable tbody').on( 'click', 'td', function () {
            var cells=$(this).parent('tr').children('td');
            $('#inputQuestion :input[id="questionId"]').val($(cells[0]).text().trim());
            $('#inputQuestion :input[id="questionName"]').val($(cells[1]).text().trim());
            $('#inputQuestion :input[id="questionDescr"]').val($(cells[2]).text().trim());
            $('#inputQuestion :input[id="questionOptions"]').val($(cells[4]).text().trim());
        });
        $('#questsTable tbody').on( 'click', 'tr', function () {
            if ($(this).hasClass("row_selected")) {
                $(this).removeClass("row_selected");
                var inputQuestion = document.getElementById('inputQuestion');
                inputQuestion.style.display = "none";
            } else {
                if($(this).parent().find('tr').hasClass("row_selected")) {
                    $(this).parent().find('tr').removeClass("row_selected");
                    $(this).addClass("row_selected");
                    $(this).removeClass("mouse_over");
                    var inputQuestion = document.getElementById('inputQuestion');
                    inputQuestion.style.display = "block";
                } else {
                    $(this).addClass("row_selected");
                    $(this).removeClass("mouse_over");
                    var inputQuestion = document.getElementById('inputQuestion');
                    inputQuestion.style.display = "block";
                }
            }
        });
        $('#questsTable tbody').on( 'mouseover', 'tr', function () {
            if (!$(this).hasClass("row_selected")) {
                $(this).addClass("mouse_over");
            }
        });
        $('#questsTable tbody').on( 'mouseout', 'tr', function () {
            $(this).removeClass("mouse_over");
        });
    });
    function deleteQuestion() {
        window.location = "deleteQuestionAction?questionId=" + document.getElementById("questionId").value;
    }
</script>

<body>
<h2>Forms</h2>
<br>
<br>
<div>
    <form action="main">
        <button class="action bluebtn" type="submit" id="formsToMainLink" /><span class="label">Main page</span></button>
    </form>
</div>
<br>
<br>
<br>
<br>
<table id="questsTable" class="display">
    <thead>
    <tr>
        <th>Question ID</th>
        <th>Question name</th>
        <th>Description</th>
        <th>Question type</th>
        <th>Number of options</th>
        <th>Options</th>
    </tr>
    </thead>
    <tbody>
    </tbody>
</table>
<br>
<br>
<form:form method="post" id="inputQuestion" commandName="question" action="updateQuestionAction" style="display:none">
    <table>
        <tr>
            <td>Question ID:</td>
            <td><form:input path="questionId" id="questionId" readonly="true"/></td>
        </tr>
        <tr>
            <td>Question name:</td>
            <td><form:input path="questionName" id="questionName"/></td>
            <td><span class="error"><form:errors path="questionName"/></span></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><form:input path="questionDescr" id="questionDescr"/></td>
        </tr>
        <tr>
            <td>Options:</td>
            <td><form:input path="questionOptions" id="questionOptions"/></td>
        </tr>
        <tr>
            <td colspan="3"></td>
        </tr>
        <tr>
            <td><button class="action redbtn" type="button" id="deleteFormLink" onclick="deleteQuestion()" /><span class="label">Delete</span></td>
            <td><button class="action bluebtn" type="submit" id="updateFormSubmit" /><span class="label">Update</span></td>
        </tr>
        <tr>
        </tr>
    </table>
</form:form>
<br>
</body>
</html>