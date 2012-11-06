function testCase(name, tests) {
	assert.count = 0;
	var successful = 0;
	var testCount = 0;
	for ( var test in tests) {
		if (!/^test/.test(test)) {
			continue;
		}
		testCount++;
		try {
			tests[test]();
			output(test, "#0c0");
			successful++;
		} catch (e) {
			output(test + " failed: " + e.message, "#c00");
		}
	}
	var color = successful == testCount ? "#0c0" : "#c00";
	output("<strong>" + testCount + " tests, " + (testCount - successful)
			+ " failures</strong>", color);
}

/**
 * Assertion function
 * 
 * @param message
 * @param expr
 * @returns
 */
function assert(message, expr) {
	if (!expr) {
		throw new Error(message);
	}
	assert.count++;
	return true;
}
/**
 * Outputs errors in HTML element
 */
function output(text, color) {
	var p = document.createElement("p");
	p.innerHTML = text;
	p.style.color = color;
	document.body.appendChild(p);
}

assert.count = 0;

var date = new Date(2009, 9, 2);
testCase("strftime test", {
	"test format specifier %Y" : function() {
		assert("%Y should return full year", date.strftime("%Y") === "2009");
	},
	"test format specifier %m" : function() {
		assert("%m should return month", date.strftime("%m") === "10");
	},
	"test format specifier %d" : function() {
		assert("%d should return date", date.strftime("%d") === "02");
	},
	"test format specifier %y" : function() {
		assert("%y should return year as two digits",
				date.strftime("%y") === "09");
	},
	"test format shorthand %F" : function() {
		assert("%F should act as %Y-%m-%d",
				date.strftime("%F") === "2009-10-02");
	}
});