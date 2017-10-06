public class TimeDriver {
    public static void main(String[] args) {
        Time currentTime = new Time();
        Time customTime = new Time(555550000);

        System.out.println("The current time in UTC is " + currentTime.show24Time());
        System.out.println("The current time in UTC 12hr time is " + currentTime.show12Time());

        System.out.println("\nYour custom time in UTC is " + customTime.show24Time());
        System.out.println("Your custom time in UTC 12hr time is " + customTime.show12Time());

        customTime.setTime(43200000); //Sets the custom time to 43200000 ms or 12 hr, for demonstration purposes.

        System.out.println("\nYour updated custom time in UTC is " + customTime.show24Time());
        System.out.println("Your updated custom time in UTC 12hr time is " + customTime.show12Time());
    }
}
