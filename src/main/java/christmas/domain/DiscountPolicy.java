package christmas.domain;

import java.time.LocalDate;
import java.util.Date;

public interface DiscountPolicy {
    int calculateDiscountAmount(Orders orders);
    boolean isValidForCondition(LocalDate date);
}
