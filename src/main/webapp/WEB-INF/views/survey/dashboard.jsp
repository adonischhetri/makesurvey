<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

Dashboard
<security:authorize access="isAuthenticated()">
  					Welcome  <security:authentication property="principal.username" />, &nbsp; 
  					<c:url var="logoutUrl" value="/j_spring_security_logout" />
	<form:form action="${logoutUrl}" method="post">
		<input type="submit" value="Log out" />
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form:form>

</security:authorize>