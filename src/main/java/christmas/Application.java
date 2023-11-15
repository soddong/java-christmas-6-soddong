package christmas;

import christmas.domain.event.EventManager;
import christmas.domain.price.PriceCalculator;
import christmas.service.OrderMaker;
import christmas.view.InputView;
import christmas.controller.Controller;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Controller controller = new Controller(new InputView(), new OrderMaker(),
                new PriceCalculator(new EventManager()));
        controller.start();
    }
}
