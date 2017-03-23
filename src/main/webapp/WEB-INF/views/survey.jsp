<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h1>Create New Survey</h1>

<section class="container">

	<form action="" class="form-horizontal">
		<fieldset>
			<legend>Add Survey</legend>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2"> Questotin? </label>
				<div class="col-lg-10">
					<input name="firstName" type="text" class="form:input-large" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2"> Questotin? </label>
				<div class="col-lg-10">
					<input name="firstName" type="text" class="form:input-large" />
				</div>
			</div>
			
			
			
			

			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" id="btnAdd" class="btn btn-primary"
						value="Signup" />
				</div>
			</div>

		</fieldset>
	</form>
</section>
</html>