import java.time.Duration;

public class MyClass {

    public static void main(String[] args) {
        Duration duration = Duration.parse("PT10M14.230852287S");
        System.out.println("Duration   : " + duration);
        System.out.println("Days       : " + duration.toDays());
        System.out.println("Hours      : " + duration.toHours());
        System.out.println("Minutes    : " + duration.toMinutes());
        System.out.println("Millis     : " + duration.toMillis());
        System.out.println("Nanos      : " + duration.toNanos());       
        System.out.println("DaysPart   : " + duration.toDaysPart());
        System.out.println("HoursPart  : " + duration.toHoursPart());
        System.out.println("MillisPart : " + duration.toMillisPart());
        System.out.println("MinutesPart: " + duration.toMinutesPart());
        System.out.println("Seconds    : " + duration.toSeconds());
        System.out.println("SecondsPart: " + duration.toSecondsPart());
        System.out.println("NanosPart  : " + duration.toNanosPart());       
    }

}