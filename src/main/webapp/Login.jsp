<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<div class=" container w-50 mt-5">

<form method="POST" action="./login"> 
   <h1 class="text-center text-primary">Login page</h1>
   <div class="mb-3">
	    <label for="exampleInputEmail1" class="form-label">Email:</label>
	    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email">
    </div>
     <div class="mb-3">
	    <label for="pwd" class="form-label">Password:</label>
	    <input type="text" class="form-control" id="pwd" aria-describedby="emailHelp" name="pwd">
    </div>
    <button type="submit" class="btn btn-primary w-100">Login</button>
    ${msg}
    <p class="text-center mt-5">
        Not Registered ? 
    <a href="./Register.jsp">Register here</a>
</p>
</form>









</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>