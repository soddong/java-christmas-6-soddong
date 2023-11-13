package christmas.domain.calendar;

import java.time.LocalDate;

public enum SpecialDay {
    DECEMBER_3RD(2023, 12, 3),
    DECEMBER_10TH(2023, 12, 10),
    DECEMBER_17TH(2023, 12, 17),
    DECEMBER_24TH(2023, 12, 24),
    CHRISTMAS_DAY(2023, 12, 25),
    NEW_YEARS_EVE(2023, 12, 31);

    private final LocalDate date;

    SpecialDay(int year, int month, int day) {
        this.date = LocalDate.of(year, month, day);
    }

    public LocalDate getDate() {
        return date;
    }

    public static boolean isSpecialDay(LocalDate date) {
        for (SpecialDay specialDay : SpecialDay.values()) {
            if (specialDay.getDate().equals(date)) {
                return true;
            }
        }
        return false;
    }
}