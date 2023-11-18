package christmas.domain.calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateChecker {
    private LocalDate dateToCheck;

    public DateChecker(LocalDate dateToCheck) {
        this.dateToCheck = dateToCheck;
    }

    /**
     * 주어진 시작 및 종료 날짜 사이에 dateToCheck가 있는지 확인합니다.
     *
     * @param startDate 검사할 시작 날짜
     * @param endDate   검사할 종료 날짜
     *
     * @return dateToCheck가 startDate와 endDate 사이에 있으면 true, 아니면 false
     */
    public boolean isBetweenRange(LocalDate startDate, LocalDate endDate) {
        return (!dateToCheck.isBefore(startDate) && !dateToCheck.isAfter(endDate));
    }

    /**
     * dateToCheck가 평일인지 확인합니다.
     *
     * @return dateToCheck가 평일이면 true, 아니면 false
     */
    public boolean isWeekDay() {
        DayOfWeek week = dateToCheck.getDayOfWeek();
        return WeekDay.isWeekDate(week);
    }

    /**
     * dateToCheck가 평일인지 확인합니다.
     *
     * @return dateToCheck가 평일이면 true, 아니면 false
     */
    public boolean isSpecialDay() {
        return SpecialDay.isSpecialDay(dateToCheck);
    }
}
