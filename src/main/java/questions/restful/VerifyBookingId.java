package questions.restful;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class VerifyBookingId implements Question<Boolean> {

    private String bookingId;
    private Boolean result;

    public static VerifyBookingId afterSendRequest() {
        return new VerifyBookingId();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        bookingId = SerenityRest.lastResponse().jsonPath().get("bookingid").toString();

        Serenity.recordReportData().withTitle("BookingID").andContents(bookingId);

        if (bookingId.isEmpty()){
            result=false;
        }
        else {
            result=true;
        }
        return result;
    }
}
