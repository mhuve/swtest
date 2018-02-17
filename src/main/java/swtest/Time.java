package swtest;

public class Time {

    
    private final String timeZone;
    private final String time;

    public Time(String timezone, String time) {
        this.timeZone=timezone;
        this.time=time;
    }

    

    public String getTimeZone() {
        return timeZone;
    }

    public String getTime() {
        return time;
    }
}
