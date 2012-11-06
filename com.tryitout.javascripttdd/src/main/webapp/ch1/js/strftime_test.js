function testCase(name, tests) {
	assert.count = 0;
	var successful = 0;
	var testCount = 0;
	var hasSetup = typeof tests.setUp == "function";
	var hasTeardown = typeof tests.tearDown == "function";

	for ( var test in tests) {
		if (!/^test/.test(test)) {
			continue;
		}
		testCount++;
		try {
			if (hasSetup) {
				tests.setUp();
			}
			tests[test]();
			output(test, "#0c0");
			if (hasTeardown) {
				tests.tearDown();
			}
			// If the tearDown method throws an error, it is
			// considered a test failure, so we don't count
			// success until all methods have run successfully
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

testCase("strftime test", {
	setUp : function() {
		this.date = new Date(2009, 9, 2, 22, 14, 45);
	},
	"test format specifier %Y" : function() {
		assert("%Y should return full year", Date.formats.Y(this.date) === 2009);
	},
	"test format specifier %m" : function() {
		assert("%m should return month", Date.formats.m(this.date) === "10");
	},
	"test format specifier %d" : function() {
		assert("%d should return date", Date.formats.d(this.date) === "02");
	},
	"test format specifier %y" : function() {
		assert("%y should return year as two digits", Date.formats.y(this.date) === "09");
	},
	"test format shorthand %F" : function() {
		assert("%F should act as %Y-%m-%d", Date.formats.F === "%Y-%m-%d");
	},
	"test format specifier %j should return 1 for 1st day of 1970" : function() {
		console.log(Date.formats.j(new Date(1970,0,1)));
		assert("%j should return 1", Date.formats.j(new Date(1970,0,1)) === 1);		
	},
	"test format specifier %j should return 1 for 1st day of 2012" : function() {
		console.log(Date.formats.j(new Date(2012,0,1)));
		assert("%j should return 1", Date.formats.j(new Date(2012,0,1)) === 1);		
	},
	"test format specifier %j should return 365 for last day of 1970" : function() {
		console.log(Date.formats.j(new Date(1970,11,31)));
		assert("%j should return 365", Date.formats.j(new Date(1970,11,31)) === 365);		
	},
	"test format specifier %j should return 366 for last day of 1972 (leap year)": function(){
		console.log(Date.formats.j(new Date(1972,11,31)));
		assert("%j should return 366", Date.formats.j(new Date(1972,11,31)) === 366);	
	}
});