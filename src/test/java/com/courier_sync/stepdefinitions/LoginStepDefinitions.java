package com.courier_sync.stepdefinitions;

import com.courier_sync.models.User;
import com.courier_sync.questions.Pathname;
import com.courier_sync.questions.TargetHasMessage;
import com.courier_sync.tasks.FillLoginForm;
import com.courier_sync.tasks.OpenThe;
import com.courier_sync.user_interfaces.LoginPage;
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

import static com.courier_sync.models.Route.PANEL_PAGE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class LoginStepDefinitions {

    private final User userModel = User.fromEnvironment();
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

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        user.attemptsTo(OpenThe.navigator(new LoginPage()));
        Wait.twoSeconds();
    }

    @When("I login with valid credentials")
    public void iLoginWithValidCredentials() {
        user.attemptsTo(FillLoginForm.withData(userModel.getEmail(), userModel.getPassword()));
        Wait.fiveSeconds();
    }

    @Then("I should be redirected to the main panel page")
    public void iShouldBeRedirectedToTheApplicationSMainPage() {
        user.should(seeThat(Pathname.isEqualTo(PANEL_PAGE)));
        Wait.fiveSeconds();
    }

    @When("I try to login with invalid credentials")
    public void iTryToLoginWithInvalidCredentials() {
        user.attemptsTo(FillLoginForm.withData("invalid@gmail.com", "invalid"));
        Wait.twoSeconds();
    }

    @Then("I should see the message {string}")
    public void iShouldSeeTheMessage(String message) {
        user.should(seeThat(TargetHasMessage.equalTo(message, LoginPage.ERROR_MESSAGE)));
        Wait.fiveSeconds();
    }
}
