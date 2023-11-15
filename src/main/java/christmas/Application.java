package christmas;

import christmas.domain.event.policy.PolicyManager;
import christmas.domain.price.PriceCalculator;
import christmas.domain.order.OrderMaker;
import christmas.view.InputView;
import christmas.controller.EventController;

public class Application {
    public static void main(String[] args) {
        EventController controller = new EventController(new InputView(), new OrderMaker(),
                new PriceCalculator(new PolicyManager()));
        controller.start();
    }
}
