package com.courier_sync.stepdefinitions;

import com.courier_sync.models.User;
import com.courier_sync.questions.InvoiceSuccessMessage;
import com.courier_sync.tasks.SignIn;
import com.courier_sync.tasks.UpdateInvoice;
import com.courier_sync.user_interfaces.DashboardPage;
import com.courier_sync.utils.Wait;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.ClearCookiesPolicy;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class InvoiceEditStepDefinitions {

    public Actor user;

    @Managed(driver = "chrome", uniqueSession = true, clearCookies = ClearCookiesPolicy.BeforeEachTest)
    public WebDriver theDriver;

    @Before
    public void config() {
        user = Actor.named("Usuario");
        user.can(BrowseTheWeb.with(theDriver));
    }

    @Given("I have an invoice in Draft status")
    public void iHaveAnInvoiceInStatus() {
        user.attemptsTo(SignIn.with(User.valid()));
        Wait.fiveSeconds();
    }

    @When("I update the invoice details")
    public void iUpdateTheInvoiceDetails() {
        user.attemptsTo(UpdateInvoice.withRandomInvoiceDetails());
        Wait.twoSeconds();
    }

    @Then("I should see a message {string}")
    public void iShouldSeeTheMessage(String expectedMessage) {
        user.should(seeThat(InvoiceSuccessMessage.text(), containsString(expectedMessage)));
        Wait.twoSeconds();
    }
}

