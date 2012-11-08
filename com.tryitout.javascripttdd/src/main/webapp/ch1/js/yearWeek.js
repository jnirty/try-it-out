
/**
 * Calculates the week of year
 */
var getWeek = function(d) {
   // Copy date so don't modify original
    d = new Date(d);
    d.setHours(0,0,0);
    // Set to nearest Thursday: current date + 4 - current day number
    // Make Sunday's day number 7
    d.setDate(d.getDate() + 4 - (d.getDay()||7));
    // Get first day of year
    var yearStart = new Date(d.getFullYear(),0,1);
    // Calculate full weeks to nearest Thursday
    var weekNo = Math.ceil(( ( (d - yearStart) / 86400000) + 1)/7)
        return weekNo;
}





/**
 * unit tests
 */

function testCase(name, tests) {
    assert.count = 0;
    var successful = 0;
    var testCount = 0;

    for (var test in tests) {
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
    output("<strong>" + testCount + " tests, " + (testCount - successful) + " failures</strong>", color);
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
    "test should return 1 for 1st day of 1970": function() {
        assert("should return 1", getWeek(new Date(1970, 0, 1)) === 1);
    },
    "test should return 1 for 1972-01-07": function() {
        assert("should return 1", getWeek(new Date(1972, 0, 7)) === 1);
    },
    "test should return 1 for 1972-01-08": function() {
        assert("should return 1", getWeek(new Date(1972, 0, 8)) === 1);
    },
    "test should return 1 for 1972-01-09": function() {
        assert("should return 1", getWeek(new Date(1972, 0, 9)) === 1);
    },
    "test should return 2 for 1972-01-10": function() {
        assert("should return 2", getWeek(new Date(1972, 0, 10)) === 2);
    },
    "test should return 53 for 1970-12-30": function() {
        assert("should return 53", getWeek(new Date(1970, 11, 30)) === 53);
    },
    "test should return 52 for 1st day of 1972": function() {
        assert("should return 52", getWeek(new Date(1972, 0, 1)) === 52);
    },
    "test should return 45 for 2012-11-06": function() {
        assert("should return 45", getWeek(new Date(2012, 10, 6)) === 45);
    },
    "test should return 1 for 2013-01-06": function() {
        assert("should return 1", getWeek(new Date(2013, 0, 6)) === 1);
    },
    "test should return 53 for 2038-01-01": function() {
        assert("should return 53", getWeek(new Date(2038, 0, 1)) === 53);
    },
    "test should return 3 for 2038-01-18": function() {
        assert("should return 3", getWeek(new Date(2038, 0, 18)) === 3);
    }
});