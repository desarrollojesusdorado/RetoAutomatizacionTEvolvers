package questions.demoblaze;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static util.ConstantsUtil.SAVE_TOTAL_PRICE;

public class CheckTotal implements Question<String> {

    public static CheckTotal ofPurchase() {
        return new CheckTotal();
    }

    @Override
    public String answeredBy(Actor actor) {
        return actor.recall(SAVE_TOTAL_PRICE);
    }
}
