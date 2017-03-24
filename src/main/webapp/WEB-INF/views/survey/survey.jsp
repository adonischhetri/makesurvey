<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<section class="container">

	<form id="surveyForm" action="#" class="form-horizontal">
		<fieldset>
			<legend>Add Survey</legend>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2"> Survey Title</label>
				<div class="col-lg-10">
					<input name="surveyTitle" type="text" class="form:input-large" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2"> Description
				</label>
				<div class="col-lg-10">
					<input name="surveyDescription" type="text"
						class="form:input-large" />
				</div>
			</div>

			<hr />

			<div id="addQuestions" class="col-lg-6">
				<input type="button" value="Add Yes/No Question"
					id="addQuestionYesNo" /> &nbsp; <input type="button"
					value="Add Text Question" id="addQuestionText" />
			</div>

			<div class="col-lg-6">
				<div id="question"
					style="display: none; padding: 10px; border: 1px solid #444; margin: 10px 0px;">
					Enter Question: <input type="text" id="questionName"
						name="question" value="" required /> &nbsp; <input type="button"
						value="Save" id="saveQuestion" /> <input type="hidden" value="0"
						name="typeIs" id="typeIs" />
				</div>
			</div>
			<br />
			<hr />

			<div class="col-lg-6" id="questionList"></div>

			<br />
			<hr />
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" id="btnAdd" class="btn btn-primary"
						value="Save Survey" />
				</div>
			</div>

		</fieldset>
	</form>
</section>
</html>