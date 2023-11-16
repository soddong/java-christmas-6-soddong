package christmas.controller;

import christmas.domain.event.Grade;
import christmas.domain.price.money.Money;

public class RateController {
    public Grade determineGrade(Money totalProfit) {
        return Grade.createFrom(totalProfit);
    }
}