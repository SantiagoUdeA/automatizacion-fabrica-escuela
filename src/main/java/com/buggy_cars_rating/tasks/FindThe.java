package com.buggy_cars_rating.tasks;

import com.buggy_cars_rating.interactions.EnterThe;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class FindThe implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(EnterThe.wordToSearch());
    }

    public static FindThe keyword() {
        return Tasks.instrumented(FindThe.class);
    }
}
