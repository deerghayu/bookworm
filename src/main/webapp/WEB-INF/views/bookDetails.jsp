<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Book Details</h1>
			<p class="lead">Here is the details information about the book!</p>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-md-5">
					<img src="#" alt="image" style="width: 100%; height: 300px" />
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
						<strong>Publisher</strong>: ${book.bookPlublisher}
					</p>
					<h4>${book.bookPrice} USD</h4>

				</div>
			</div>
		</div>

		<%@ include file="/WEB-INF/views/template/footer.jsp"%>