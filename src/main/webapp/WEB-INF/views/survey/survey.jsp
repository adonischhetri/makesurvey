<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<section class="container">

	<form:form id="surveyForm" modelAttribute="survey" action="" class="form-horizontal" method="post" role = "form">
		<fieldset>
			<legend>Add Survey</legend>
	
			<div class="form-group">
				<div class="col-lg-10">
					<form:errors path="*" cssClass="alert alert-danger" element="div" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2"> Survey Title</label>
				<div class="col-lg-10">
					<form:input path="title" type="text" class="form:input-large" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2"> Description
				</label>
				<div class="col-lg-10">
					<form:input path="description" type="text" class="form:input-large" />
				</div>
			</div>

			<hr />

			<div id="addQuestions" class="col-lg-6">
				<input type="button" value="Add Yes/No Question" id="addQuestionYesNo" /> &nbsp; 
				<input type="button" value="Add Text Question" id="addQuestionText" />
			</div>

			<div class="col-lg-6">
				<div id="question"
					style="display: none; padding: 10px; border: 1px solid #444; margin: 10px 0px;">
					Enter Question: <input type="text" id="questionName" name="question" value="" /> &nbsp; 
					<input type="button" value="Save" id="saveQuestion" /> 
					<input type="hidden" value="0" name="typeIs" id="typeIs" />
				</div>
			</div>
			<br />
			<hr />

			<h3>Question List</h3>
			<div class="col-lg-6" id="questionList">
				<c:set var="qCounter" value="0" />
				<c:if test = "${questionList != null}">
					<c:forEach items = "${questionList}" var="question" varStatus="qCount">
						<c:set var="qCounter" value="${qCount.index + 1}" />
						<p>${qCounter}. ${question.title}</p>
					</c:forEach>
				</c:if>
				<input type="hidden" value="${qCounter}" id="qCounter" />
			</div>

			<br />
			<hr />
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" class="btn btn-primary" value="Save Survey" />
				</div>
			</div>

		</fieldset>
	</form:form>
</section>
</html>