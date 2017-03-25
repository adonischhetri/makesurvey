function makeAjaxCall() {
	var data = JSON.stringify(serializeObject($('#employeeForm')));
	$
			.ajax({
				url : "/makesurvey/surveyTakers",
				type : 'post',
				dataType : 'json',
				data : data,
				contentType : 'application/json',
				success : function(response) {
					$('#formInput').html("");
					$("#formInput")
							.append(
									'<H3 align="center"> New Survey Taker Information <H3>');
					$('#formInput').append(
							"<H4 align='center'>First Name:  " + response.firstName+"</h4>");
					$('#formInput').append(
							"<H4 align='center'>Last Name: " +response.lastName +"</h4>");
					$('#formInput').append(
							"<H4 align='center'>Email: " +response.email +"</h4>");
					$("#formInput")
							.append(
									'<h4 align="center"> <a href="#" onclick="toggle_visibility(\'formInput\');resetForm(\'employeeForm\');"><b>EXIT</b> </a> </h4>');
					make_visible('formInput');
					make_hidden('errors');
				},

				error : function(response) {
					
					if(response.responseJSON.errorType == "ValidationError"){
						$('#formInput').html("");
						$('#errors').html("");
						$("#errors").append("<h2>errors</h2>");
						$.each(response.responseJSON.errors, function(i, error){
							$('#errors').append("<h3>"+error.message+"</h3>");
						});
						
						make_hidden('formInput');
						make_visible('errors');
						
					}else{
						alert(response.responseJSON.errors(0));
					}

				}

			});
}

toggle_visibility = function(id) {
	var element = document.getElementById(id);
	if (element.style.display == 'block')
		element.style.display = 'none';
	else
		element.style.display = 'block';
}

make_hidden = function(id) {
	var element = document.getElementById(id);
	element.style.display = 'none';
}

make_visible = function(id) {
	var element = document.getElementById(id);
	element.style.display = 'block';
}

resetForm = function(id) {
	var element = document.getElementById(id);
	$(element)[0].reset();

}

// Translate form to array
// Then put in JSON format
function serializeObject(form) {
	var jsonObject = {};
	var array = form.serializeArray();
	$.each(array, function() {
		jsonObject[this.name] = this.value;
	});
	return jsonObject;

};

