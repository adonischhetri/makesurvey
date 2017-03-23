<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="signup">
	<section>
		<div class="jumbotron">
			<div class="pull-right" style="padding-right: 50px">
				<a href="?language=en_US">English</a>|<a href="?language=nl_NP">Nepali</a>
			</div>

		</div>
	</section>

	<section class="container">

		<form:form action="" modelAttribute="newUser" class="form-horizontal" role = "form" >
			<fieldset>
				<legend><spring:message code="User.Signup" text="User Signup" /></legend>
				<p style="display:none;"> Current Locale : ${pageContext.response.locale}</p>
				<%-- <form:errors path="*" cssClass="alert alert-danger" element="div" /> --%>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="productId">
					<spring:message code="Signup.user.firstName.label" text="First Name" /></label>
					<div class="col-lg-10">
						<form:input id="firstName" path="firstName" type="text" class="form:input-large" />
						<form:errors path="firstName" cssClass="text-danger" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="productId">
					<spring:message code="Signup.user.middleName.label" text="First Name" /></label>
					<div class="col-lg-10">
						<form:input id="middleName" path="middleName" type="text" class="form:input-large" />
						<form:errors path="middleName" cssClass="text-danger" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="productId">
					<spring:message code="Signup.user.lastName.label" text="First Name" /></label>
					<div class="col-lg-10">
						<form:input id="lastName" path="lastName" type="text" class="form:input-large" />
						<form:errors path="lastName" cssClass="text-danger" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="productId">
					<spring:message code="Signup.user.email.label" text="First Name" /></label>
					<div class="col-lg-10">
						<form:input id="email" path="email" type="text" class="form:input-large" />
						<form:errors path="email" cssClass="text-danger" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="productId">
					<spring:message code="Signup.user.userName.label" text="First Name" /></label>
					<div class="col-lg-10">
						<form:input id="userName" path="userName" type="text" class="form:input-large" />
						<form:errors path="userName" cssClass="text-danger" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="productId">
					<spring:message code="Signup.user.password.label" text="First Name" /></label>
					<div class="col-lg-10">
						<form:input id="password" path="password" type="password" class="form:input-large" />
						<form:errors path="password" cssClass="text-danger" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="confirmPassword">
					<spring:message code="Signup.user.confirmPassword.label"  text="First Name"/></label>
					<div class="col-lg-10">
						<form:input id="confirmPassword" path="confirmPassword" type="password" class="form:input-large" />
						<form:errors path="confirmPassword" cssClass="text-danger" />
					</div>
				</div>

				<%-- <div class="form-group">
					<label class="control-label col-lg-2" for="profileImage"> <spring:message
							code="Signup.user.profileImage.label" /></label>
					<div class="col-lg-10">
						<form:input id="profileImage" path="profileImage" type="file" class="form:input-large" />
					</div>
				</div> --%>
				
				<hr />
				
				<h3><spring:message code="Current.Address" text = "Enter current address" /></h3>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="productId">
					<spring:message code="Address.street.label" text="First Name" /></label>
					<div class="col-lg-10">
						<form:input id="address.street" path="address.street" type="text" class="form:input-large" />
						<form:errors path="address.street" cssClass="text-danger" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="productId">
					<spring:message code="Address.city.label" text="First Name" /></label>
					<div class="col-lg-10">
						<form:input id="address.city" path="address.city" type="text" class="form:input-large" />
						<form:errors path="address.city" cssClass="text-danger" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="productId">
					<spring:message code="Address.state.label"  text="First Name"/></label>
					<div class="col-lg-10">
						<form:input id="address.state" path="address.state" type="text" class="form:input-large" />
						<form:errors path="address.state" cssClass="text-danger" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="productId">
					<spring:message code="Address.zip.label" text="First Name" /></label>
					<div class="col-lg-10">
						<form:input id="address.zip" path="address.zip" type="text" class="form:input-large" />
						<form:errors path="address.zip" cssClass="text-danger" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value="Signup" />
					</div>
				</div>

			</fieldset>
		</form:form>
	</section>
</div>