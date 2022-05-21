package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "C:\\Users\\0032GZ744\\eclipse-workspace\\FST_Cucumber\\src\\test\\java\\features",
    glue = "stepDefinitions",
    tags = "@activity2",
    plugin = {"json: test-reports/json-report.json"},
    monochrome = true
)

public class ActivitiesRunner {
    //empty
}