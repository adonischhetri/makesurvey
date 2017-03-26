<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="utf-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Thank You</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1 class="alert alert-danger">Thank you</h1>
				<p>Thanks for the participation</p>
				<%-- <form:form modelAttribute="survey" class="form-horizontal">
					<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />
					<button type="submit" class="btn btn-success" name="_eventId_surveyRestart">
						Restart   <span class="glyphicon glyphicon-chevron-right"></span>
					</button>
				</form:form> --%>
			</div>
		</div>
	</section>
</body>
</html>
