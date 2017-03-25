function saveQuestion(question) {
	var questionType = $("#typeIs").val();
	$.ajax({
		url : "/makesurvey/survey/addQuestion",
		type : 'get',
		dataType : 'json',
		data : {
			'question' : question,
			'questionType' : questionType
		},
		// contentType : 'application/json',
		success : function(response) {
			$('#questionName').val('');
			$('#question').hide();
			qCount++;
			$("#questionList").append("<p>"+qCount+". "+response.title+"</p>");
			alert("Question saved successfully!!");
		},

		error : function(response) {

			alert("Opps!! Something went wrong. Please try again.");

		}

	});
}


function getQuestions(surveyId) {
	$.ajax({
		url : "/makesurvey/survey/questions/"+surveyId,
		type : 'get',
		dataType : 'json',
		contentType : 'application/json',
		success : function(response) {
			$('#surveyQuestions').html('');
			$('#surveyQuestions').show();
			$.each(response, function(i, question){
				$("#surveyQuestions").append("<p>"+(i+1)+". "+question.title+"</p>");
			});
			
		},

		error : function(response) {

			alert("Opps!! Something went wrong. Please try again.");

		}

	});
}

var qCount = $("#qCounter").val();

$("#addQuestionYesNo").on("click", function() {
	$("#typeIs").val(0);
	$("#question").show();
	$("#questionName").val('');
});
$("#addQuestionText").on("click", function() {
	$("#typeIs").val(1);
	$("#question").show();
	$("#questionName").val('');
});
$("#saveQuestion").on("click", function() {
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