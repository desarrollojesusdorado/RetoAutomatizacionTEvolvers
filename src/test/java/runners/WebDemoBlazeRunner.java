package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/Automation_Web_Demo_Blaze.feature",
        tags= "@Cp01",
        glue={"stepdefinitions", "util", "model/demoblaze"},
        snippets= CAMELCASE
)
public class WebDemoBlazeRunner {
}
