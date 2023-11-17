package christmas.domain.event.policy.gift;

import christmas.dto.Item;
import christmas.dto.OrdersDto;
import java.util.Optional;

public interface GiftPolicy {
    /**
     * 해당되는 증정품을 제공합니다.
     *
     * @param ordersDto 주문 내역
     *
     * @return 주문 내역에 해당되는 증정품을 리턴
     */
    Optional<Item> receiveGift(OrdersDto ordersDto);

    /**
     * 증정품을 받을수 있는 조건에 충족하는지 확인합니다.
     *
     * @param ordersDto 주문 내역
     *
     * @return 조건에 충족하면 true, 충족하지 않으면 false
     */
    boolean isValidForCondition(OrdersDto ordersDto);
}
