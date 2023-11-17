package christmas;

import christmas.controller.ReservationController;
import christmas.domain.event.policy.PolicyManager;
import christmas.domain.order.OrderMaker;
import christmas.domain.price.PriceCalculator;
import christmas.service.EventService;
import christmas.service.OrderService;
import christmas.service.PriceService;
import christmas.service.RateService;
import christmas.view.InputManager;

public class Application {
    public static void main(String[] args) {

        OrderService orderService = new OrderService(new InputManager(), new OrderMaker());
        EventService eventService = new EventService(new PriceCalculator(), new PolicyManager());
        PriceService priceService = new PriceService(new PriceCalculator());
        RateService rateService = new RateService();

        ReservationController reservationController = new ReservationController(
                orderService, eventService, priceService, rateService
        );

        reservationController.reserve();
    }
}
