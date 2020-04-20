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
        addresses.get(addresses.size() - 1)
                .findElement(By.partialLinkText("Delete")).click();
    }

    public WebElement getAlert() {
        return alert;
    }
}
