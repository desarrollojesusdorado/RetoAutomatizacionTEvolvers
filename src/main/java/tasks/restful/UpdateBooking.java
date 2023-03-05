package tasks.restful;

import io.restassured.http.ContentType;
import model.restful.Bookingdates;
import model.restful.DataCreateBooking;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;
import java.util.List;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static util.ConstantsUtil.END_POINT_UPDATEBOOKING;
import static util.ConstantsUtil.SAVE_TOKEN;

public class UpdateBooking implements Task {

    DataCreateBooking updateBooking = new DataCreateBooking();

    Bookingdates updateBookingdates = new Bookingdates();

    private final List<List<String>> dataUpdateBooking;
    private final Integer bookingId;
    private String token;

    public UpdateBooking(List<List<String>> dataUpdateBooking, Integer bookingId) {
        this.dataUpdateBooking = dataUpdateBooking;
        this.bookingId = bookingId;
    }

    public static UpdateBooking forUpdateBooking(List<List<String>> dataUpdateBooking, Integer bookingId) {
        return Tasks.instrumented(UpdateBooking.class, dataUpdateBooking, bookingId);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        token = actor.recall(SAVE_TOKEN);

        updateBooking.withFirstname(dataUpdateBooking.get(1).get(0))
                .withLastname(dataUpdateBooking.get(1).get(1))
                    .withTotalprice(parseInt(dataUpdateBooking.get(1).get(2)))
                        .withDepositpaid(parseBoolean(dataUpdateBooking.get(1).get(3)))
                                .withBookingdates(updateBookingdates
                                    .withCheckin(dataUpdateBooking.get(1).get(4))
                                        .withCheckout(dataUpdateBooking.get(1).get(5)))
                                            .withAdditionalneeds(dataUpdateBooking.get(1).get(6));


        actor.attemptsTo(Put.to(END_POINT_UPDATEBOOKING)
                .with(request->request.contentType(ContentType.JSON)
                        //.cookie("token="+token)
                        .header("Cookie","token="+token)
                        .pathParam("id", bookingId)
                        .body(updateBooking)
                ));

        lastResponse().prettyPrint();

    }
}
