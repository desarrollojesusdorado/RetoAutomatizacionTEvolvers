package tasks.demoblaze;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import util.ConstantsUtil;

public class OpenPage implements Task {

        public static OpenPage demoBlaze() {
        return Tasks.instrumented(OpenPage.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(ConstantsUtil.URL_BASE_DEMO_BLAZE));
    }
}
