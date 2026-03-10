<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<title>Applications</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>

<div class="container mt-5">

<h2 class="text-center mb-4">Job Applications</h2>

<table class="table table-bordered table-striped">

<thead class="table-dark">

<tr>
<th>Application ID</th>
<th>User Name</th>
<th>Email</th>
<th>Skills</th>
<th>Job Title</th>
<th>Company</th>
</tr>

</thead>

<tbody>

<c:forEach var="app" items="${applications}">

<tr>
<td>${app.applicationId}</td>
<td>${app.name}</td>
<td>${app.email}</td>
<td>${app.skills}</td>
<td>${app.title}</td>
<td>${app.company}</td>
</tr>

</c:forEach>

</tbody>

</table>

</div>

</body>
</html>