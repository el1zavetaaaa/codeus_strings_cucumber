package thursday;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"features"},
        glue = {"thursday/steps"},
        plugin = {"pretty", "html:target/cucumber-reports"},
        dryRun = true
)
public class TestRunner {
}
