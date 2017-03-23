function saveQuestion(question) {
	var questionType = $("#typeIs").val();
	$.ajax({
				url : "/makesurvey/survey/addQuestion",
				type : 'get',
				dataType : 'json',
				data : {'question' : question, 'questionType' : questionType},
				//contentType : 'application/json',
				success : function(response) {
					$('#questionName').val('');
					$('#question').hide();
					alert("Question saved successfully!!");
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


$("#addQuestionYesNo").on("click", function(){
	$("#typeIs").val(0);
	$("#question").show();
	$("#questionName").val('');
});
$("#addQuestionText").on("click", function(){
	$("#typeIs").val(1);
	$("#question").show();
	$("#questionName").val('');
});
$("#saveQuestion").on("click", function(){
	saveQuestion($("#questionName").val());
});

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
function serializeObject(form) {
	var jsonObject = {};
	var array = form.serializeArray();
	$.each(array, function() {
		jsonObject[this.name] = this.value;
	});
	return jsonObject;

};