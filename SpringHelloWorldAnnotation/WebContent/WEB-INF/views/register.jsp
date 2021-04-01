<%@include file="head.jsp"%>
<div class="container">
	<form action="signup" method="post">
		<div class="form-group">
			<label for="name">Name:</label> <input type="text"
				class="form-control" placeholder="Enter name" name="name">
		</div>
		<div class="form-group">
			<label for="pwd">Password:</label> <input type="password"
				class="form-control" placeholder="Enter password" name="pass">
		</div>
		<div class="form-group">
			<label for="email">Email address:</label> <input type="email"
				class="form-control" placeholder="Enter email" name="email">
		</div>
		<div align="center"><button type="submit" class="btn btn-primary" style="width: 60%;">Submit</button></div>
	</form>
</div>