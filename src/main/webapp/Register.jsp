<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>User Registration</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<div class="container w-50">
<form action="./register" method="POST">
  <h1 class="text-center text-primary">Register</h1>
   <div class="mb-3">
	    <label for="exampleInputEmail1" class="form-label">Name: </label>
	    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="name">
    </div>    
    
    <div class="mb-3">
	    <label for="exampleInputEmail1" class="form-label">Email :</label>
	    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email">
    </div>
    
    <div class="form-floating">
  		<textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea" name="skills"></textarea>
  		<label for="floatingTextarea">Skills</label>
  	</div>
  	
  	<div class="mb-3">
	    <label for="exampleInputEmail1" class="form-label">Role :</label>
	    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="role">
    </div>
	
	
	  <div class="mb-3">
	    <label for="exampleInputEmail1" class="form-label">Password:</label>
	    <input type="password" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="pwd">
    </div>
	<button type="submit" class="btn btn-primary w-100">Register</button>
</form>
<p class="text-center mt-5">
    Already registered? 
    <a href="./Login.jsp">Login here</a>
</p>

${msg}
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>