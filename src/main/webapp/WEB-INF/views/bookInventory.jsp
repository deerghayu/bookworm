<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>
<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Book Inventory Page</h1>
			<p class="lead">This is the Book Inventory Page!</p>
		</div>
		<table class="table table-striped table-hover">
			<thead>
				<tr class="bg-success">
					<th>Photo Thumb</th>
					<th>Name</th>
					<th>Category</th>
					<th>Author</th>
					<th>Price</th>
					<th>Publisher</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${books}" var="book">
					<tr>
						<td><img src="#" alt="image" /></td>
						<td>${book.bookName}</td>
						<td>${book.bookCategory}</td>
						<td>${book.bookAuthor}</td>
						<td>${book.bookPrice}</td>
						<td>${book.bookPlublisher}</td>
						<td><a href="<spring:url value='/bookList/bookDetails/${book.bookId}'/>">
								<span class="glyphicon glyphicon-info-sign"></span>
						</a> <a href="<spring:url value='/admin/bookInventory/deleteBook/${book.bookId}'/>">
								<span class="glyphicon glyphicon-trash"></span>
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="<spring:url value='/admin/bookInventory/addBook'/>"
			class="btn btn-primary">Add Book</a>
		<%@ include file="/WEB-INF/views/template/footer.jsp"%>