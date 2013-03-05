<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://github.com/datatables4j" prefix="datatables"  %>
<spring:url value="/" var="baseUrl" />
<html>
<head>
    <title>Forms</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<style type="text/css" title="currentStyle">
    @import "${pageContext.request.contextPath}/media/css/demo_page.css";
    @import "${pageContext.request.contextPath}/media/css/demo_table.css";
    @import "${pageContext.request.contextPath}/media/css/jquery.dataTables.css";
</style>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/media/js/jquery.js"></script>
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/media/js/jquery.dataTables.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $('#formsTable').dataTable({
            "bProcessing": true,
            "bJQueryUI": true,
            "bPaginate"  : true,
            "bSort"  : true,
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
<h2>Forms</h2>
<br>
<datatables:table id="formsTableId" data="${forms}">
    <datatables:column title="Name" property="formName" />
    <datatables:column title="Description" property="formDescr" />
</datatables:table>
<br>
<br>
<table cellpadding="0" cellspacing="0" border="0" id="formsTable">
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
<br>
<a href="addForm">Add form</a>

</body>
</html>