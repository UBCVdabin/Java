package Classes;

public class Time {
    private int hour;
    private int minute;
    private int second;
    private int GMT;

    public Time() {
        setTime(System.currentTimeMillis());
    } 

    public Time(int _GMT) {
        this.GMT = _GMT;
        setTime(System.currentTimeMillis());
    } 

    public Time(long elapseTime) {
        setTime(elapseTime);
    }

    public Time(int _hour, int _minute, int _second) {
        setHour(_hour);
        setMinute(_minute);
        setSecond(_second);
    }  

    public void setTime(long elapseTime) {
        // Obtain the total milliseconds since midnight, Jan 1, 1970
        long totalMilliseconds = elapseTime;

        // Obtain the total seconds since midnight, Jan 1, 1970
        long totalSeconds = totalMilliseconds / 1000;
        
        // Compute the current second in the minute in the hour
        setSecond(totalSeconds);
         
        // Obtain the total minutes
        long totalMinutes = totalSeconds / 60;
        
        // Compute the current minute in the hour
        setMinute(totalMinutes);
        
        // Obtain the total hours
        long totalHours = totalMinutes / 60 -GMT;
        
        // Compute the current hour       
        setHour(totalHours);
    }

    public void setGMT(int gMT) {
        GMT = gMT;
    }
    private void setHour(long totalHours) {
        hour = (int)(totalHours % 24);
    }

    private void setMinute(long totalMinutes) {
        minute = (int)(totalMinutes % 60);
        hour += (int)(totalMinutes / 60);
        hour %= 24;
    }

    private void setSecond(long totalSeconds) {
        second = (int)(totalSeconds % 60);
        minute += (int)(totalSeconds / 60);
        hour += minute / 60;
        minute %= 60;
        hour %= 24;
    }

    public int getGMT() {
        return GMT;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("%02d", hour % 12) + ":" + String.format("%02d", minute) + ":" + String.format("%02d", second) + (hour / 12 == 1 ? " PM" : " AM");
    }
    
}
