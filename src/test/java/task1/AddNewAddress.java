package task1;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.*;

public class AddNewAddress extends BaseClass {

    private LoginPage loginPage;
    private AccountPage accountPage;
    private AddressesPage addressesPage;
    private NewAddressPage newAddressPage;

    @Given("user logged in to account with first address already defined")
    public void logInToAccount() {
        setUp();

        loginPage = new LoginPage(driver);
        loginPage.enterCredentials();
        loginPage.signIn();
    }

    @When("user goes to Addresses page")
    public void goToAddresses() {
        accountPage = new AccountPage(driver);
        accountPage.getIntoAddresses();
    }

    @And("user clicks Create new address")
    public void goToNewAddressForm() {
        addressesPage = new AddressesPage(driver);
        addressesPage.getIntoNewAddress();
    }

    @And("user provides (.*), (.*), (.*), (.*), (.*), (.*) into the form")
    public void fillInAddressForm(String alias,
                                  String address,
                                  String city,
                                  String postCode,
                                  String countryValue,
                                  String phone) {
        newAddressPage = new NewAddressPage(driver);

        newAddressPage.setAliasInput(alias);
        newAddressPage.setAddressInput(address);
        newAddressPage.setCityInput(city);
        newAddressPage.setPostCodeInput(postCode);
        newAddressPage.setCountryInput(countryValue);
        newAddressPage.setPhoneInput(phone);
    }

    @And("user saves data")
    public void saveAddressForm() {
        newAddressPage.saveForm();
    }

    @Then("recent address contains alias (.*)")
    public void checkAlias(String alias) {
        Assert.assertTrue(addressesPage.containAlias(alias));
    }

    @And("recent address contains address (.*)")
    public void checkAddress(String address) {
        Assert.assertTrue(addressesPage.containAddress(address));
    }

    @And("recent address contains city (.*)")
    public void checkCity(String city) {
        Assert.assertTrue(addressesPage.containCity(city));
    }

    @And("recent address contains postCode (.*)")
    public void checkPostCode(String postCode) {
        Assert.assertTrue(addressesPage.containPostCode(postCode));
    }

    @And("recent address contains country (.*)")
    public void checkCountry(String country) {
        Assert.assertTrue(addressesPage.containCountry(country));
    }

    @And("recent address contains phone (.*)")
    public void checkPhone(String phone) {
        Assert.assertTrue(addressesPage.containPhone(phone));
    }

    @And("user close browser")
    public void tearDown() {
        addressesPage.deleteRecentAddress();
        addressesPage.signOut();
        driver.close();
    }
}
