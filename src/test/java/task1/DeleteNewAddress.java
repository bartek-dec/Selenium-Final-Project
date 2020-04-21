package task1;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AccountPage;
import pages.AddressesPage;
import pages.LoginPage;
import pages.NewAddressPage;

import java.util.concurrent.TimeUnit;

public class DeleteNewAddress {

    private WebDriver driver;

    private LoginPage loginPage;
    private AccountPage accountPage;
    private AddressesPage addressesPage;
    private NewAddressPage newAddressPage;

    @Given("user logged in to account having first address already defined")
    public void logInToAccount() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");

        loginPage = new LoginPage(driver);
        loginPage.enterCredentials();
        loginPage.signIn();
    }

    @And("user creates another address")
    public void createNewAddress() {
        accountPage = new AccountPage(driver);
        accountPage.getIntoAddresses();

        addressesPage = new AddressesPage(driver);
        addressesPage.getIntoNewAddress();

        newAddressPage = new NewAddressPage(driver);

        newAddressPage.setAliasInput("Johny");
        newAddressPage.setAddressInput("Address 3");
        newAddressPage.setCityInput("Gdansk");
        newAddressPage.setPostCodeInput("98765");
        newAddressPage.setCountryInput("United Kingdom");
        newAddressPage.setPhoneInput("880012390");

        newAddressPage.saveForm();
    }

    @When("user deletes recent address")
    public void deleteRecentAddress() {
        addressesPage.deleteRecentAddress();
    }

    @Then("alert showing (.*) appears")
    public void checkAlert(String alert) {
        Assert.assertTrue(addressesPage.getAlert().isDisplayed());
        Assert.assertTrue(addressesPage.getAlert().getText().contains(alert));
    }

    @And("user quits browser")
    public void tearDown() {
        addressesPage.signOut();
        driver.close();
    }
}
