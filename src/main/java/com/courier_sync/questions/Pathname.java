package com.courier_sync.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.core.Serenity.getWebdriverManager;

public class Pathname implements Question<Boolean> {

    private final String expectedPathname;

    public Pathname(String expectedPathname) {
        this.expectedPathname = expectedPathname;
    }

    public static Pathname isEqualTo(String expectedPathname) {
        return new Pathname(expectedPathname);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String actualPathname = getWebdriverManager()
                .getCurrentDriver()
                .getCurrentUrl();
        java.net.URI uri;
        try {
            if(actualPathname == null) {
                return false;
            }
            uri = new java.net.URI(actualPathname);
        } catch (java.net.URISyntaxException e) {
            return false;
        }
        return uri.getPath().equals(expectedPathname);
    }
}
