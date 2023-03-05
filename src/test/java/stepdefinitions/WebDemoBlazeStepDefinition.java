package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.demoblaze.DataInfoClient;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import questions.demoblaze.CheckTotal;
import questions.demoblaze.VerifyMessage;
import tasks.demoblaze.AddProducts;
import tasks.demoblaze.CompletePurchase;
import tasks.demoblaze.OpenPage;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class WebDemoBlazeStepDefinition {

    @Managed
    WebDriver driver;

    @Given("^(.*) wants to enter the blaze demo site$")
    public void jesusWantsToEnterTheBlazeDemoSite(String actor) {
        theActorCalled(actor).whoCan(BrowseTheWeb.with(driver));
        theActorCalled(actor).wasAbleTo(OpenPage.demoBlaze());
    }
    @When("he adds several products to the shopping cart")
    public void heAddsSeveralProductsToTheShoppingCart(DataTable nameProducts) {
        theActorInTheSpotlight().attemptsTo(AddProducts.toShoppingCart(nameProducts.cells()));

    }

    @And("the complete purchase")
    public void theCompletePurchase(List<DataInfoClient> dataClient) {
            theActorInTheSpotlight().attemptsTo(CompletePurchase.client(dataClient.get(0)));
    }

    @Then("the verifies that the total value is {string}")
    public void theVerifiesThatTheTotalValueIs(String totalPrice) {
        theActorInTheSpotlight().should(seeThat(CheckTotal.ofPurchase(), equalTo(totalPrice)));
    }

    @And("verify the message {string}")
    public void verifyTheMessage(String messageExpected) {
        theActorInTheSpotlight().should(seeThat(VerifyMessage.expected(), equalTo(messageExpected)));
    }
}
