package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAddressPage {

    private WebDriver driver;

    @FindBy(name = "alias")
    private WebElement aliasInput;

    @FindBy(name = "address1")
    private WebElement addressInput;

    @FindBy(name = "city")
    private WebElement cityInput;

    @FindBy(name = "postcode")
    private WebElement postCodeInput;

    @FindBy(name = "id_country")
    private WebElement countryInput;

    @FindBy(name = "phone")
    private WebElement phoneInput;

    @FindBy(css = ".btn.btn-primary.float-xs-right")
    private WebElement saveButton;

    public NewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setAliasInput(String alias) {
        aliasInput.sendKeys(alias);
    }

    public void setAddressInput(String address) {
        addressInput.sendKeys(address);
    }

    public void setCityInput(String city) {
        cityInput.sendKeys(city);
    }

    public void setPostCodeInput(String postCode) {
        postCodeInput.sendKeys(postCode);
    }

    public void setCountryInput(String countryValue) {
        new Select(countryInput).selectByVisibleText(countryValue);
    }

    public void setPhoneInput(String phone) {
        phoneInput.sendKeys(phone);
    }

    public void saveForm() {
        saveButton.click();
    }
}
