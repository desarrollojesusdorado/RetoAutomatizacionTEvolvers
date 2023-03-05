package questions.demoblaze;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static userinterface.demoblaze.CartPage.MESSAGE;

public class VerifyMessage implements Question<String> {

    public static VerifyMessage expected() {
        return new VerifyMessage();
    }

    @Override
    public String answeredBy(Actor actor) {
        return actor.asksFor(Text.of(MESSAGE).asString());
    }
}
