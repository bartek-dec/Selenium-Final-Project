package task3;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/task3/",
        plugin = {"pretty", "html:out"})
public class FilterByPriceTest {
}
