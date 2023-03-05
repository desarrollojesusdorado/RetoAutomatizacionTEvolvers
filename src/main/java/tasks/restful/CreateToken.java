package tasks.restful;

import io.restassured.http.ContentType;
import model.restful.DataGetToken;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static util.ConstantsUtil.END_POINT_CREATETOKEN;
import static util.ConstantsUtil.SAVE_TOKEN;

public class CreateToken implements Task {

    DataGetToken dataGetToken = new DataGetToken();

    private String user;
    private String pass;

    public CreateToken(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public static CreateToken forOtherServices(String user, String pass) {
        return Tasks.instrumented(CreateToken.class, user,pass);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        dataGetToken.withUsername(user).withPassword(pass);

        actor.attemptsTo(Post.to(END_POINT_CREATETOKEN)
                .with(request->request.contentType(ContentType.JSON)
                        .body(dataGetToken)));

        actor.remember(SAVE_TOKEN, lastResponse().jsonPath().get("token").toString());

        lastResponse().prettyPrint();

    }
}
