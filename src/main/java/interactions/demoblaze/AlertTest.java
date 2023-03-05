package interactions.demoblaze;

import lombok.var;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static net.serenitybdd.core.Serenity.getDriver;

public class AlertTest implements Interaction {

    private Target button;

    public AlertTest(Target button) {
        this.button = button;
    }

    public static AlertTest interaction (Target button){
        return  new AlertTest(button);
    }

    @Override
    public void performAs(final Actor actor) {
        actor.attemptsTo(
                Click.on(button)
        );
        final var alert = new WebDriverWait(getDriver(), My.PATIENCE)
                .until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
    public interface My {
        Duration PATIENCE = Duration.ofSeconds(5l);
    }
}
