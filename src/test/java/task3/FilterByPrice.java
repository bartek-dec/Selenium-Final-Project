package task3;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AllProductsPage;
import pages.BaseClass;
import pages.MainPage;

import java.util.List;

public class FilterByPrice extends BaseClass {

    private MainPage mainPage;
    private AllProductsPage allProductsPage;

    @Given("user is on main page")
    public void goToMainPage() {
        setUp();
        goToMain();
    }

    @When("user goes to all products page")
    public void goToAllProducts() {
        mainPage = new MainPage(driver);

        mainPage.goToAllProducts();
    }

    @And("user chooses USD currency")
    public void selectCurrency() {
        allProductsPage = new AllProductsPage(driver);

        allProductsPage.selectUSD();
    }

    @And("user selects price range between (.*) and (.*)")
    public void selectPrice(String lower, String upper) {
        allProductsPage.selectPriceRange(lower, upper);
    }

    @Then("all filtered products within price range (.*) and (.*)")
    public void checkPriceOfFilteredProducts(String lower, String upper) {
        List<WebElement> filteredProducts = allProductsPage.selectFilteredProducts();
        double lowerPrice = Double.parseDouble(lower);
        double upperPrice = Double.parseDouble(upper);

        for (WebElement product : filteredProducts) {
            double productPrice = convertNumber(product.findElement(By.className("price")).getText());

            if (productPrice < lowerPrice) {
                Assert.fail();
            }

            if (productPrice > upperPrice) {
                Assert.fail();
            }
        }
    }

    @And("user quits website")
    public void tearDown() {
        driver.close();
    }

    private double convertNumber(String s) {
        String stringNumber = s.substring(1);
        return Double.parseDouble(stringNumber);
    }
}
