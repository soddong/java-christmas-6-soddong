package christmas.dto;

import java.time.LocalDate;
import java.util.List;

public record OrdersDto(List<Item> orders, LocalDate date) {
}
