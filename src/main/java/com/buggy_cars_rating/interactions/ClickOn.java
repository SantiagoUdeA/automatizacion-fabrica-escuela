package com.buggy_cars_rating.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actions.Click.on;

/*
 * Clase para hacer clic en cualquier elemento (reutilizable).
 */
public class ClickOn implements Interaction {

    private final Target target;

    public ClickOn(Target target) {
        this.target = target;
    }

    public static ClickOn element(Target target) {
        return instrumented(ClickOn.class, target);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(on(target));
    }
}
