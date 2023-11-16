package christmas;

import christmas.controller.EventController;
import christmas.controller.OrderController;
import christmas.controller.PriceController;
import christmas.controller.RateController;
import christmas.domain.event.policy.PolicyManager;
import christmas.domain.order.OrderMaker;
import christmas.domain.price.PriceCalculator;
import christmas.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OrderMaker orderMaker = new OrderMaker();
        PriceCalculator priceCalculator = new PriceCalculator(new PolicyManager());

        OrderController orderController = new OrderController(inputView, orderMaker);
        EventController eventController = new EventController(priceCalculator);
        PriceController priceController = new PriceController(priceCalculator);
        RateController rateController = new RateController();

        ReservationProcessor reservationProcessor = new ReservationProcessor(
                orderController, eventController, priceController, rateController
        );

        reservationProcessor.start();
    }
}
