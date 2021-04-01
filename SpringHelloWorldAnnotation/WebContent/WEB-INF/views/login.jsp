<%@include file="head.jsp"%>
<div class="container">
	<form action="signin" method="post">
		<div class="form-group">
			<label for="email">Email address:</label> <input type="email"
				class="form-control" placeholder="Enter email" name="email">
		</div>
		<div class="form-group">
			<label for="pwd">Password:</label> <input type="password"
				class="form-control" placeholder="Enter password" name="pass">
		</div>
		
		<div align="center"><button type="submit" class="btn btn-primary" style="width: 60%;">Login Here</button></div>
	</form>
</div>