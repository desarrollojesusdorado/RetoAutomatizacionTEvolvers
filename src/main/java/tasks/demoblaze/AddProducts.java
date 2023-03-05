package tasks.demoblaze;

import interactions.demoblaze.AlertTest;
import interactions.demoblaze.SearchProduct;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import java.util.List;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static userinterface.demoblaze.AddProductsPage.*;

public class AddProducts implements Task {

    private final List<List<String>> nameProducts;

    public AddProducts(List<List<String>> nameProducts) {
        this.nameProducts = nameProducts;
    }

    public static AddProducts toShoppingCart(List<List<String>> nameProducts) {
        return Tasks.instrumented(AddProducts.class, nameProducts);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<String> productsList = nameProducts.get(1);

        for (String s : productsList) {
            actor.attemptsTo(
                    SearchProduct.datosInteraccion(s),
                    AlertTest.interaction(ADD_TO_CART),
                    Click.on(HOME),
                    WaitUntil.the(OBJECT, isVisible()).forNoMoreThan(10).seconds()
            );
        }
    }
}
