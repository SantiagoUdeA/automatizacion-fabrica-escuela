package com.buggy_cars_rating.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenRegisterPage implements Interaction {

    private final String url;

    public OpenRegisterPage(String url) {
        this.url = url;
    }

    public static OpenRegisterPage at(String url) {
        return instrumented(OpenRegisterPage.class, url);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(url)
        );
    }
}
