package com.buggy_cars_rating.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.page.TheWebPage;

public class Validate implements Question<Boolean> {

    private final String expectedUrl;

    public Validate(String expectedUrl) {
        this.expectedUrl = expectedUrl;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String currentUrl = TheWebPage.currentUrl().answeredBy(actor);
        return currentUrl.contains(expectedUrl);
    }

    public static Validate thePageUrl(String url) {
        return new Validate(url);
    }
}
