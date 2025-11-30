package com.courier_sync.tasks;

import com.courier_sync.models.Invoice;
import com.courier_sync.models.User;
import com.courier_sync.user_interfaces.DashboardPage;
import com.courier_sync.user_interfaces.InvoicePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/**
 * Tarea para actualizar los detalles de una factura
 */
public class UpdateInvoice implements Task {

    private final Invoice invoice;

    public UpdateInvoice(Invoice invoice) {
        this.invoice = invoice;
    }


    public static UpdateInvoice withRandomInvoiceDetails() {
        return instrumented(UpdateInvoice.class, Invoice.random());
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(DashboardPage.EDIT_INVOICE),
                Enter.theValue("20,12,2026").into(InvoicePage.EXPIRATION_DATE_INPUT),
                Enter.theValue("20,12,2026").into(InvoicePage.EMISSION_DATE_INPUT),
                Click.on(InvoicePage.SAVE_CHANGES_BUTTON),
                WaitUntil.the(InvoicePage.SUCCESS_MESSAGE, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}

