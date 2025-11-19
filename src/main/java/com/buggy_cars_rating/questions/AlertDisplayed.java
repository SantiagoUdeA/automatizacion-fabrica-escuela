package com.buggy_cars_rating.questions;

import com.buggy_cars_rating.user_interfaces.RegisterPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class AlertDisplayed implements Question<Boolean> {

    private final String expectedMessage;

    public AlertDisplayed(String expectedMessage) {
        this.expectedMessage = expectedMessage;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return RegisterPage.ALERT_MESSAGE.resolveFor(actor).getText().contains(expectedMessage);
    }

    public static AlertDisplayed withMessage(String message) {
        return new AlertDisplayed(message);
    }
}
