package task1;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/task1/deleteNewAddress.feature",
        plugin = {"pretty", "html:out"})
public class DeleteNewAddressTest {
}
