package com.buggy_cars_rating.tasks;

import com.buggy_cars_rating.interactions.EnterTheValue;
import com.buggy_cars_rating.user_interfaces.RegisterPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/*
 * Tarea para ingresar solo la contraseña y su confirmación en el formulario de registro.
 * Util para la definición del Scenario Outline
 */
public class EnterOnlyPassword implements Task {

    private final String password;

    public EnterOnlyPassword(String password) {
        this.password = password;
    }

    public static EnterOnlyPassword with(String password) {
        return instrumented(EnterOnlyPassword.class, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                EnterTheValue.into(RegisterPage.PASSWORD_INPUT, password),
                EnterTheValue.into(RegisterPage.CONFIRM_PASSWORD_INPUT, password)
        );
    }
}
