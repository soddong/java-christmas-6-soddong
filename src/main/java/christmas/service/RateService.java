package christmas.service;

import christmas.domain.event.Grade;
import christmas.domain.price.money.Money;

public class RateService {
    public Grade determineGrade(Money totalProfit) {
        return Grade.createFrom(totalProfit);
    }
}