from datetime import datetime as python_lib_datetime_Datetime


class Date:

	def __init__(self,year,month,day,hour,_hx_min,sec):
		# C:\HaxeToolkit\haxe\std/python/_std/Date.hx:33
		self.date = None
		# C:\HaxeToolkit\haxe\std/python/_std/Date.hx:37
		if (year < python_lib_datetime_Datetime.min.year):
			year = python_lib_datetime_Datetime.min.year
		# C:\HaxeToolkit\haxe\std/python/_std/Date.hx:38
		if (day == 0):
			day = 1
		# C:\HaxeToolkit\haxe\std/python/_std/Date.hx:39
		self.date = python_lib_datetime_Datetime(year, (month + 1), day, hour, _hx_min, sec, 0)

	@staticmethod
	def now():
		# C:\HaxeToolkit\haxe\std/python/_std/Date.hx:101
		d = Date(1970, 0, 1, 0, 0, 0)
		# C:\HaxeToolkit\haxe\std/python/_std/Date.hx:102
		d.date = python_lib_datetime_Datetime.now()
		# C:\HaxeToolkit\haxe\std/python/_std/Date.hx:103
		return d



class Main:

	@staticmethod
	def main():
		# src/Main.hx:15
		cal = io_uppercase_unicorn_Calendar(Date.now())
		# src/Main.hx:17
		print(str(cal.getYear()))


class io_uppercase_unicorn_Calendar:

	def __init__(self,date):
		# C:\Users\hanul\Documents\aptana-workspace\Unicorn\Haxe\unicorn\src/io/uppercase/unicorn/Calendar.hx:7
		self.date = None
		# C:\Users\hanul\Documents\aptana-workspace\Unicorn\Haxe\unicorn\src/io/uppercase/unicorn/Calendar.hx:10
		self.date = date

	def getYear(self):
		# C:\Users\hanul\Documents\aptana-workspace\Unicorn\Haxe\unicorn\src/io/uppercase/unicorn/Calendar.hx:14
		return self.date.date.year

	def getMonth(self):
		# C:\Users\hanul\Documents\aptana-workspace\Unicorn\Haxe\unicorn\src/io/uppercase/unicorn/Calendar.hx:18
		return ((self.date.date.month - 1) + 1)

	def getFormalMonth(self):
		# C:\Users\hanul\Documents\aptana-workspace\Unicorn\Haxe\unicorn\src/io/uppercase/unicorn/Calendar.hx:23
		month = self.getMonth()
		# C:\Users\hanul\Documents\aptana-workspace\Unicorn\Haxe\unicorn\src/io/uppercase/unicorn/Calendar.hx:25
		if (month < 10):
			return ("0" + str(month))
		else:
			return ("" + str(month))



class HxOverrides:

	@staticmethod
	def stringOrNull(s):
		# C:\HaxeToolkit\haxe\std/python/internal/HxOverrides.hx:53
		if (s is None):
			return "null"
		else:
			return s



Main.main()