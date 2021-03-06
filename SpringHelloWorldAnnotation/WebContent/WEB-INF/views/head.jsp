<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<title>ABC Project</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>

<nav class="navbar navbar-expand-md bg-dark navbar-dark">
	<!-- Brand -->
	<a class="navbar-brand" href="#">MyApp</a>

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>

	<!-- Navbar links -->
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav">
			
			<c:choose>
			
			<c:when test="${sessionScope.user !=null}">
			<li class="nav-item"><a class="nav-link" href="addBook">Add Book</a></li>
			<li class="nav-item"><a class="nav-link" href="list" >Book List</a></li>
			<li class="nav-item"><a class="nav-link" href="orders">Orders</a></li>
			<li class="nav-item"><a class="nav-link" href="cart">Cart Item</a></li>
			<li class="nav-item"><a class="nav-link" href="profile">Profile</a></li>
			<li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
			</c:when>
			
			<c:otherwise>
			<li class="nav-item"><a class="nav-link" href="register">Register</a></li>
			<li class="nav-item"><a class="nav-link" href="login">Login</a></li>
			</c:otherwise>
			
			</c:choose>
			
		</ul>
	</div>
</nav>