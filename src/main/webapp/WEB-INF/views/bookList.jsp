<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>
<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>All Books</h1>
			<p class="lead">Checkout all the awesome books available now!</p>
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
						<td><img src="<c:url value='/resources/images/${book.bookId}.png'/>" alt="image" style="width:100%"/></td>
						<td>${book.bookName}</td>
						<td>${book.bookCategory}</td>
						<td>${book.bookAuthor}</td>
						<td>${book.bookPrice}</td>
						<td>${book.bookPlublisher}</td>
						<td><a
							href="<spring:url value='/bookList/bookDetails/${book.bookId}'/>">
								<span class="glyphicon glyphicon-info-sign"></span>
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@ include file="/WEB-INF/views/template/footer.jsp"%>