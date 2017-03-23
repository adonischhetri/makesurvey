<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<li><a href="<spring:url value="/"/>">Home</a></li>
<security:authorize access="isAnonymous()">
	<li><a href="<spring:url value="/login"/>">Signup/login</a></li>
</security:authorize>
<li><a href="<spring:url value="/about"/>">About Company</a></li>
<li><a href="<spring:url value="/contact"/>">Contact Us</a></li>
