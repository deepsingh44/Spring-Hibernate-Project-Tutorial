<%@include file="head.jsp"%>
<div class="container">
	<h1>Welcome ${sessionScope.user.name}</h1>
	<form action="update" method="post">
		<div class="form-group">
			<label for="name">Name:</label> <input type="text" value="${sessionScope.user.name}"
				class="form-control" placeholder="Enter name" name="name">
		</div>
		<div class="form-group">
			<label for="email">Email address:</label> <input type="email" value="${sessionScope.user.email}"
				class="form-control" placeholder="Enter email" name="email">
		</div>
		<div class="form-group">
			<label for="pwd">Password:</label> <input type="password"
				class="form-control" placeholder="Enter password" name="pass" value="${sessionScope.user.pass}">
		</div>
		
		<div align="center"><button type="submit" class="btn btn-primary" style="width: 60%;">Update Here</button></div>
	</form>
	
</div>