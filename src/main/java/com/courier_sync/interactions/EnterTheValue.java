package com.courier_sync.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/*
 * Clase para escribir en cualquier campo de texto (reutilizable).
 */
public class EnterTheValue implements Interaction {

    private final String value;
    private final Target field;

    public EnterTheValue(String value, Target field) {
        this.value = value;
        this.field = field;
    }

    public static EnterTheValue into(Target field, String value) {
        return instrumented(EnterTheValue.class, value, field);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        net.serenitybdd.screenplay.actions.Enter.theValue(value).into(field).performAs(actor);
    }
}
