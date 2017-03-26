<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="utf-8">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Invalid Survey </title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1 class="alert alert-danger">survey cancelled</h1>
				<p>Your Survey process cancelled! </p>
			</div>
		</div>
	</section>

	<section>
		<div class="container">
			<p> Dummy survey wih id = 1
				<a href="<spring:url value="/takesurvey?surveyId=1" />" class="btn btn-primary">
					Take Survey
				</a>
			</p>
		</div>
		
	</section>
</body>
</html>
