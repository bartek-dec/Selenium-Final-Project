package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    private WebDriver driver;

    @FindBy(id = "addresses-link")
    private WebElement addresses;

    @FindBy(css = ".logo.img-responsive")
    private WebElement myStoreButton;

    @FindBy(id = "history-link")
    private WebElement orderHistory;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getIntoAddresses() {
        addresses.click();
    }

    public void goToMainPage() {
        myStoreButton.click();
    }

    public void goToOrderHistory() {
        orderHistory.click();
    }
}
