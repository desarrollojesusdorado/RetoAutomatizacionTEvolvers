package interactions.demoblaze;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

import static userinterface.demoblaze.AddProductsPage.*;

public class SearchProduct implements Interaction {

        private final String datoClave;

    public SearchProduct(String datoClave) {
        this.datoClave = datoClave;
    }

    public static SearchProduct datosInteraccion (String datoClave){
        return  new SearchProduct(datoClave);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<String> datos = actor.asksFor(Text.ofEach(PRODCUTS).asListOf(String.class));
        int tamano = datos.size();
        for (int i=0; i<=tamano; i++){
            if (datoClave.equals(datos.get(i))){
                 PARAMETER_PRODCUTS.of(datos.get(i)).resolveFor(actor).click();
                break;
            }
        }
    }
}
