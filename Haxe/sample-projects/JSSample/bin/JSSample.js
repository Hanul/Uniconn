(function (console) { "use strict";
var Main = function() { };
Main.main = function() {
	var cal = new io_uppercase_unicorn_Calendar(new Date());
	var b = 1;
	console.log(cal.getYear());
};
var io_uppercase_unicorn_Calendar = function(date) {
	this.date = date;
};
io_uppercase_unicorn_Calendar.prototype = {
	getYear: function() {
		return this.date.getFullYear();
	}
	,getMonth: function() {
		return this.date.getMonth() + 1;
	}
	,getFormalMonth: function() {
		var month = this.getMonth();
		if(month < 10) return "0" + month; else return "" + month;
	}
};
Main.main();
})(typeof console != "undefined" ? console : {log:function(){}});

//# sourceMappingURL=JSSample.js.map