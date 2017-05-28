<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Add Book</h1>
			<p class="lead">Fill the information to add a book!</p>
		</div>
		<form:form
			action="${pageContext.request.contextPath}/admin/bookInventory/addBook"
			method="post" commandName="book" enctype="multipart/form-data">
			<div class="form-group">
				<label for="bookName">Book Name</label>
				<form:input path="bookName" id="name" class="form-control" />
			</div>
			<div class="form-group">
				<label for="bookAuthor">Author</label>
				<form:textarea path="bookAuthor" id="bookAuthor"
					class="form-control" />
			</div>
			<div class="form-group">
				<label for="bookPrice">Price</label>
				<form:input path="bookPrice" id="bookPrice" class="form-control" />
			</div>
			<div class="form-group">
				<label for="bookPlublisher">Publisher</label>
				<form:input path="bookPlublisher" id="bookPlublisher"
					class="form-control" />
			</div>
			<div class="form-group">
				<label for="unitInStock">Unit In Stock</label>
				<form:input path="unitInStock" id="unitInStock" class="form-control" />
			</div>
			<div class="form-group">
				<label for="bookCategory">Category</label> <label
					class="checkbox-inline"><form:radiobutton
						path="bookCategory" id="category" value="Novel" />Novel</label> <label
					class="checkbox-inline"><form:radiobutton
						path="bookCategory" id="category" value="Story" />Story</label> <label
					class="checkbox-inline"><form:radiobutton
						path="bookCategory" id="category" value="AutoBiography" />AutoBiography</label>

			</div>
			<div class="form-group">
				<label for="bookStatus">Book Status</label> <label
					class="checkbox-inline"><form:radiobutton path="bookStatus"
						id="bookStatus" value="In Stock" />In Stock</label> <label
					class="checkbox-inline"><form:radiobutton path="bookStatus"
						id="bookStatus" value="Out of stock" />Out of stock</label>
			</div>
			<div class="form-group">
				<label for="bookCondition">Book Condition</label> <label
					class="checkbox-inline"><form:radiobutton
						path="bookCondition" id="bookCondition" value="New" />New</label> <label
					class="checkbox-inline"><form:radiobutton
						path="bookCondition" id="bookCondition" value="Used" />Use</label>
			</div>
			<div class="form-group">
				<label class="control-label" for="bookImage">Upload Pictures</label>
				<form:input path="bookImage" id="bookImage" type="file"
					class="form:input-large" />
			</div>
			<input type="submit" value="submit" class="btn btn-primary">
			<a href="<c:url value='/admin/bookInventory'/>"
				class="btn btn-default">Cancel</a>
		</form:form>
		<%@ include file="/WEB-INF/views/template/footer.jsp"%>