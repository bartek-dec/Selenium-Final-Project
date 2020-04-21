package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddressesPage extends HeaderPage {

    private WebDriver driver;

    @FindBy(partialLinkText = "Create new address")
    private WebElement createAddressButton;

    @FindBy(css = ".col-lg-4.col-md-6.col-sm-6")
    private List<WebElement> addresses;

    @FindBy(css = ".alert.alert-success")
    private WebElement alert;

    public AddressesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getIntoNewAddress() {
        createAddressButton.click();
    }

    public void deleteRecentAddress() {
        getRecentAddress().findElement(By.partialLinkText("Delete")).click();
    }

    public WebElement getAlert() {
        return alert;
    }

    public boolean containAlias(String alias) {
        WebElement aliasElement = getRecentAddress().findElement(By.tagName("h4"));
        return aliasElement.getText().contains(alias);
    }

    public boolean containAddress(String address) {
        WebElement addressElement = getRecentAddress().findElement(By.tagName("address"));
        return addressElement.getText().contains(address);
    }

    public boolean containCity(String city) {
        WebElement cityElement = getRecentAddress().findElement(By.tagName("address"));
        return cityElement.getText().contains(city);
    }

    public boolean containPostCode(String postCode) {
        WebElement postCodeElement = getRecentAddress().findElement(By.tagName("address"));
        return postCodeElement.getText().contains(postCode);
    }

    public boolean containCountry(String country) {
        WebElement countryElement = getRecentAddress().findElement(By.tagName("address"));
        return countryElement.getText().contains(country);
    }

    public boolean containPhone(String phone) {
        WebElement phoneElement = getRecentAddress().findElement(By.tagName("address"));
        return phoneElement.getText().contains(phone);
    }

    private WebElement getRecentAddress() {
        return addresses.get(addresses.size() - 1);
    }
}
