package com.courier_sync.tasks;

import com.courier_sync.interactions.ClickOn;
import com.courier_sync.interactions.EnterTheValue;
import com.courier_sync.user_interfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/*
* Tarea para llenar el formulario de inicio de sesión y enviarlo.
*/
public class FillLoginForm implements Task {

    private final String email;
    private final String password;

    public FillLoginForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static FillLoginForm withData(String username, String password) {
        return instrumented(FillLoginForm.class, username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EnterTheValue.into(LoginPage.EMAIL_INPUT, email),
                EnterTheValue.into(LoginPage.PASSWORD_INPUT, password),
                ClickOn.element(LoginPage.SUBMIT_BUTTON)
        );
    }

}
