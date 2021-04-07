
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p"%>
<%@include file="head.jsp"%>
<p:choose>

	<p:when test="${books.size() > 0}">
		<table>
			<thead>
				<tr>
					<td>ID</td>
					<td>NAME</td>
					<td>PRICE</td>
					<td>IMAGE</td>
				</tr>
			</thead>

			<p:forEach items="${books}" var="book">
				<tr>
					<td>${book.id}</td>
					<td>${book.name}</td>
					<td>${book.price}</td>
					<%-- <td><img src="<p:url value="/bookimages/${book.image}"/>" width="50" height="50"></td> --%>
					<td><img src="https://images.unsplash.com/photo-1490077476659-095159692ab5?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MXx8c2NlbmV8ZW58MHx8MHw%3D&ixlib=rb-1.2.1&w=1000&q=80" width="50" height="50"></td>
				</tr>
			</p:forEach>
		</table>
	</p:when>
	<p:otherwise>
		<h1>There Is No Books available</h1>
	</p:otherwise>
</p:choose>

