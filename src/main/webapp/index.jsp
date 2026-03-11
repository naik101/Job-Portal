<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
<title>JobConnect</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>


</head>
<body>
<div class="container">
  
   <nav class="navbar navbar-dark bg-dark fixed-top">
  <div class="container-fluid">
    <a class="navbar-brand ms-4" href="#">JobConnect</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasDarkNavbar" aria-controls="offcanvasDarkNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="offcanvas offcanvas-end text-bg-dark" tabindex="-1" id="offcanvasDarkNavbar" aria-labelledby="offcanvasDarkNavbarLabel">
      <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasDarkNavbarLabel">Navigation</h5>
        <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      </div>
      <div class="offcanvas-body">
        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="./displayjob">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="./Login.jsp">Login/Register</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Menu
            </a>
            <ul class="dropdown-menu dropdown-menu-dark">
             
              <li>
					<C:if test="${sessionScope.role == 'admin'}">
					
					    <li><a class="dropdown-item" href="./Addjob.jsp">Add Jobs</a></li>
					    <li><a class="dropdown-item" href="viewapplications">View Applications</a></li>
				
					</C:if>  	  
            </ul>
          </li>
        </ul>
      
      </div>
    </div>
  </div>
</nav>

<div class="d-flex justify-content-center " style="margin-top:100px;">

	<form class="d-flex mb-2 w-75" role="search" method="get" action="./displayjob">
	
		<input class="form-control me-2" 
		type="search" 
		placeholder="Enter The Job Title" 
		aria-label="Search" 
		name="jtitle"/>
		
		<button class="btn btn-outline-success" type="submit" name="sbtn" value="Search">Search</button>
		
		<button class="btn btn-outline-success ms-1" type="submit" name="sbtn" value="Refresh">Refresh</button>
		
	</form>

</div>

<div class="container mt-5">

	<div class="row">
	
		<C:forEach var="J" items="${jobs}">
		
			<div class="col-md-4 mb-4">
			
				<div class="card shadow">
				
					<div class="card-body">
					
						<h5 class="card-title">${J.title}</h5>
						
						<p class="card-text">
						Company : ${J.company}
						</p>
						
						<p class="card-text">
						Location : ${J.location}
						</p>
						
						<p class="card-text">
						  Salary : ${J.salary}
						</p>
						
						<form action="./apply" method="post">
                             <button class="btn btn-primary" type="submit" name="job_id" value="${J.job_id}" >Apply</button>
                        </form>
					
					</div>
				
				</div>
			
			</div>
		
		</C:forEach>
		
	
	</div>

</div>

<%
String msg = request.getParameter("msg");
if(msg != null){
%>

<script>

if("<%=msg%>" === "success"){
	Swal.fire({
		  title: "Applied Successfully!",
		  icon: "success",
		  draggable: true
		});
}

if("<%=msg%>" === "fail"){
	Swal.fire({
		  icon: "error",
		  title: "Oops...",
		  text: "Something went wrong!",
		  
		});
}

</script>

<%
}
%>



   
   
   
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>