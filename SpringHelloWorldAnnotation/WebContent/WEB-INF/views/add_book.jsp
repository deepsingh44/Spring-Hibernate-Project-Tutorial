<%@include file="head.jsp"%>
<div class="container">
	<h1>Add Book</h1>
	<form action="book/add" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<label for="name">Book Name:</label> <input type="text"
				class="form-control" placeholder="Enter name" name="name">
		</div>
		<div class="form-group">
			<label for="price">Book Price:</label> <input type="number"
				class="form-control" placeholder="Enter price" name="price">
		</div>
		<div class="form-group">
			<label for="author">Author Name:</label> <input type="text"
				class="form-control" placeholder="Enter Author Name" name="author">
		</div>
		<div class="form-group">
			<label for="category">Select Category:</label> <select class="form-control"
				id="category">
				<option>Select Category</option>
				<option>Education</option>
				<option>Magazine</option>
				<option>Comics</option>
				<option>Others</option>
			</select>
		</div>
		<div class="form-group">
		<input type="file" class="form-control-file border" name="imagefile">
		</div>

		<div align="center">
			<button type="submit" class="btn btn-primary" style="width: 60%;">Update
				Here</button>
		</div>
	</form>

</div>