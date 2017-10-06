/**
 * Author: Jack Brashier
 * Date: 10/06/2017
 * Professor: Kanchanawanchai
 */
public class Time {
    private final int MILLISINSEC = 1000;
    private final long MILLISINDAY = 86400000;
    private final int SECSINMINUTE = 60;
    private final int MINSINHOUR = 60;
    private long hour;
    private long minute;
    private long second;

    /** Reads milliseconds since the epoch, sets hours, minutes, and seconds to UCT 24hr time equivalent. */
    public Time() {
        this.hour = ((System.currentTimeMillis() % MILLISINDAY) / MILLISINSEC / SECSINMINUTE / MINSINHOUR);
        this.minute = (((System.currentTimeMillis() % MILLISINDAY) % (MILLISINSEC * SECSINMINUTE * MINSINHOUR)) / (MILLISINSEC * SECSINMINUTE));
        this.second = ((((System.currentTimeMillis() % MILLISINDAY) / MILLISINSEC) % MINSINHOUR) % SECSINMINUTE);
    }

    /** Takes the millisecond constructor and sets hours, minutes, and seconds to UCT 24hr time equivalent. */
    public Time(long msPassed) {
        this.hour = ((msPassed % MILLISINDAY) / MILLISINSEC / SECSINMINUTE / MINSINHOUR);
        this.minute = (((msPassed % MILLISINDAY) % (MILLISINSEC * SECSINMINUTE * MINSINHOUR)) / (MILLISINSEC * SECSINMINUTE));
        this.second = ((((msPassed % MILLISINDAY) / MILLISINSEC) % MINSINHOUR) % SECSINMINUTE);
    }

    /** Takes the hour, minute, and second constructor and sets their respective data fields to them. */
    public Time(long hours, long minutes, long seconds) {
        this.hour = hours;
        this.minute = minutes;
        this.second = seconds;
    }

    /** Displays the time in an easy to read HH:MM:SS 24hr format. */
    public String show24Time() {
        String hourString = Long.toString(this.hour);
        String minuteString = Long.toString(this.minute);
        String secondString = Long.toString(this.second);
        if (this.hour < 10) {
            hourString = "0" + Long.toString(this.hour);
        }
        if (this.minute < 10) {
            minuteString = "0" + Long.toString(this.minute);
        }
        if (this.second < 10) {
            secondString = "0" + Long.toString(this.second);
        }
        String returnString = (hourString + ":" + minuteString + ":" + secondString);
        return returnString;
    }

    public String show12Time() {
        String hourString = Long.toString(this.hour);
        String minuteString = Long.toString(this.minute);
        String secondString = Long.toString(this.second);
        if(this.hour > 12) {
            if(this.hour % 12 < 10) {
                hourString = "0" + Long.toString(this.hour % 12);
            } else {
                hourString = Long.toString(this.hour % 12);
            }
        }
        if(this.minute < 10) {
            minuteString = "0" + Long.toString(this.minute);
        }
        if(this.second < 10) {
            secondString = "0" + Long.toString(this.second);
        }
        if(this.hour > 12) {
            secondString += "pm";
        } else {
            secondString += "am";
        }
        String returnString = (hourString + ":" + minuteString + ":" + secondString);
        return returnString;
    }

    public void setTime(long elapseTime) {
        this.hour = ((elapseTime % 86400000) / 1000 / 60 / 60);
        this.minute = (((elapseTime % 86400000) % 3600000) / 60000);
        this.second = ((((elapseTime % 86400000) / 1000) % 60) % 60);
    }

    public long getHour() {
        return hour;
    }

    public long getMinute() {
        return minute;
    }

    public long getSecond() {
        return second;
    }
}
