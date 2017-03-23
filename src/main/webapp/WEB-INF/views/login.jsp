
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<section class="mainContent clearfix logIn">
	<div class="container">
		<div class="row">
			<div
				class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 col-xs-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3>
							<spring:message code="language.login" text="Login" />
						</h3>
					</div>
					<div class="panel-body">
						<a href="<c:url value="/signup"/>"
							class="btn btn-link btn-block">
							<spring:message code="label.registrationForm.title"
								text="Registration Now" />
						</a>

						<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
							<div class="alert alert-danger" role="alert">
								<spring:message code="message.login.badCredentials"
									text="Bad credentils. Please try again."></spring:message>
							</div>
						</c:if>
						<form action="<c:url value='/login' />"
							method="POST" role="form">
							<div class="form-group">
								<input type="text" class="form-control" name="username"
									placeholder="Enter username">
							</div>
							<div class="form-group">
								<input type="password" class="form-control" name="password"
									placeholder="Enter Password">
							</div>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
							<button type="submit" class="btn btn-primary btn-block">
								<spring:message code="language.login" text="Login" />
							</button>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>