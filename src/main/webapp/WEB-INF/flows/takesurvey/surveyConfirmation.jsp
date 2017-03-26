<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container">
	<div class="row">
		<form:form modelAttribute="Survey" class="form-horizontal">
			<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />

			<div
				class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
				<div class="text-center">
					<h1>Token</h1>
				</div>
				<div class="row">
					<div class="col-xs-6 col-sm-6 col-md-6">
						<address>
							<strong></strong> <br> <br>
						</address>
					</div>
					<div class="col-xs-6 col-sm-6 col-md-6 text-right">
						<p>
							<em> <fmt:formatDate type="date" value="${survey.addedDate}" /></em>
						</p>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-6 col-sm-6 col-md-6">
						<address>
							<strong></strong> <br>

						</address>
					</div>

				</div>
				<div class="row">

					<table class="table table-hover">
						<thead>
							<tr>

							</tr>
						</thead>
						<tbody>

						</tbody>
					</table>
					<button id="back" class="btn btn-default" name="_eventId_backToCollectSurveyDetail">back</button>

					<button type="submit" class="btn btn-success" name="_eventId_surveyConfirmed">
						Confirm   <span class="glyphicon glyphicon-chevron-right"></span>
					</button>
					<button id="btnCancel" class="btn btn-default" name="_eventId_cancel">Cancel</button>
				</div>
			</div>
		</form:form>
	</div>
</div>