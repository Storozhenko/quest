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
        $('#answQuestTable').dataTable({
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
        <th>Question</th>
        <th>Description</th>
        <th>Answer</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="quests" items="${answQuests}">
        <tr>
            <td>${quests.questionName}<td>
            <td>${quests.questionDescr}<td>
            <td>${quests.userAnswer}<td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>