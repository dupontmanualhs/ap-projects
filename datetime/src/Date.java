public class Date {
    private int year;
    private int month;
    private int day;
    
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    
    public Date(int daysSince1900) {
        this.year = Date.yearGivenDaysSince(1900, daysSince1900);
        int dayOfYear;
        if (this.year > 1900) {
            Date dec31 = new Date(this.year, 12, 31);
            dayOfYear = daysSince1900 - dec31.daysSince1900();
        } else {
        	dayOfYear = daysSince1900;
        }
        this.month = Date.monthGivenDayOfYear(dayOfYear, this.year);
        this.day = dayOfYear - this.daysInYearBeforeThisMonth();
    }
    
    public static int yearGivenDaysSince(int yr, int days) {
    	if (days <= 365 || (Date.isLeapYear(yr) && days <= 366)) {
    		return yr;
    	} else {
    		int daysThisYear;
    		if (Date.isLeapYear(yr)) {
    			daysThisYear = 366;
    		} else {
    			daysThisYear = 365;
    		}
    		return yearGivenDaysSince(yr + 1, days - daysThisYear);
    	}
    }
    
    public String monthName() {
    	if (this.month == 1) {
    		return "January";
    	} else if (this.month == 2) {
    		return "February";
    	} else if (this.month == 3) {
    		return "March";
    	} else if (this.month == 4) {
    		return "April";
    	} else if (this.month == 5) {
    		return "May";
    	} else if (this.month == 6) {
    		return "June";
    	} else if (this.month == 7) {
    		return "July";
    	} else if (this.month == 8) {
    		return "August";
    	} else if (this.month == 9) {
    		return "September";
    	} else if (this.month == 10) {
    		return "October";
    	} else if (this.month == 11) {
    		return "November";
    	} else {
    		return "December";
    	}
    }
    
    public static boolean isLeapYear(int y) {
    	if (y % 100 == 0) {
    		return y % 400 == 0;
    	} else {
    		return y % 4 == 0;
    	}
    }
    
    public boolean isLeapYear() {
        // leap years are divisible by 4,
        // except century years are not leap years, unless
        //   the century is divisible by 4
        // leap years:  2004 2008 1932 2000 1600
        // not leap years: 2003 1900 1800 1700 2100
        // n % d == 0 means n is divisible by d
    	return Date.isLeapYear(this.year);
    }
    
    public int daysInMonth(int m) {
    	if (m == 2) {
    		if (this.isLeapYear()) {
    			return 29;
    		} else {
    			return 28;
    		}
    	} else if (m == 9 || m == 4 || m == 6 || m == 11) { // 30 days hath September, April, June, and November
    		return 30;
    	} else {
    		return 31;
    	}
    }
    
    public int daysInYearBeforeThisMonth() {
    	if (this.month == 1) {
    		return 0;
    	} else {
    		Date lastMonth = new Date(this.year, this.month - 1, 1);
    		return lastMonth.daysInYearBeforeThisMonth() + this.daysInMonth(this.month - 1);
    	}
    }
        
    public int dayOfYear() {
    	return this.daysInYearBeforeThisMonth() + this.day;
    }
    
    public int daysSince1900() {
    	if (this.year == 1900) {
    		return this.dayOfYear();
    	} else {
    		Date endOfLastYear = new Date(this.year - 1, 12, 31);
    		return endOfLastYear.daysSince1900() + this.dayOfYear();
    	}
    }
    
    public String toString() {
        return this.monthName() + " " + this.day + ", " + this.year;
    }
    
    public static int monthGivenDayOfYear(int doy, int yr) {
    	if (doy <= 31) {
    		return 1;
    	} else if (doy <= 59 || (Date.isLeapYear(yr) && doy <= 60)) {
    		return 2;
    	} else if (doy <= 90 || (Date.isLeapYear(yr) && doy <= 91)) {
    		return 3;
    	} else if (doy <= 120 || (Date.isLeapYear(yr) && doy <= 121)) {
    		return 4;
    	} else if (doy <= 151 || (Date.isLeapYear(yr) && doy <= 152)) {
    		return 5;
    	} else if (doy <= 181 || (Date.isLeapYear(yr) && doy <= 182)) {
    		return 6;
    	} else if (doy <= 212 || (Date.isLeapYear(yr) && doy <= 213)) {
    		return 7;
    	} else if (doy <= 243 || (Date.isLeapYear(yr) && doy <= 244)) {
    		return 8;
    	} else if (doy <= 273 || (Date.isLeapYear(yr) && doy <= 274)) {
    		return 9;
    	} else if (doy <= 304 || (Date.isLeapYear(yr) && doy <= 305)) {
    		return 10;
    	} else if (doy <= 334 || (Date.isLeapYear(yr) && doy <= 335)) {
    		return 11;
    	} else {
    		return 12;
    	}
    }
}    