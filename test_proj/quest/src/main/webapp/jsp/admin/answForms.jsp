<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://github.com/datatables4j" prefix="datatables"  %>
<spring:url value="/" var="baseUrl" />
<html>
<head>
    <title>Filled Forms</title>
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
            "sAjaxSource" : '/quest/admin/formsTable.json',
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
</script>
<body>
<h2>Filled Forms</h2>
<br>
<table border="1">
    <thead>
    <tr>
        <th>Form</th>
        <th>Username</th>
        <th>Date and time</th>
        <th>Look</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="forms" items="${answForms}">
        <tr>
            <td>${forms.formName}<td>
            <td>${forms.username}<td>
            <td>${forms.answDatetime}<td>
            <td><a href="answFormsQuestions?answId=${forms.answId}">Look</a><td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>