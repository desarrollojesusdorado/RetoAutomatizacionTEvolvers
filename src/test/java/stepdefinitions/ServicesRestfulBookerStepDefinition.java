package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasLength;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import questions.restful.CheckQueryData;
import questions.restful.VerifyBookingId;
import questions.restful.VerifyStatusCode;
import tasks.restful.CreateBooking;
import tasks.restful.CreateToken;
import tasks.restful.GetBooking;
import tasks.restful.UpdateBooking;

public class ServicesRestfulBookerStepDefinition {

    private EnvironmentVariables environmentVariables;

    @Given("^that (.*) requires to consume a service$")
    public void thatJesusRequiresToConsumeAService(String actor) {
        String urlBaseService = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("url.restful");
        theActorCalled(actor).whoCan(CallAnApi.at(urlBaseService));
    }

    @When("^he performs the creation of a reservation$")
    public void hePerformsTheCreationOfAReservation(DataTable dataBooking){
        theActorInTheSpotlight().attemptsTo(CreateBooking.withData(dataBooking.cells()));
    }

    @And("^verify bookingid and (.*)$")
    public void verifyBookingidAndStatuscode(int statusCode) {
        theActorInTheSpotlight().should(seeThat(VerifyBookingId.afterSendRequest(), equalTo(true)));
        theActorInTheSpotlight().should(seeThat(VerifyStatusCode.afterSendRequest(), equalTo(statusCode)));
    }

    @And("^the Query the registered reservation$")
    public void theQueryTheRegisteredReservation() {
        theActorInTheSpotlight().attemptsTo(GetBooking.toVerifyRegistration());
    }

    @And("^he verifies that the consulted data vs the registered data$")
    public void heVerifiesThatTheConsultedDataVsTheRegisteredData(DataTable getDataBooking) {
        theActorInTheSpotlight().should(seeThat(CheckQueryData.response(getDataBooking.cells()), equalTo(true)));
    }

    @When("^the generates token with (.*) and (.*)$")
    public void theGeneratesTokenWithUsernameAndPassword(String user, String pass) {
        theActorInTheSpotlight().attemptsTo(CreateToken.forOtherServices(user,pass));
        theActorInTheSpotlight().should(seeThatResponse("The service responded correctly",
                response->response.statusCode(200)),
                seeThatResponse("The token was generated correctly",
                        response->response.body("token", hasLength(15))));
    }

    @When("updates the reservation with {int}")
    public void updatesTheReservation(Integer bookingId, DataTable dataUpdateBooking) {
        theActorInTheSpotlight().attemptsTo(UpdateBooking.forUpdateBooking(dataUpdateBooking.cells(), bookingId));
    }

    @Then("^he verifies that the data is updated correctly$")
    public void heVerifiesThatTheDataIsUpdatedCorrectly(DataTable getDataBooking) {
        theActorInTheSpotlight().should(seeThat(CheckQueryData.response(getDataBooking.cells()), equalTo(true)));
    }
}
