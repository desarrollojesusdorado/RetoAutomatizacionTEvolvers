package tasks.demoblaze;

import model.demoblaze.DataInfoClient;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static userinterface.demoblaze.CartPage.*;

import static userinterface.demoblaze.AddProductsPage.CART;
import static util.ConstantsUtil.SAVE_TOTAL_PRICE;

public class CompletePurchase implements Task {

    private DataInfoClient dataInfoClient;

    public CompletePurchase(DataInfoClient dataInfoClient) {
        this.dataInfoClient = dataInfoClient;
    }

    public static CompletePurchase client(DataInfoClient dataInfoClient) {
        return Tasks.instrumented(CompletePurchase.class, dataInfoClient);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Click.on(CART));
        actor.attemptsTo(WaitUntil.the(TOTAL_PRICE,isVisible()));
        String priceTotal = Text.of(TOTAL_PRICE).answeredBy(actor).trim();
        actor.remember(SAVE_TOTAL_PRICE, priceTotal);
        actor.attemptsTo(
                Click.on(PLACE_ORDER),
                Enter.theValue(dataInfoClient.getName()).into(NAME),
                Enter.theValue(dataInfoClient.getCountry()).into(COUNTRY),
                Enter.theValue(dataInfoClient.getCity()).into(CITY),
                Enter.theValue(dataInfoClient.getCreditCard()).into(CREDIT_CARD),
                Enter.theValue(dataInfoClient.getMonth()).into(MONTH),
                Enter.theValue(dataInfoClient.getYear()).into(YEAR),
                Click.on(PURCHASE)
                );
    }
}
