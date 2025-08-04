package com.alexhedley

//import java.time.Duration;
import kotlin.time.Duration;

class DurationParser {
    fun parse(durationString: String) {
//        val duration = Duration.parse("PT10M14.230852287S");
        val duration = Duration.parse(durationString);

        println("Duration   : " + duration);
        println("Days       : " + duration.inWholeDays);
        println("Hours      : " + duration.inWholeHours);
        println("Minutes    : " + duration.inWholeMinutes);
        println("Millis     : " + duration.inWholeMilliseconds);
        println("Nanos      : " + duration.inWholeNanoseconds);
//        println("DaysPart   : " + duration.toDaysPart());
//        println("HoursPart  : " + duration.toHoursPart());
//        println("MillisPart : " + duration.toMillisPart());
//        println("MinutesPart: " + duration.toMinutesPart());
        println("Seconds    : " + duration.inWholeSeconds);
//        println("SecondsPart: " + duration.toSecondsPart());
//        println("NanosPart  : " + duration.toNanosPart());
    }
}