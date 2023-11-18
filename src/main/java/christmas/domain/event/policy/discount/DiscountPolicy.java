package christmas.domain.event.policy.discount;

import christmas.dto.OrdersDto;
import java.time.LocalDate;

public interface DiscountPolicy {
    /**
     * 할인 금액을 계산합니다.
     *
     * @param ordersDto 주문 내역
     *
     * @return 주문 내역에 해당되는 할인 금액을 리턴
     */
    int calculateDiscountAmount(OrdersDto ordersDto);

    /**
     * 해당 날짜가 할인조건에 해당되는 날인지 체크합니다.
     *
     * @param date 주문 날짜
     *
     * @return 할인조건에 해당되는 날이면 true, 해당되지 않는 날이면 false
     */
    boolean isValidForCondition(LocalDate date);
}
