package runners;

//import cucumber.api.CucumberOptions;
//import cucumber.api.SnippetType;
import io.cucumber.core.snippets.SnippetType;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/Automation_Test_Restful_Booker.feature",
        tags= "@Regresion",
        glue={"stepdefinitions", "util"},
        snippets= CAMELCASE
)
public class ServicesRestfulBookerRunner {
}
