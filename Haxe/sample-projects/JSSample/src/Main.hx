package;

import io.uppercase.unicorn.Calendar;
import js.Lib;

class Main {
	
	static function main() {
		
		var cal:Calendar = new Calendar(Date.now());
		
		trace(cal.getYear());
	}
}