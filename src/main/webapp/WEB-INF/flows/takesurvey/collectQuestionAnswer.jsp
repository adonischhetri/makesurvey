<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<section class="container">

	<form:form modelAttribute="survey" action="" class="form-horizontal" method="post" role = "form">
		<fieldset>
			<legend>${survey.title}</legend>
	
			<div class="form-group">
				<div class="col-lg-10">
					<form:errors path="*" cssClass="alert alert-danger" element="div" />
				</div>
			</div>
			
			<h5>${survey.description}</h5>
			
			<hr />

			<c:forEach items="${survey.questions}" var="question" varStatus="loop">
				<p>
				${loop.index+1}) ${question.title}
				:
				<c:choose>
					<c:when test="${question.getClass().name eq 'com.coderovers.makesurvey.domain.question.YesNo'}">
						<form:radiobutton path="questions[${loop.index}].responses.answer" value="" id="yes"/><label for="yes">Yes</label>
						<form:radiobutton path="questions[${loop.index}].responses.answer" value="" id="no"/><label for="no">No</label>
					</c:when>
					<c:otherwise>
						<form:input path="questions[${loop.index}].responses.answer" value=""/>
					</c:otherwise>
				</c:choose>
				</p>
			</c:forEach>

			<br />
			<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
				
			<div class="form-group">
				<div class="col-lg-10">
					<input type="submit" id="btnAdd" class="btn btn-primary" value="Submit Survey" name="_eventId_surveyInfoCollected" />
					<button id="btnCancel" class="btn btn-default" name="_eventId_surveyCancelled">Cancel</button>
				</div>
			</div>

		</fieldset>
	</form:form>
</section>
</html>