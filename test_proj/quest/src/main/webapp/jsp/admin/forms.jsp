<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://github.com/datatables4j" prefix="datatables"  %>
<spring:url value="/" var="baseUrl" />
<html>
<head>
    <title>Forms</title>
    <link rel="stylesheet" type="text/css" href="${baseUrl}/css/style.css"/>
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
                {
                    "fnRender": function ( oObj,sVal ) {
                        return '<a href="fillForm?formId=' + sVal + '">fill</a>';
                    },
                    "bUseRendered": false,
                    "aTargets": [ 2 ]
                }
            ]
        });
    });
    $(document).ready(function() {
        $('#formsTable tbody').on( 'click', 'tr', function () {
            var cells=$(this).parent('tr').children('td');
            $('#inputForm :input[id="formName"]').val("fds");
            $('#inputForm :input[name="formDescr"]').val($(cells[1]).text().trim());
            if ($(this).hasClass("row_selected")) {
                $(this).removeClass("row_selected");
            } else {
                if($(this).parent().find('tr').hasClass("row_selected")) {
                    $(this).parent().find('tr').removeClass("row_selected");
                    $(this).addClass("row_selected");
                    $(this).removeClass("mouse_over");
                } else {
                    $(this).addClass("row_selected");
                    $(this).removeClass("mouse_over");
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
</script>

<body>
<h2>Forms</h2>
<br>
<div id="container">
    <table id="formsTable" class="display">
        <thead>
        <tr>
            <th>Form name</th>
            <th>Description</th>
            <th>Fill</th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
 </div>
<br>
<form id="inputForm" method="post">
    <table>
        <tr>
            <td>Form name:</td>
            <td><input id="formName"/></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><input id="formDescr"/></td>
        </tr>
        <tr>
            <td colspan="2"></td>
        </tr>
        <tr>
            <td colspan="2"><button class="action bluebtn" type="submit" id="addFormSubmit" /><span class="label">OK</span></td>
        </tr>
    </table>
</form>
<br>
<a href="addForm">Add form</a>
<br>
<a href=main>Main page</a>
</body>
</html>