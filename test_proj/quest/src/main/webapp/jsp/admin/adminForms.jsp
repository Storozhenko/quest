<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://github.com/datatables4j" prefix="datatables"  %>
<spring:url value="/" var="baseUrl" />
<html>
<head>
    <title>Forms</title>
    <link href="${baseUrl}/css/style.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.2/css/jquery.dataTables.css">
</head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="//ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.2/jquery.dataTables.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
    $('#example').dataTable();
    } );
</script>
<ui:repeat></ui:repeat>

<body>
<h2>Forms</h2>
<br>
<datatables:table id="formsTableId" data="${forms}">
    <datatables:column title="Name" property="formName" />
    <datatables:column title="Description" property="formDescr" />
</datatables:table>
<br>
<a href="addForm">Add form</a>
<a href="fillForm">Fill form</a>
</body>
</html>