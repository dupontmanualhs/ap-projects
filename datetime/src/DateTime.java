public class DateTime {
    private Date date;
    private Time time;
    
    public DateTime(Date date, Time time) {
        this.date = date;
        this.time = time;
    }
    
    public DateTime(long secondsSince1900) {
        this.date = new Date((int) (secondsSince1900 / (24 * 60 * 60)));
        this.time = new Time((int) (secondsSince1900 % (24 * 60 * 60)));
    }
    

    
    
    
    
    
    
    
    
    
    
    
    public long secondsSince1900() {
    	return this.date.daysSince1900() * (24L * 60 * 60) + this.time.secondsSinceMidnight();
    }
    
    public String toString() {
        return this.time.toString() + " " + this.date.toString();
    }
}