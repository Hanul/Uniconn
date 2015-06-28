package io.uppercase.unicorn;

/**
 * Calendar class
 */
class Calendar {
	private var date:Date;

	public function new(date:Date) {
		this.date = date;
	}
	
	public function getYear():Int {
		return date.getFullYear();
	}

	public function getMonth():Int {
		return date.getMonth() + 1;
	}
	
	public function getFormalMonth():String {
		
		var month:Int = getMonth();
		
		if (month < 10) {
			return "0" + month;
		} else {
			return "" + month;
		}
	}
	
	/*
	self.getDate = getDate = function(isFormal) {
		//OPTIONAL: isFormal
		
		var
		// date
		d = date.getDate();
		
		if (isFormal === true) {
			if (d < 10) {
				return '0' + d;
			} else {
				return '' + d;
			}
		} else {
			return d;
		}
	};

	self.getDay = getDay = function() {
		return date.getDay();
	};

	self.getHour = getHour = function(isFormal) {
		//OPTIONAL: isFormal
		
		var
		// hour
		hour = date.getHours();
		
		if (isFormal === true) {
			if (hour < 10) {
				return '0' + hour;
			} else {
				return '' + hour;
			}
		} else {
			return hour;
		}
	};

	self.getMinute = getMinute = function(isFormal) {
		//OPTIONAL: isFormal
		
		var
		// minute
		minute = date.getMinutes();
		
		if (isFormal === true) {
			if (minute < 10) {
				return '0' + minute;
			} else {
				return '' + minute;
			}
		} else {
			return minute;
		}
	};

	self.getSecond = getSecond = function(isFormal) {
		//OPTIONAL: isFormal
		
		var
		// second
		second = date.getSeconds();
		
		if (isFormal === true) {
			if (second < 10) {
				return '0' + second;
			} else {
				return '' + second;
			}
		} else {
			return second;
		}
	};
	*/
}