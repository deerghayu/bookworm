<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>
<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Adminstrator Page</h1>
			<p class="lead">This is the administrator page!</p>
		</div>
		<c:if test="${pageContext.request.userPrincipal.name !=null}">
			<h2>
				Welcome ${pageContext.request.userPrincipal.name}! <a
					href="<c:url value='/j_spring_security_logout'/>">Logout</a>
			</h2>
		</c:if>
		<h3>
			<a href="<c:url value='/admin/bookInventory'/>">Book Inventory</a>
		</h3>
		<p>Here you can view, add and modify the Book items!</p>
		<%@ include file="/WEB-INF/views/template/footer.jsp"%>