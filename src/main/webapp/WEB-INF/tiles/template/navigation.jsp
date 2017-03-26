<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<li><a href="<spring:url value="/"/>">Home</a></li>

<security:authorize access="isAnonymous()">
	<li><a href="<spring:url value="/login"/>">Signup/login</a></li>
</security:authorize>

<li><a href="<spring:url value="/about"/>">About Company</a></li>
<li><a href="<spring:url value="/contact"/>">Contact Us</a></li>


<div class="welcome">
	<security:authorize access="isAuthenticated()">
	  	<c:url var="logoutUrl" value="/j_spring_security_logout" />
		<form:form action="${logoutUrl}" method="post">
			<input type="submit" value="Log out" />
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form:form>
	</security:authorize>
</div>