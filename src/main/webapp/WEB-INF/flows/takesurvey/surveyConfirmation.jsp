<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container">
	<div class="row">
		<form:form modelAttribute="survey" class="form-horizontal">
			<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />

			<div
				class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
				<div class="text-center">
					<h1>You are submitting:</h1>
				</div>
				<div class="row">
						<h4>${survey.title}</h4>
						<p>${survey.description}</p>
				</div>
				<div class="row">
					<c:forEach items="${survey.questions}" var="question" varStatus="loop">
					<p>
					${loop.index+1}) ${question.title}
					:
					${survey.questions[loop.index].responses.answer}
					</p>
				</c:forEach>
				</div>
				<div class="row">

					<button id="back" class="btn btn-default" name="_eventId_backToCollectSurveyDetail">Back</button>

					<button type="submit" class="btn btn-success" name="_eventId_surveyConfirmed">
						Confirm   <span class="glyphicon glyphicon-chevron-right"></span>
					</button>
					<!-- <button id="btnCancel" class="btn btn-default" name="_eventId_cancel">Cancel</button> -->
				</div>
			</div>
		</form:form>
	</div>
</div>