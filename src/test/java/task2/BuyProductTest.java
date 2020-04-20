package task2;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/task2/",
        plugin = {"pretty", "html:out"})
public class BuyProductTest {
}
