<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<link href="http://getbootstrap.com/examples/jumbotron/jumbotron.css" rel="stylesheet">

<div class="jumbotron">
	<h1>
		<tiles:insertAttribute name="heading" />
	</h1>
	
</div>
