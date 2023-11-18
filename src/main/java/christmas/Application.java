package christmas;

import christmas.controller.ReservationController;
import christmas.domain.event.policy.PolicyManager;
import christmas.domain.order.OrdersMaker;
import christmas.service.EventService;
import christmas.service.OrderService;
import christmas.service.PriceService;
import christmas.service.RateService;
import christmas.view.InputManager;

public class Application {
    public static void main(String[] args) {

        OrderService orderService = new OrderService(new InputManager(), new OrdersMaker());
        EventService eventService = new EventService(new PolicyManager());
        PriceService priceService = new PriceService();
        RateService rateService = new RateService();

        ReservationController reservationController = new ReservationController(
                orderService, eventService, priceService, rateService
        );

        reservationController.reserve();
    }
}
