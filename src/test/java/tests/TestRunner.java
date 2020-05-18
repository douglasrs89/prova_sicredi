package tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = { "src/test/java/features"},
    glue = "steps",
    format = {"pretty", "json:target/cucumber.json", "html:target/cucumber-report"},
    tags = "@sicredi"
)

public class TestRunner {
}
