package com.courier_sync.questions;

import com.courier_sync.user_interfaces.InvoicePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class InvoiceSuccessMessage implements Question<String> {

    public static InvoiceSuccessMessage text() {
        return new InvoiceSuccessMessage();
    }

    @Override
    public String answeredBy(Actor actor) {
        return InvoicePage.SUCCESS_MESSAGE.resolveFor(actor).getText();
    }
}

