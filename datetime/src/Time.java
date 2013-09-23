public class Time {
    private int hour; // 0-23
    private int minute; // 0-59
    private int second; // 0-59
    
    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    
    public Time(int secondsSinceMidnight) {
        this.hour = secondsSinceMidnight / 3600;
        this.minute = (secondsSinceMidnight % 3600) / 60;
        this.second = secondsSinceMidnight % 60;
    }
    
    public int secondsSinceMidnight() {
    	return (this.hour * 60 + this.minute) * 60 + this.second;
    }
    
    public String toString() {
        return this.hourString() + ":" + Time.maybeAddZero(this.minute) + ":" 
            + Time.maybeAddZero(this.second) + " " + this.amOrPm(); 
    }
    
    public String hourString() {
    	if (this.hour == 0) {
    		return "12";
    	} else if (this.hour > 12) {
    		return "" + (this.hour - 12);
    	} else {
    		return "" + this.hour;
    	}
    }
    
    public static String maybeAddZero(int minOrSec) {
    	if (minOrSec < 10) {
    		return "0" + minOrSec;
    	} else {
    		return "" + minOrSec;
    	}
    }
    
    public String amOrPm() {
    	if (this.hour < 12) {
    		return "AM";
    	} else {
    		return "PM";
    	}
    }
}