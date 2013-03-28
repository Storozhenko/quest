<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<spring:url value="/" var="baseUrl" />
<html>
<head>
    <title><spring:message code="label.forms.filled.questions"/></title>
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
        $('#answQuestsTable').dataTable({
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
            "sAjaxSource" : '/quest/user/answQuestsTable?answId=' + ${answId}
        });
    });
    $(document).ready(function() {
        $('#answQuestsTable tbody').on( 'click', 'tr', function () {
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
        $('#answQuestsTable tbody').on( 'mouseover', 'tr', function () {
            if (!$(this).hasClass("row_selected")) {
                $(this).addClass("mouse_over");
            }
        });
        $('#answQuestsTable tbody').on( 'mouseout', 'tr', function () {
            $(this).removeClass("mouse_over");
        });
    });
</script>
<body>
<h2><spring:message code="label.forms.filled.questions"/></h2>
<br>
<br>
<form action="main">
    <button class="action bluebtn" type="submit" style="margin: 5px" name="toMainLink"><span class="label"><spring:message code="label.page.main"/></span></button>
</form>
<br>
<br>
<br>
<br>
<table id="answQuestsTable" class="display">
    <thead>
    <tr>
        <th><spring:message code="label.question"/></th>
        <th><spring:message code="label.description"/></th>
        <th><spring:message code="label.answer"/></th>
    </tr>
    </thead>
    <tbody>
    </tbody>
</table>
<br>
<br>
<br>
<table>
    <tr>
        <td><spring:message code="label.username"/>:</td>
        <td>${username}</td>
    </tr>
    <tr>
        <td><spring:message code="label.form"/>:</td>
        <td>${formName}</td>
    </tr>
</table>
</body>
</html>