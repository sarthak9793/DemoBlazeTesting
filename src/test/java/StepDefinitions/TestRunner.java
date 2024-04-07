package StepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
/*features = "" provide the location of the feature files, glue = "" provides the locations of the stepDefinitions or glue
monochrome = true, formats output on console

//To generate reports
    plugin = { "pretty", "html:target/reports"}
    plugin = { "pretty", "json:target/reports/cucumber.json"}
    plugin = { "pretty", "junit:target/reports/cucumber.xml"}
*/
@CucumberOptions(features = "src/test/resources/Features", glue = {"StepDefinitions", "utilities"},
        monochrome = true,
        tags = "not @ignore",
        plugin = {
        "pretty",
        "json:target/cucumber-report/cucumber.json",
        "html:target/cucumber-report/cucumber.html"}
)
public class TestRunner {
}
