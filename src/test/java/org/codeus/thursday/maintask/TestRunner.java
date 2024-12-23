package org.codeus.thursday.maintask;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"features"},
        glue = {"org/codeus/thursday/maintask/steps"},
        plugin = {"pretty", "html:target/cucumber-reports"},
        dryRun = false
)
public class TestRunner {
}
