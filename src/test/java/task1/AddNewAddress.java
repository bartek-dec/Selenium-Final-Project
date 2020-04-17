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

public class AddNewAddress {

    private WebDriver driver;

    @Given("user logged in to account with first address already defined")
    public void logInToAccount() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterCredentials();
        loginPage.signIn();
    }

    @When("user goes to Addresses page")
    public void goToAddresses() {
        AccountPage accountPage = new AccountPage(driver);
        accountPage.getIntoAddresses();
    }

    @And("user clicks Create new address")
    public void goToNewAddressForm() {
        AddressesPage addressesPage = new AddressesPage(driver);
        addressesPage.getIntoNewAddress();
    }

    @And("user provides (.*), (.*), (.*), (.*), (.*), (.*) into the form")
    public void fillInAddressForm(String alias,
                                  String address,
                                  String city,
                                  String postCode,
                                  String countryValue,
                                  String phone) {
        NewAddressPage newAddressPage = new NewAddressPage(driver);

        newAddressPage.setAliasInput(alias);
        newAddressPage.setAddressInput(address);
        newAddressPage.setCityInput(city);
        newAddressPage.setPostCodeInput(postCode);
        newAddressPage.setCountryInput(countryValue);
        newAddressPage.setPhoneInput(phone);
    }

    @And("user saves data")
    public void saveAddressForm() {
        NewAddressPage newAddressPage = new NewAddressPage(driver);
        newAddressPage.saveForm();
    }

    @And("user deletes recent address")
    public void deleteRecentAddress() {
        AddressesPage addressesPage = new AddressesPage(driver);
        addressesPage.deleteRecentAddress();
        System.out.println();
    }

    @Then("recent address has been removed")
    public void checkConfirmation() {
        AddressesPage addressesPage = new AddressesPage(driver);
        Assert.assertTrue(addressesPage.getAlert().isDisplayed());
    }

    @And("user logs out")
    public void logOut() {
        AddressesPage addressesPage = new AddressesPage(driver);
        addressesPage.signOut();
    }

    @And("user close browser")
    public void tearDown() {
        driver.close();
    }
}