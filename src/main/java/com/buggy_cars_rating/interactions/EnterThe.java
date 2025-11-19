package com.buggy_cars_rating.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import com.buggy_cars_rating.user_interfaces.GooglePage;
import com.buggy_cars_rating.utils.WaitTime;

public class EnterThe implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        // type U de A word
        // Enter
        // Click on the U de A link
        actor.attemptsTo(Enter.theValue("U de A").into(GooglePage.INPUT_TEXT));
        actor.attemptsTo(Enter.keyValues(Keys.ENTER).into(GooglePage.INPUT_TEXT));
        WaitTime.waitForSeconds(10);
        actor.attemptsTo(Click.on(GooglePage.UDEALINK));

    }

    public static EnterThe wordToSearch() {
        return Tasks.instrumented(EnterThe.class);
    }
}
