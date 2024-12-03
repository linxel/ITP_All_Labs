public class lab2_3 {
    private int hours;
    private int minutes;
    private int seconds;

    private lab2_3(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public lab2_3 inc() {
        seconds++;
        if (seconds >= 60) {
            seconds = 0;
            minutes++;
        }
        if (minutes >= 60) {
            minutes = 0;
            hours++;
        }
        if (hours >= 24) {
            hours = 0;
        }
        return this;
    }

    // Method to calculate the difference between two times
    public static long difference(lab2_3 t1, lab2_3 t2) {
        long totalSeconds1 = t1.hours * 3600 + t1.minutes * 60 + t1.seconds;
        long totalSeconds2 = t2.hours * 3600 + t2.minutes * 60 + t2.seconds;
        return Math.abs(totalSeconds1 - totalSeconds2);
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public static class TimeCreator {
        public static lab2_3 createFromHours(int hours) {
            return new lab2_3(hours, 0, 0);
        }

        public static lab2_3 createFromHoursAndMinutes(int hours, int minutes) {
            return new lab2_3(hours, minutes, 0);
        }

        public static lab2_3 createFromHoursMinutesAndSeconds(int hours, int minutes, int seconds) {
            return new lab2_3(hours, minutes, seconds);
        }
    }

    public static void main(String[] args) {
        lab2_3 t1 = TimeCreator.createFromHoursMinutesAndSeconds(14, 30, 45);
        lab2_3 t2 = TimeCreator.createFromHoursAndMinutes(15, 15);

        System.out.println("Time 1: " + t1);
        System.out.println("Time 2: " + t2);

        long diff = lab2_3.difference(t1, t2);
        System.out.println("Difference in seconds: " + diff);

        // Advance time by 3 seconds
        t1.inc().inc().inc();
        System.out.println("Time 1 after advancing by 3 seconds: " + t1);
    }
}
