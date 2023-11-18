package christmas.domain.calendar;

import java.time.DayOfWeek;
import java.util.stream.Stream;

public enum WeekDay {
    MONDAY(DayOfWeek.MONDAY),
    TUESDAY(DayOfWeek.TUESDAY),
    WEDNESDAY(DayOfWeek.WEDNESDAY),
    THURSDAY(DayOfWeek.THURSDAY),
    SUNDAY(DayOfWeek.SUNDAY);

    private final DayOfWeek dayOfWeek;

    WeekDay(final DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public static boolean isWeekDate(DayOfWeek day) {
        return Stream.of(WeekDay.values())
                .anyMatch(weekDay -> day.equals(weekDay.dayOfWeek));
    }
}

