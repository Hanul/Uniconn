package;

import io.uppercase.unicorn.Calendar;
import python.Lib;

class Main {
	
	static function main() {
		
		var cal:Calendar = new Calendar(Date.now());
		
		trace(cal.getYear());
	}
}