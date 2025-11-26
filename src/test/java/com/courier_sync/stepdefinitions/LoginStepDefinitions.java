package com.courier_sync.stepdefinitions;

import com.courier_sync.models.User;
import com.courier_sync.questions.Dashboard;
import com.courier_sync.questions.ErrorMessageDisplayed;
import com.courier_sync.tasks.SignIn;
import com.courier_sync.utils.Wait;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.ClearCookiesPolicy;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginStepDefinitions {

    private User model;
    public Actor user;

    @Managed(driver = "chrome", uniqueSession = true, clearCookies = ClearCookiesPolicy.BeforeEachTest)
    public WebDriver theDriver;

    @Before
    public void config() {
        user = Actor.named("Usuario");
        user.can(BrowseTheWeb.with(theDriver));
    }

    @After
    public void cleanUp() {
        // Limpiar cookies y cerrar el navegador después de cada escenario
        // para evitar sesiones previas
        theDriver.manage().deleteAllCookies();
        theDriver.quit();
    }


    @Given("I provide valid authentication credentials")
    public void iProvideValidAuthenticationDetails() {
        model = User.valid();
    }

    @When("I attempt to sign in")
    public void theyAttemptToSignIn() {
        user.attemptsTo(SignIn.with(model));
        Wait.twoSeconds();
    }

    @Then("I should gain access to the application")
    public void iShouldGainAccessToTheApplication() {
        user.should(seeThat(Dashboard.isDisplayed()));
        Wait.twoSeconds();
    }

    @Given("I provide invalid authentication credentials")
    public void iProvideInvalidAuthentication() {
        model = User.invalid();
    }

    @Then("I should see the message {string}")
    public void theyShouldBeInformedThatTheAuthenticationDetailsAreIncorrect(String message) {
        Wait.forMilliseconds(100);
        user.should(seeThat(ErrorMessageDisplayed.text(), equalTo(message)));
        Wait.twoSeconds();
    }
}
