package steps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.junit.Test;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/java/features/", format = {"pretty", "html:target/cucumber"})
public class RunCucumberTest {
}
