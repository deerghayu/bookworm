<%@ include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div id="login-box">
			<h2>Login with Username and Password</h2>
			<c:if test="${not empty message}">
				<div class="message">${message}</div>
			</c:if>
			<form name="loginForm"
				action="<c:url value='/j_spring_security_check'/>" method="POST">
				<c:if test="${not empty error}">
					<div class="error" style="color: ff0000;">${error}</div>
				</c:if>
				<div class="form-group">
					<label for="username">User:</label> <input type="text"
						id="username" name="username" class="form-control" />
					<div class="form-group">
						<label for="password">Password:</label> <input type="password"
							id="password" name="password" class="form-control" /> <br /> <input
							type="submit" value="Submit" class="btn btn-default"> <input
							type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/template/footer.jsp"%>