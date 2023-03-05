package tasks.restful;

import io.restassured.http.ContentType;
import model.restful.Bookingdates;
import model.restful.DataCreateBooking;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import java.util.List;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static util.ConstantsUtil.*;


public class CreateBooking implements Task {

    DataCreateBooking dataCreateBooking = new DataCreateBooking();
    Bookingdates bookingdates = new Bookingdates();

    private List<List<String>> dataBooking;

    public CreateBooking(List<List<String>> dataBooking) {
        this.dataBooking = dataBooking;
    }

    public static CreateBooking withData(List<List<String>> dataBooking) {
        return Tasks.instrumented(CreateBooking.class, dataBooking);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        dataCreateBooking.withFirstname(dataBooking.get(1).get(0))
                .withLastname(dataBooking.get(1).get(1)).withTotalprice(parseInt(dataBooking.get(1).get(2)))
                    .withDepositpaid(parseBoolean(dataBooking.get(1).get(3))).withBookingdates(bookingdates
                        .withCheckin(dataBooking.get(1).get(4)).withCheckout(dataBooking.get(1).get(5))).withAdditionalneeds(dataBooking.get(1).get(6));

        actor.attemptsTo(Post.to(END_POINT_CREATEBOOKING)
                .with(request->request
                        .contentType(ContentType.JSON).body(dataCreateBooking)));

        lastResponse().prettyPrint();

        actor.remember(SAVE_BOOKING_ID, lastResponse().jsonPath().get(BOOKING_ID).toString());

    }
}
