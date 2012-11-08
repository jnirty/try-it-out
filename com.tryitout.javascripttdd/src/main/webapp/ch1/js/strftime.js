Date.prototype.strftime = (function() {
	function strftime(format) {
		var date = this;
		return (format + "").replace(/%([a-zA-Z])/g, function(m, f) {
			var formatter = Date.formats && Date.formats[f];
			if (typeof formatter == "function") {
				return formatter.call(Date.formats, date);
			} else if (typeof formatter == "string") {
				return date.strftime(formatter);
			}
			return f;
		});
	}
	// Internal helper
	function zeroPad(num) {
		return (+num < 10 ? "0" : "") + num;
	}
	Date.formats = {
		// Formatting methods
		d : function(date) {
			return zeroPad(date.getDate());
		},
		m : function(date) {
			return zeroPad(date.getMonth() + 1);
		},
		y : function(date) {
			return zeroPad(date.getYear() % 100);
		},
		Y : function(date) {
			return date.getFullYear();
		},
		// Format shorthands
		F : "%Y-%m-%d",
		D : "%m/%d/%y",
		/**
		 * Calculates the day of year
		 */
		j : function(date) {
			var jan1 = new Date(date.getFullYear(), 0, 1);
			var diff = date.getTime() - jan1.getTime();
			// 86400000 ms == 60 min * 60 s * 24 h * 1000 ms = 1 day
			return Math.ceil(diff / 86400000)+1;
		},
		/**
		 * Calculates the week of year
		 */
		w : function(date) {
			var jan1 = new Date(date.getFullYear(), 0, 1);
			var diff = date.getTime() - jan1.getTime();
			// 86400000 ms == 60 min * 60 s * 24 h * 1000 ms = 1 day
			var d = Math.ceil(diff / 86400000);
			var shift = jan1.getDay();
			
			return Math.ceil((d+shift)/7);
		}
	};
	return strftime;
}());