jQuery.noConflict();

jQuery(function() {

	jQuery(".slide_likebox").hover(function() {

		jQuery(".slide_likebox").stop(true, false).animate({
			right : "0"
		}, "medium");

	}, function() {

		jQuery(".slide_likebox").stop(true, false).animate({
			right : "-205"
		}, "medium");

	}, 500);

	return false;

});