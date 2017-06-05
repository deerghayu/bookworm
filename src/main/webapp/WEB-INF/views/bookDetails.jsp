<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Book Details</h1>
			<p class="lead">Here is the details about the book!</p>
		</div>
		<div class="container" ng-app="cartApp">
			<div class="row">
				<div class="col-md-5">
					<img src="<c:url value='/resources/images/${book.bookId}.png'/>"
						alt="image" style="width: 100%" />
				</div>
				<div class="col-md-5">
					<h3>${book.bookName}</h3>
					<p>
						<strong>Category</strong>: ${book.bookCategory}
					</p>
					<p>
						<strong>Author</strong>: ${book.bookAuthor}
					</p>
					<p>
						<strong>Publisher</strong>: ${book.bookPublisher}
					</p>
					<h4>${book.bookPrice}USD</h4>
					<br>
					<c:set var="role" scope="page" value="${param.role}" />
					<c:set var="url" scope="page" value="/bookList" />
					<c:if test="${role='admin' }">
						<c:set var="url" scope="page" value="/admin/bookInventory" />
					</c:if>
					<p ng-controller="cartController">
						<a href="<c:url value='${url}'/>" class="btn btn-default"><span
							class="glyphicon glyphicon-hand-left"></span> Back</a>
						<a href="#" class="btn btn-warning btn-large"
							ng-click="addToCart('${book.bookId}')"><span
							class="glyphicon glyphicon-shopping-cart"></span> Order Now</a> <a
							href="<c:url value='/cart' />" class="btn btn-default"><span
							class="glyphicon glyphicon-hand-right"></span> View Cart</a>
					</p>
				</div>
			</div>
		</div>
		<script src="<c:url value='/resources/js/controller.js'/>"></script>
		<%@ include file="/WEB-INF/views/template/footer.jsp"%>