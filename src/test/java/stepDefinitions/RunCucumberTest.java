package stepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "summary", "junit:target/cucumber.xml", "html:target/cucumber-report.html"},
        features = "src/test/resources/features",
        glue = "stepDefinitions"
)
public class RunCucumberTest { }