package tasks.restful;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static util.ConstantsUtil.*;

public class GetBooking implements Task {

    private String bookingId;

    public static GetBooking toVerifyRegistration() {
        return Tasks.instrumented(GetBooking.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        bookingId = actor.recall(SAVE_BOOKING_ID);

        actor.attemptsTo(Get.resource(END_POINT_GETBOOKING)
                .with(request->request.contentType(ContentType.JSON)
                        .pathParam("id", bookingId)));

        lastResponse().prettyPrint();

    }
}
