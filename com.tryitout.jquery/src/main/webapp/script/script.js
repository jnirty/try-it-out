$(document).ready(function() {
	$('#form').submit(function() {
		var number = $('#number').val();

		$.ajax({
			type : "post",
			url : "jsp/calculate.jsp",
			data : "number=" + number,
			success : function(msg) {

				$('#result').hide();

				$("#result").html("<h3>" + msg + "</h3>").fadeIn("slow");
			}
		});

		return false;
	});
});

$(document).ready(function() {
	$('#result').click(function() {
		$("#result").addClass("red");
	});

});

$(document).ready(function() {
	$("#appendButton").click(function() {
		$("#list").find("a").each(function(i) {
			$(this).append(" BAM! " + i);
		});
	});
});

$(document).ready(function() {
	// twitter api's base url
	var url = "http://search.twitter.com/search.json?callback=?&q=";
	// we'll store the search term here
	var query;

	// when the user clicks the button
	$("button").click(function() {
		// get value in the search box and store it in the variable
		query = $("#query").val();
		// get the json file
		// get the json file
		$.getJSON(url + query, function(json) {
			// this is where we can loop through the results in the json object
			$.each(json.results, function(i,tweet){
			     // this is where we do what we want with the tweet
				 $("#results").append('<p><img src="'+tweet.profile_image_url+'" widt="48" height="48" />'+tweet.text+'</p>');
			});
		});
	});
});


