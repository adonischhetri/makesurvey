<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<security:authorize access="isAuthenticated()">
	Welcome  <security:authentication property="principal.username" />, &nbsp;&nbsp;&nbsp;

	
	<a href="<c:url value="/survey/create" />"> Create Survey</a> &nbsp;&nbsp;&nbsp; 
	<a href="<c:url value="/taker/add" />"> Add User</a> &nbsp;&nbsp;&nbsp; 
	
	<hr />
	<h3>Users List (Survey Takers)</h3>
	<hr />
	
	<div style="margin-top: 15px;">
		<c:if test="${not empty message}">
			<div class="alert alert-success" role="alert">
				${message}
			</div>
		</c:if>
		
		<c:choose>
			<c:when test="${surveyTakers != null && fn:length(surveyTakers) > 0}">
				<c:forEach items="${surveyTakers}" var="user" varStatus="loop">
					<p>${loop.index + 1}. ${user.firstName} ${user.lastName} - ${user.email}
						<%-- &nbsp; <a href="${pageContext.request.contextPath}/user/delete/${user.id}">Delete</a> --%>
					</p>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<h3>No users to show.</h3>
			</c:otherwise>
		</c:choose>
		
	</div>

</security:authorize>