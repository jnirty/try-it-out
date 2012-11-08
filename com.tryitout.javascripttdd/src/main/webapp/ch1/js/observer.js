var Observable = function() {
	this.listeners = {any: []};
	this.addEventListener = function(type, fn) {
		type = type || 'any';
		if (typeof this.listeners[type] === "undefined") {
			this.listeners[type] = [];
		}
		this.listeners[type].push(fn);
	};
	this.removeEventListener = function(type, fn){
		type = type || 'any';
		if (typeof this.listeners[type] === "undefined") {
			this.listeners[type] = [];
		}
		for(var key in this.listeners){
			if(key.slice(0, type.length) == type){
				var functions = this.listeners[key];
				var newFunc = [];
				for(var i=0; i<functions.length; i++){
					if(functions[i]!==fn){
						newFunc.push(fn);
					}
				}
				this.listeners[key]=newFunc;
			}
			
		}
	};
	this.trigger = function(type, data) {
		var ret = [];
		for(var key in this.listeners){
		
			if(key.slice(0, type.length) == type){
				var functions = this.listeners[key];
				for(var i=0; i<functions.length; i++){
					var result = functions[i].call(this,data);
					ret.push(result);
					functions = this.listeners[key];
				}
			}
		}
		return ret;
			
	};
};




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

testCase("observable test", {
	"test observable1": function() {
      
		var observable = new Observable();
		observable.addEventListener("change:title", function(data) {
			return "title has changed to "+ data.title;
		});
		var res = observable.trigger("change:title", { title: "foo" });
		assert("res.length="+res.length,res.length==1);
		assert("res="+res,res[0]==="title has changed to foo");
		
		res = observable.trigger("change", { title: "bar" });
		assert("res.length="+res.length,res.length==1);
		assert("res="+res,res[0]==="title has changed to bar");
	},
	"test observable2": function() {
	      
		var observable = new Observable();
		var anotherHandler = function() {
			return "I'm another handler";
		};
		var handler = function(data) {
			var ret = "removing my friend";
			observable.removeEventListener("change:title", anotherHandler);
			return ret;
		};
		observable.addEventListener("change:title", handler);
		observable.addEventListener("change:title", anotherHandler);
		var res = observable.trigger("change:title", { title: "foo" });
		assert("res="+res,"removing my friend"===res[0]);
	}

});
