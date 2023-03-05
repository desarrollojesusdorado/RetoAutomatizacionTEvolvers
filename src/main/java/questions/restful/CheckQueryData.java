package questions.restful;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class CheckQueryData implements Question<Boolean> {

    private final List<List<String>> getDataBooking;

    public CheckQueryData(List<List<String>> getDataBooking) {
        this.getDataBooking = getDataBooking;
    }

    public static CheckQueryData response(List<List<String>> getDataBooking) {
        return new CheckQueryData(getDataBooking);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        return verifyDataUsers() && verifyBookingDates();
    }

    private boolean verifyDataUsers(){

        String firstname = lastResponse().jsonPath().get("firstname").toString();
        String lastname = lastResponse().jsonPath().get("lastname").toString();
        String totalprice = lastResponse().jsonPath().get("totalprice").toString();

        return getDataBooking.get(1).get(0).equals(firstname)
                && getDataBooking.get(1).get(1).equals(lastname)
                && getDataBooking.get(1).get(2).equals(totalprice);
    }

    private boolean verifyBookingDates(){
        String checkin = lastResponse().jsonPath().get("bookingdates.checkin").toString();
        String checkout = lastResponse().jsonPath().get("bookingdates.checkout").toString();
        return  getDataBooking.get(1).get(4).equals(checkin)
                && getDataBooking.get(1).get(5).equals(checkout);
    }
}
