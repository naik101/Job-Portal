<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Add Job</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
crossorigin="anonymous">

</head>

<body>

<div class="container w-50">

<form action="./addjob" method="POST">

<h1 class="text-center text-primary">Add Job</h1>

<div class="mb-3">
<label class="form-label">Job Title :</label>
<input type="text" class="form-control" name="title" required>
</div>

<div class="mb-3">
<label class="form-label">Company :</label>
<input type="text" class="form-control" name="company" required>
</div>

<div class="mb-3">
<label class="form-label">Location :</label>
<input type="text" class="form-control" name="location">
</div>

<div class="mb-3">
<label class="form-label">Salary :</label>
<input type="number" step="0.01" class="form-control" name="salary">
</div>

<button type="submit" class="btn btn-primary w-100">Add Job</button>

</form>

<p class="text-center mt-5">
<a href="./displayjob">Back to Jobs</a>
</p>

${msg}

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
crossorigin="anonymous"></script>

</body>
</html>