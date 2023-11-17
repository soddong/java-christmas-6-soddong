package christmas.dto;

import java.time.LocalDate;
import java.util.List;

public record OrdersDto(List<ItemDto> orders, LocalDate date) {
}
