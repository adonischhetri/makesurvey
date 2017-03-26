<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="col-lg-8" id="surveyList">
	<c:set var="qCounter" value="0" />
	<c:choose>
		<c:when test="${surveyList != null && fn:length(surveyList) > 0}">
			<c:forEach items="${surveyList}" var="survey" varStatus="qCount">
				<c:set var="qCounter" value="${qCount.index + 1}" />
				<p>${qCounter}.
					<a href="#" onclick="getQuestions(${survey.id});">${survey.title}</a>
					&nbsp; <a
						href="${pageContext.request.contextPath}/survey/delete/${survey.id}">Delete</a>
				</p>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<h3>No survey to show.</h3>
		</c:otherwise>
	</c:choose>

	<div id="surveyQuestions"
		style="display: none; padding: 10px; margin-left: 20px;"></div>
</div>
<div class="col-lg-4">
	<p>
		<a href="${pageContext.request.contextPath}/survey/create">Create New Survey</a>
	</p>
</div>