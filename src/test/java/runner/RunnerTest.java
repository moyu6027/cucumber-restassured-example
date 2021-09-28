package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
                "summary",
                "pretty"
        },
        features = "src/test/java/features/",
        glue = {"steps", "hooks"},
        tags = {"@SmokeTest"},
        snippets = SnippetType.CAMELCASE
)

public class RunnerTest {


}
