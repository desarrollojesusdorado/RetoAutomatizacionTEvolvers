package questions.restful;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class VerifyStatusCode implements Question<Integer> {

    public static VerifyStatusCode afterSendRequest() {
        return new VerifyStatusCode();
    }

    @Override
    public Integer answeredBy(Actor actor) {

        int statusCode = SerenityRest.lastResponse().statusCode();

        Serenity.recordReportData().withTitle("Status Code").andContents(String.valueOf(statusCode));

        return statusCode;
    }
}
