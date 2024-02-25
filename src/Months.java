public enum Months {
	JANUARY(31),
	FEBRUARY(28, 29),
	MARCH(31),
	APRIL(30),
	MAY(31),
	JUNE(30),
	JULY(31),
	AUGUST(31),
	SEPTEMBER(30),
	OCTOBER(31),
	NOVEMBER(30),
	DECEMBER(31);
	
	private final int daysInRegularMonth;
	private final int daysInLeapYear;
	
	Months(int daysInRegularYear) {
		this.daysInRegularMonth = daysInRegularYear;
		this.daysInLeapYear = daysInRegularYear; 
	}
	
	Months(int daysInRegularYear, int daysInLeapYear) {
		this.daysInRegularMonth = daysInRegularYear;
		this.daysInLeapYear = daysInLeapYear;
	}
	
	public int getDaysInRegularMonth() {
		return daysInRegularMonth;
	}
	
	public int getDaysInLeapYear() {
		return daysInLeapYear;
	}
}

